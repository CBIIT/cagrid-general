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
package gov.nih.nci.security.util;



import gov.nih.nci.security.authorization.domainobjects.ProtectionGroupRoleContext;

import java.util.Comparator;

public class ProtectionGroupRoleContextComparator implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		ProtectionGroupRoleContext p1 = (ProtectionGroupRoleContext)o1;
		ProtectionGroupRoleContext p2 = (ProtectionGroupRoleContext)o2;
		return p1.getProtectionGroup().getProtectionGroupName().compareToIgnoreCase(p2.getProtectionGroup().getProtectionGroupName());
	}
}