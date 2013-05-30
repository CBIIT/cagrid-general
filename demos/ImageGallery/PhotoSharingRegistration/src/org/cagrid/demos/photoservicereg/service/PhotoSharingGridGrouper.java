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

import edu.internet2.middleware.grouper.GrouperRuntimeException;
import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.gridgrouper.client.GridGrouper;

public class PhotoSharingGridGrouper extends GridGrouper {

	public PhotoSharingGridGrouper(String serviceURI, boolean preferAnonymous) {
		super(serviceURI, null);
		try {
			this.getClient().setAnonymousPrefered(preferAnonymous);
		} catch (Exception e) {
			getLog().error(e.getMessage(), e);
			throw new GrouperRuntimeException(Utils.getExceptionMessage(e));
		}
	}
}
