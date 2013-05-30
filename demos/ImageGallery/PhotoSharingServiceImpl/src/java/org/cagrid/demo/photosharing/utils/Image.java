/**
*============================================================================
*  Copyright The Ohio State University Research Foundation, The University of Chicago - 
*	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
*	Ekagra Software Technologies Ltd.
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-general/LICENSE.txt for details.
*============================================================================
**/
package org.cagrid.demo.photosharing.utils;


public class Image {

	private ImageDescription description;
	
	private String uu64encode;
	
	public Image(ImageDescription description, String uu64encode) {
		this.description = description;
		this.uu64encode = uu64encode;
	}
	
	public ImageDescription getDescription() {
		return description;
	}

	public String getImageData() {
		return uu64encode;
	}
	
	
}
