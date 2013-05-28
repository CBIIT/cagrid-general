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
package org.cagrid.demo.photosharing.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public interface PhotoSharingI {

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  /**
   * Create a photo gallery
   *
   * @param galleryName
   * @throws PhotoSharingException
   *	
   */
  public org.cagrid.demo.photosharing.gallery.client.GalleryClient createGallery(java.lang.String galleryName) throws RemoteException, org.apache.axis.types.URI.MalformedURIException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * List all galleries
   *
   */
  public org.cagrid.demo.photosharing.gallery.client.GalleryClient[] listGalleries() throws RemoteException, org.apache.axis.types.URI.MalformedURIException ;

}

