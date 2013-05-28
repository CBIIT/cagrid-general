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
/**
 * 
 */
package org.cagrid.demo.photosharing.utils;

import gov.nih.nci.cagrid.gridgrouper.grouper.GroupI;
import gov.nih.nci.cagrid.gridgrouper.grouper.StemI;

class GalleryInfo {
	
	public StemI getGalleryStem() {
		return galleryStem;
	}

	public GroupI getViewPhotosGroup() {
		return viewPhotosGroup;
	}

	public GroupI getAddPhotosGroup() {
		return addPhotosGroup;
	}

	private StemI galleryStem;
	
	private GroupI viewPhotosGroup;
	
	private GroupI addPhotosGroup;

	private String galleryOwnerIdentity;
	
	public String getGalleryOwnerIdentity() {
		return galleryOwnerIdentity;
	}

	public GalleryInfo(String galleryOwnerIdentity, StemI galleryStem, GroupI viewPhotosGroup, GroupI addPhotosGroup) {
		this.galleryOwnerIdentity = galleryOwnerIdentity;
		this.galleryStem = galleryStem;
		this.viewPhotosGroup = viewPhotosGroup;
		this.addPhotosGroup = addPhotosGroup;
		
	}
}
