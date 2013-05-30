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
package test.gov.nih.nci.security;

import gov.nih.nci.security.SecurityServiceProvider;
import gov.nih.nci.security.UserProvisioningManager;
import gov.nih.nci.security.exceptions.CSConfigurationException;
import gov.nih.nci.security.exceptions.CSException;
import junit.framework.TestCase;


public class NewConfigruationTest extends TestCase
{

	public static void main(String[] args)
	{
	}

	/*
	 * Test method for 'gov.nih.nci.security.SecurityServiceProvider.getUserProvisioningManager(String)'
	 */
	public void testGetUserProvisioningManagerString() throws CSConfigurationException, CSException
	{
		UserProvisioningManager userProvisioningManager = SecurityServiceProvider.getUserProvisioningManager("security");
		assertNotNull(userProvisioningManager);
	}

	/*
	 * Test method for 'gov.nih.nci.security.SecurityServiceProvider.getAuthorizationManager(String)'
	 */
	public void testGetAuthorizationManagerString()
	{

	}

	/*
	 * Test method for 'gov.nih.nci.security.SecurityServiceProvider.getUserProvisioningManager(String, HashMap)'
	 */
	public void testGetUserProvisioningManagerStringHashMap()
	{

	}

}
