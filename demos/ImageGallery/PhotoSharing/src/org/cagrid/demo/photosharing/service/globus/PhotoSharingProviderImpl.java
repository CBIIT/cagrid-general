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
package org.cagrid.demo.photosharing.service.globus;

import org.cagrid.demo.photosharing.service.PhotoSharingImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the PhotoSharingImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public class PhotoSharingProviderImpl{
	
	PhotoSharingImpl impl;
	
	public PhotoSharingProviderImpl() throws RemoteException {
		impl = new PhotoSharingImpl();
	}
	

    public org.cagrid.demo.photosharing.stubs.CreateGalleryResponse createGallery(org.cagrid.demo.photosharing.stubs.CreateGalleryRequest params) throws RemoteException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.stubs.CreateGalleryResponse boxedResult = new org.cagrid.demo.photosharing.stubs.CreateGalleryResponse();
    boxedResult.setGalleryReference(impl.createGallery(params.getGalleryName()));
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.stubs.ListGalleriesResponse listGalleries(org.cagrid.demo.photosharing.stubs.ListGalleriesRequest params) throws RemoteException {
    org.cagrid.demo.photosharing.stubs.ListGalleriesResponse boxedResult = new org.cagrid.demo.photosharing.stubs.ListGalleriesResponse();
    boxedResult.setGalleryReference(impl.listGalleries());
    return boxedResult;
  }

}
