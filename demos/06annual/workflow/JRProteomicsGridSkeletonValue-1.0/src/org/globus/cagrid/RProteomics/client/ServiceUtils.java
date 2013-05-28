/**
*============================================================================
*  Copyright The Ohio State University Research Foundation, The University of Chicago - 
*	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
*	Ekagra Software Technologies Ltd.
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-core/LICENSE.txt for details.
*============================================================================
**/
/*
 * Created on Mar 10, 2006
 */
package org.globus.cagrid.RProteomics.client;

import edu.duke.cabig.rproteomics.domain.serviceinterface.*;
import gov.nih.nci.cagrid.common.Utils;

import java.io.File;
import java.io.FileFilter;

public class ServiceUtils
{
	public static ScanFeaturesType[] readScanFeaturesFromDir(File dir) 
		throws Exception
	{
		  File[] files = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile();
			}
		  });
		  ScanFeaturesType[] scans = new ScanFeaturesType[files.length];
		  for (int i = 0; i < files.length; i++) {
			  scans[i] = readScanFeaturesFromFile(files[i]);
		  }
		  return scans;
	}
	
	public static ScanFeaturesType readScanFeaturesFromFile(File file)
		throws Exception
	{
		return (ScanFeaturesType) Utils.deserializeDocument(file.toString(), ScanFeaturesType.class);
	}
}
