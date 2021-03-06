/*
 * Portions of this file Copyright 1999-2005 University of Chicago
 * Portions of this file Copyright 1999-2005 The University of Southern California.
 *
 * This file or a portion of this file is licensed under the
 * terms of the Globus Toolkit Public License, found at
 * http://www.globus.org/toolkit/download/license.html.
 * If you redistribute this file, with or without
 * modifications, you must include this notice in the file.
 */
package org.globus.gatekeeper.jobmanager.internal;

import java.io.IOException;
import java.io.InputStream;

import org.globus.util.http.HTTPRequestParser;
import org.globus.util.Util;
import org.globus.gram.internal.GRAMProtocol;
import org.globus.gatekeeper.jobmanager.JobManagerService;
import org.globus.gatekeeper.jobmanager.JobManagerException;


public class JobManagerRequest extends HTTPRequestParser {

    private JobManagerService _jobManager;
    
    public JobManagerRequest(JobManagerService jobManager, InputStream in) 
	throws IOException, JobManagerException {
	super(in);
	setJobManager(jobManager);
	parseRequest();
    }
    
    public void setJobManager(JobManagerService jobManager) {
	_jobManager = jobManager;
    }

    public void parseRequest() 
	throws IOException, JobManagerException {
	
	String line = null;

	line = getValueForToken(GRAMProtocol.PROTOCOL_VERSION);
	if ( !line.equals(String.valueOf(GRAMProtocol.GRAM_PROTOCOL_VERSION)) ) {
	    throw new JobManagerException(JobManagerException.VERSION_MISMATCH);
	}
	
	line = _reader.readLine();
	try {
	    line = Util.unquote(line);
	} catch(Exception e) {
	    throw new JobManagerException("bad request");
	}

	if (line.regionMatches(true, 0, GRAMProtocol.CANCEL, 0, 
			       GRAMProtocol.CANCEL.length())) {
	    _jobManager.cancel();
	} else if (line.regionMatches(true, 0, GRAMProtocol.STATUS, 0, 
				      GRAMProtocol.STATUS.length())) {
	    // don't do anything - the status will be send
	} else if (line.regionMatches(true, 0, GRAMProtocol.REGISTER, 0,
				      GRAMProtocol.REGISTER.length())) {
	    line = getRest(line, GRAMProtocol.REGISTER.length());
	    int pos = line.indexOf(" ");
	    if (pos == -1) {
		throw new JobManagerException(JobManagerException.HTTP_UNPACK_FAILED);
	    }
	    int stateMask = 0;
	    try {
		stateMask = Integer.parseInt(line.substring(0, pos).trim());
	    } catch(Exception e) {
		throw new JobManagerException(JobManagerException.HTTP_UNPACK_FAILED);
	    }
	    _jobManager.register(line.substring(pos+1), stateMask);
	} else if (line.regionMatches(true, 0, GRAMProtocol.UNREGISTER, 0, 
				      GRAMProtocol.UNREGISTER.length())) {
	    line = getRest(line, GRAMProtocol.UNREGISTER.length());
	    _jobManager.unregister(line);
	} else if (line.regionMatches(true, 0, GRAMProtocol.SIGNAL, 0, 
				      GRAMProtocol.SIGNAL.length())) {
	    line = getRest(line, GRAMProtocol.SIGNAL.length());
            int pos = line.indexOf(" ");
            if (pos == -1) {
                throw new JobManagerException(JobManagerException.HTTP_UNPACK_FAILED);
            }
            int signal = 0;
            try {
                signal = Integer.parseInt(line.substring(0, pos).trim());
            } catch(Exception e) {
                throw new JobManagerException(JobManagerException.HTTP_UNPACK_FAILED);
            }
            _jobManager.signal(signal, line.substring(pos+1));
	} else {
	    throw new JobManagerException(JobManagerException.INVALID_JOB_QUERY);
	}
    }
    
    private String getValueForToken(String expected)
        throws IOException, JobManagerException {
        String line = _reader.readLine();
        if (line != null && !line.regionMatches(true, 0, expected, 0, expected.length())) {
            throw new JobManagerException("bad request");
        }
        return getRest(line, expected.length());
    }

}
