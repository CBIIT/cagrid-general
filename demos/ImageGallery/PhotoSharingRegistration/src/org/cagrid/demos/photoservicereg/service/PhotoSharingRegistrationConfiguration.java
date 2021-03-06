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
package org.cagrid.demos.photoservicereg.service;

import gov.nih.nci.cagrid.introduce.servicetools.ServiceConfiguration;

import org.globus.wsrf.config.ContainerConfig;
import java.io.File;
import javax.naming.InitialContext;

import org.apache.axis.MessageContext;
import org.globus.wsrf.Constants;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 * 
 * This class holds all service properties which were defined for the service to have
 * access to.
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public class PhotoSharingRegistrationConfiguration implements ServiceConfiguration {

	public static PhotoSharingRegistrationConfiguration  configuration = null;
    public String etcDirectoryPath;
    	
	public static PhotoSharingRegistrationConfiguration getConfiguration() throws Exception {
		if (PhotoSharingRegistrationConfiguration.configuration != null) {
			return PhotoSharingRegistrationConfiguration.configuration;
		}
		MessageContext ctx = MessageContext.getCurrentContext();

		String servicePath = ctx.getTargetService();

		String jndiName = Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/serviceconfiguration";
		try {
			javax.naming.Context initialContext = new InitialContext();
			PhotoSharingRegistrationConfiguration.configuration = (PhotoSharingRegistrationConfiguration) initialContext.lookup(jndiName);
		} catch (Exception e) {
			throw new Exception("Unable to instantiate service configuration.", e);
		}

		return PhotoSharingRegistrationConfiguration.configuration;
	}
	

	
	private String gridGrouperURL;
	
	private String photoSharingStemSystemName;
	
	
    public String getEtcDirectoryPath() {
		return ContainerConfig.getBaseDirectory() + File.separator + etcDirectoryPath;
	}
	
	public void setEtcDirectoryPath(String etcDirectoryPath) {
		this.etcDirectoryPath = etcDirectoryPath;
	}


	
	public String getGridGrouperURL() {
		return gridGrouperURL;
	}
	
	
	public void setGridGrouperURL(String gridGrouperURL) {
		this.gridGrouperURL = gridGrouperURL;
	}

	
	public String getPhotoSharingStemSystemName() {
		return photoSharingStemSystemName;
	}
	
	
	public void setPhotoSharingStemSystemName(String photoSharingStemSystemName) {
		this.photoSharingStemSystemName = photoSharingStemSystemName;
	}

	
}
