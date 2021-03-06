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
package gov.nih.nci.cagrid.annualdemo.service.globus.resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.globus.wsrf.Resource;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceKey;
import org.globus.wsrf.impl.SingletonResourceHome;
import org.globus.wsrf.jndi.Initializable;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.ResourceContextException;


/**
 * This class implements a resource home
 */

public class BaseResourceHome extends SingletonResourceHome implements Initializable {

	static final Log logger = LogFactory.getLog(BaseResourceHome.class);


	public Resource findSingleton() {
		logger.info("Creating a single resource.");
		try {
			BaseResource resource = new BaseResource();
			resource.initialize();
			return resource;
		} catch (Exception e) {
			logger.error("Exception when creating the resource: " + e);
			return null;
		}
	}
	
	public BaseResource getResource(){
		BaseResource serviceBaseResource;
		try {
			serviceBaseResource = (BaseResource)ResourceContext.getResourceContext().getResource();
		} catch (ResourceContextException e) {
			return null;
		} catch (ResourceException e) {
			return null;
		}
		return serviceBaseResource;
	}


	public Resource find(ResourceKey key) throws ResourceException {
		BaseResource resource = (BaseResource) super.find(key);
		// each time the resource is looked up, do a lazy refreash of
		// registration.
		resource.refreshRegistration(false);
		return resource;
	}


	/**
	 * Initialze the singleton resource, when the home is initialized.
	 */
	public void initialize() throws Exception {
		logger.info("Attempting to initialize resource.");
		Resource resource = find(null);
		if (resource == null) {
			logger.error("Unable to initialize resource!");
		} else {
			logger.info("Successfully initialized resource.");
		}
	}
}
