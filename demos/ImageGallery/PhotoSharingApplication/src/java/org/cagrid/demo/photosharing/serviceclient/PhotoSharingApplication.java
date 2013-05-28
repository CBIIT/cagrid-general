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
package org.cagrid.demo.photosharing.serviceclient;

import gov.nih.nci.cagrid.common.security.ProxyUtil;

import java.awt.image.RenderedImage;

import javax.swing.JFrame;

import org.cagrid.demo.photosharing.gallery.client.GalleryClient;
import org.cagrid.demo.photosharing.guicomponents.PermissionsPanel;
import org.cagrid.demo.photosharing.utils.ImageType;
import org.cagrid.demo.photosharing.utils.ImageUtils;
import org.castor.util.Base64Decoder;
import org.castor.util.Base64Encoder;
import org.globus.gsi.GlobusCredential;

import com.sun.media.jai.widget.DisplayJAI;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.3
 */
public class PhotoSharingApplication {

	public static void usage(){
		System.out.println(PhotoSharingApplication.class.getName() + " -url <service url>");
	}

	public static void main(String [] args){
		System.out.println("Running the Photo Sharing Application");
		try{
			if(!(args.length < 2)){
				if(args[0].equals("-url")){
					org.cagrid.demo.photosharing.client.PhotoSharingClient client = new org.cagrid.demo.photosharing.client.PhotoSharingClient(args[1]);
					// place client calls here if you want to use this main as a
					// test....
					GlobusCredential userCredential = ProxyUtil.getDefaultProxy();
					System.out.println("Logged in as: " + userCredential.getIdentity());

					String galleryName = "Summer Vacation";
					GalleryClient galleryClient = client.createGallery(galleryName);

					
					//list that our identity is in the list of viewers and adders
					org.cagrid.demo.photosharing.domain.User[] viewers = galleryClient.listAllUsersWithViewPrivileges();
					
					if (viewers == null) {
						throw new RuntimeException("Gallery viewers not expected to be null!");
					}
					for (org.cagrid.demo.photosharing.domain.User viewer : viewers) {
						if (!(viewer.getUserIdentity().equals(userCredential.getIdentity()))) {
							throw new RuntimeException("Gallery owner isn't in the list of viewers!");
						}
					}

					//list that our identity is in the list of adders
					org.cagrid.demo.photosharing.domain.User[] adders = galleryClient.listAllUsersWithViewPrivileges();

					if (adders == null) {
						throw new RuntimeException("Gallery adders not expected to be null!");
					}

					for (org.cagrid.demo.photosharing.domain.User adder : adders) {
						if (!(adder.getUserIdentity().equals(userCredential.getIdentity()))) {
							throw new RuntimeException("Gallery owner isn't in the list of adders!");
						}
					}
					
					
					//list galleries... ensure ours is there.
					GalleryClient[] galleries = client.listGalleries();
					if (!(galleries[0].getGalleryName()).equals(galleryName)) {
						throw new RuntimeException("Gallery isn't present!");
					}

					//remove gallery and test that it was removed properly
					galleryClient.destroy();

					galleries = client.listGalleries();
					//if the gallery list is empty, we actually get a null back instead of an empty List... this is due to Axis serialization issues
					if (galleries != null) {
						throw new RuntimeException("Gallery wasn't destroyed!");
					}

					galleryClient = client.createGallery(galleryName);

					
					PermissionsPanel panel = new PermissionsPanel(galleryClient);
					
					JFrame permissionsFrame = new JFrame();
					
					permissionsFrame.getContentPane().add(panel.getPermissionsPanel());
					
					permissionsFrame.pack();
					permissionsFrame.show();
					
					System.out.println("Test");
					Thread.sleep(10000);

					String testIdentity = userCredential.getIdentity() + "testinguser";
					org.cagrid.demo.photosharing.domain.User user = new org.cagrid.demo.photosharing.domain.User();
					user.setId(Long.valueOf(0));
					user.setUserIdentity(testIdentity);
					galleryClient.grantAddImagePrivileges(user);
					galleryClient.grantViewGalleryPrivileges(user);

					System.out.println("Test");
					Thread.sleep(10000);
					
					
					boolean ownerIsPresent = false;
					boolean testuserIsPresent = false;
					//list that our identity is in the list of viewers and adders
					viewers = galleryClient.listAllUsersWithViewPrivileges();
					for (org.cagrid.demo.photosharing.domain.User viewer : viewers) {
						if (viewer.getUserIdentity().equals(userCredential.getIdentity())) {
							ownerIsPresent = true;
						}
						if (viewer.getUserIdentity().equals(testIdentity)) {
							testuserIsPresent = true;
						}
					}
					
					if (!(ownerIsPresent && testuserIsPresent)) {
						throw new RuntimeException("Expected both owner and test user in the list of viewers!");
					}

					ownerIsPresent = false;
					testuserIsPresent = false;
					//list that our identity is in the list of adders
					adders = galleryClient.listAllUsersWithViewPrivileges();
					for (org.cagrid.demo.photosharing.domain.User adder : adders) {
						if (adder.getUserIdentity().equals(userCredential.getIdentity())) {
							ownerIsPresent = true;
						}
						if (adder.getUserIdentity().equals(testIdentity)) {
							testuserIsPresent = true;
						}
					}
					
					if (!(ownerIsPresent && testuserIsPresent)) {
						throw new RuntimeException("Expected both owner and test user in the list of viewers!");
					}
					
					galleryClient.revokeAddImagePrivileges(user);
					galleryClient.revokeViewGalleryPrivileges(user);

					//check that only one user is there now
					//list that our identity is in the list of viewers and adders
					viewers = galleryClient.listAllUsersWithViewPrivileges();
					for (org.cagrid.demo.photosharing.domain.User viewer : viewers) {
						if (!(viewer.getUserIdentity().equals(userCredential.getIdentity()))) {
							throw new RuntimeException("Gallery owner isn't in the list of viewers!");
						}
					}

					//list that our identity is in the list of adders
					adders = galleryClient.listAllUsersWithViewPrivileges();
					for (org.cagrid.demo.photosharing.domain.User adder : adders) {
						if (!(adder.getUserIdentity().equals(userCredential.getIdentity()))) {
							throw new RuntimeException("Gallery owner isn't in the list of adders!");
						}
					}
					
					System.out.println("Test");
					Thread.sleep(10000);

					
					
					String imageName = "OSU Medical Center Logo";
					String imageDescription = "Displaying OSU Medical Center Logo";

					byte[] imageBytes = ImageUtils.loadImageAsBytes("osu_medcenter logo.jpg");
					//Note: only the castor Base64Encoder encodes properly... the Sun one doesn't (corrupts image)
					String encoded = new String(Base64Encoder.encode(imageBytes));

					org.cagrid.demo.photosharing.domain.ImageDescription beanDesc = new org.cagrid.demo.photosharing.domain.ImageDescription();
					beanDesc.setId(Long.valueOf(0)); //doesn't matter what this is set to
					beanDesc.setDescription(imageDescription);
					beanDesc.setName(imageName);
					beanDesc.setType(ImageType.JPG.name());

					org.cagrid.demo.photosharing.domain.Image beanImage = new org.cagrid.demo.photosharing.domain.Image();
					beanImage.setId(Long.valueOf(0)); //doesn't matter what this is set to

					beanImage.setImageDescription(beanDesc);
					beanImage.setData(encoded);

					//this ImageDescription instance contains a real image ID (returned from server)
					org.cagrid.demo.photosharing.domain.ImageDescription galleryImageDescription = galleryClient.addImage(beanImage);

					org.cagrid.demo.photosharing.domain.ImageDescription[] imageDescriptions = galleryClient.listImages();


					for (org.cagrid.demo.photosharing.domain.ImageDescription desc : imageDescriptions) {

						org.cagrid.demo.photosharing.domain.Image image = galleryClient.getImage(desc);
						System.out.println(image.getImageDescription().getId());
						System.out.println(image.getImageDescription().getName());
						System.out.println(image.getImageDescription().getDescription());
						System.out.println(image.getImageDescription().getType());
						System.out.println(image.getData());
					}

					try {

						//create image with ID that doesn't exist
						beanDesc = new org.cagrid.demo.photosharing.domain.ImageDescription();
						beanDesc.setId(Long.valueOf(1314)); //doesn't matter what this is set to
						beanDesc.setDescription(imageDescription);
						beanDesc.setName(imageName);
						beanDesc.setType(ImageType.JPG.name());

						galleryClient.getImage(beanDesc);
						System.err.println("found image that shouldn't exist!");
					} catch(org.cagrid.demo.photosharing.stubs.types.PhotoSharingException e) {
						System.out.println("Correctly received image not found exception");
					}

					//test image permissions... DISABLED for the moment in the service (hard-coded)
					/*
					String fakeIdentity = userCredential.getIdentity() + "fakeappended";
					galleryClient.grantImageRetrievalPrivileges(galleryImageDescription, user);
					//now try to retrieve image
					try {
						galleryClient.getImage(galleryImageDescription);
						System.out.println("Image authorization FAILED********");
					} catch(Exception e) {
						System.out.println("Image authorization worked");
					}

					//now add us and confirm retrieval
					org.cagrid.demo.photosharing.domain.User realUser = new org.cagrid.demo.photosharing.domain.User();
					realUser.setId(Long.valueOf(0));
					realUser.setUserIdentity(userCredential.getIdentity());

					galleryClient.grantImageRetrievalPrivileges(galleryImageDescription, realUser);
					//now try to retrieve image
					 */
					org.cagrid.demo.photosharing.domain.Image image = galleryClient.getImage(galleryImageDescription);

					byte[] imageDataFromServer = Base64Decoder.decode(image.getData());
					RenderedImage renderedImage = ImageUtils.loadImageFromBytes(imageDataFromServer);
					DisplayJAI display = new DisplayJAI(renderedImage);

					JFrame frame = new JFrame();
					frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
					frame.getContentPane().add(display);
					frame.pack();
					frame.show();

				} else {
					usage();
					System.exit(1);
				}
			} else {
				usage();
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}


}
