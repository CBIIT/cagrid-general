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
package org.globus.cagrid.RProteomics.service.globus.resource;

import javax.xml.namespace.QName;


public interface ResourceConstants {
	public static final String SERVICE_NS = "http://www.globus.org/namespaces/cagrid/RProteomics/RProteomics";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "RProteomicsKey");
	public static final QName RESOURCE_PROPERY_SET = new QName(SERVICE_NS, "RProteomicsResourceProperties");

	//Service level metadata (exposed as resouce properties)
	
}
