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
package gov.nih.nci.cagrid.annualdemo.service;

import gov.nih.nci.cagrid.annualdemo.service.globus.resource.BaseResource;
import gov.nih.nci.cagrid.annualdemo.service.ServiceConfiguration;

import java.rmi.RemoteException;

import javax.naming.InitialContext;
import javax.xml.namespace.QName;

import org.apache.axis.MessageContext;
import org.globus.wsrf.Constants;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.ResourceContextException;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceHome;
import org.globus.wsrf.ResourceProperty;
import org.globus.wsrf.ResourcePropertySet;
/** 
 * Provides some simple accessors for the Impl.
 * 
 * @created by Introduce Toolkit version 1.0
 * 
 */
public abstract class MageTranslationServicesImplBase {
	
	public MageTranslationServicesImplBase() throws RemoteException {
	
	}
	
	public ServiceConfiguration getConfiguration() throws Exception {
		return ServiceConfiguration.getConfiguration();
	}
	
	
	public gov.nih.nci.cagrid.annualdemo.service.globus.resource.BaseResourceHome getResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("home");
		return (gov.nih.nci.cagrid.annualdemo.service.globus.resource.BaseResourceHome)resource;
	}

	
	
	
	
	protected ResourceHome getResourceHome(String resourceKey) throws Exception {
		MessageContext ctx = MessageContext.getCurrentContext();

		ResourceHome resourceHome = null;
		
		String servicePath = ctx.getTargetService();

		String jndiName = Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + resourceKey;
		try {
			javax.naming.Context initialContext = new InitialContext();
			resourceHome = (ResourceHome) initialContext.lookup(jndiName);
		} catch (Exception e) {
			throw new Exception("Unable to instantiate resource home. : " + resourceKey, e);
		}

		return resourceHome;
	}
	
		
	
	
	protected Object getMetadata(QName metadataQName) {
		BaseResource serviceBaseResource = null;
		try {
			serviceBaseResource = (BaseResource) ResourceContext.getResourceContext().getResource();
		} catch (ResourceContextException e) {
			return null;
		} catch (ResourceException e) {
			return null;
		}
		ResourcePropertySet resourcePropertySet = serviceBaseResource.getResourcePropertySet();
		if (resourcePropertySet != null) {
			ResourceProperty property = resourcePropertySet.get(metadataQName);
			if (property != null) {
				return property.get(0);
			}

		}
		return null;
	}
	


}

