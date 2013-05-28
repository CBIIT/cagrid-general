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
package org.cagrid.demo.photosharing.gallery.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public interface GalleryI {

  public org.oasis.wsrf.lifetime.DestroyResponse destroy(org.oasis.wsrf.lifetime.Destroy params) throws RemoteException ;

  public org.oasis.wsrf.lifetime.SetTerminationTimeResponse setTerminationTime(org.oasis.wsrf.lifetime.SetTerminationTime params) throws RemoteException ;

  /**
   * Add an image to the gallery
   *
   * @param image
   * @throws PhotoSharingException
   *	
   * @throws AuthorizationException
   *	
   */
  public org.cagrid.demo.photosharing.domain.ImageDescription addImage(org.cagrid.demo.photosharing.domain.Image image) throws RemoteException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException ;

  /**
   * List all images in the gallery
   *
   * @throws AuthorizationException
   *	
   */
  public org.cagrid.demo.photosharing.domain.ImageDescription[] listImages() throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException ;

  /**
   * Retrieve an image
   *
   * @param imageDescription
   * @throws AuthorizationException
   *	
   * @throws PhotoSharingException
   *	
   */
  public org.cagrid.demo.photosharing.domain.Image getImage(org.cagrid.demo.photosharing.domain.ImageDescription imageDescription) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * Grant privileges for a user to view the gallery
   *
   * @param user
   * @throws AuthorizationException
   *	
   * @throws PhotoSharingException
   *	
   */
  public void grantViewGalleryPrivileges(org.cagrid.demo.photosharing.domain.User user) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * Revoke privileges for a user to view the gallery
   *
   * @param user
   * @throws AuthorizationException
   *	
   * @throws PhotoSharingException
   *	
   */
  public void revokeViewGalleryPrivileges(org.cagrid.demo.photosharing.domain.User user) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * Grant privileges to add an image to the gallery
   *
   * @param user
   * @throws AuthorizationException
   *	
   * @throws PhotoSharingException
   *	
   */
  public void grantAddImagePrivileges(org.cagrid.demo.photosharing.domain.User user) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * Revoke privileges to add an image to the gallery
   *
   * @param user
   * @throws AuthorizationException
   *	
   * @throws PhotoSharingException
   *	
   */
  public void revokeAddImagePrivileges(org.cagrid.demo.photosharing.domain.User user) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * Grant privileges to retrieve a specific image
   *
   * @param imageDescription
   * @param user
   * @throws AuthorizationException
   *	
   * @throws PhotoSharingException
   *	
   */
  public void grantImageRetrievalPrivileges(org.cagrid.demo.photosharing.domain.ImageDescription imageDescription,org.cagrid.demo.photosharing.domain.User user) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * Revoke privileges to retrieve a specific image
   *
   * @param imageDescription
   * @param user
   * @throws AuthorizationException
   *	
   * @throws PhotoSharingException
   *	
   */
  public void revokeImageRetrievalPrivileges(org.cagrid.demo.photosharing.domain.ImageDescription imageDescription,org.cagrid.demo.photosharing.domain.User user) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * Get the name of this gallery
   *
   * @throws PhotoSharingException
   *	
   */
  public java.lang.String getGalleryName() throws RemoteException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * List all users that have add privileges on the gallery
   *
   * @throws PhotoSharingException
   *	
   */
  public org.cagrid.demo.photosharing.domain.User[] listUsersWithAddPrivileges() throws RemoteException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

  /**
   * List all users that have view privileges on the gallery
   *
   * @throws PhotoSharingException
   *	
   */
  public org.cagrid.demo.photosharing.domain.User[] listAllUsersWithViewPrivileges() throws RemoteException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException ;

}

