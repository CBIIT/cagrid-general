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
package org.globus.ftp.dc;

import java.io.OutputStream;
import java.io.IOException;

import org.globus.ftp.Buffer;

public class StreamImageDCWriter implements DataChannelWriter {

    protected OutputStream output;
    
    public void setDataStream(OutputStream out) {
	output = out;
    }

    public void write(Buffer buf)
	throws IOException {
	output.write(buf.getBuffer(), 0, buf.getLength());
    }

    public void endOfData() throws IOException {};
    
    public void close() 
	throws IOException {
	output.close(); 
    }
}
