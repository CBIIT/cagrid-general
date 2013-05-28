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
package org.cagrid.demo.photosharing.utils;

public enum ImageType {

	PNG ("PNG"),
	JPG ("JPG");

	private String extension;
	
	ImageType(String extension) {
		this.extension = extension;
	}
	
	public String getExtension() {
		return this.extension;
	}
	
	@Override
	public String toString() {
		return this.extension;
	}
	
}
