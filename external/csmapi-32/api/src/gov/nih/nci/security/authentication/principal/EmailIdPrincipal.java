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
package gov.nih.nci.security.authentication.principal;

import java.security.Principal;

import javax.security.auth.Subject;


/**
 * This class holds the Email Id of the user retrieved. It would be returned as part of the <code>JAAS</code>
 * {@link Subject} to the calling application
 * 
 * @author Kunal Modi (Ekagra Software Technologies Ltd.)
 */
public class EmailIdPrincipal extends BasePrincipal
{

	/**
	 * This Constructor accepts the email id value which would be stored in this {@link Principal}
	 * @param name the email id value to be stored
	 */
	public EmailIdPrincipal(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}

}
