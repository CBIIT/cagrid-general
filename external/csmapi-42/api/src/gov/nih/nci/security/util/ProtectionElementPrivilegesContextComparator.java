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
package gov.nih.nci.security.util;

import gov.nih.nci.security.authorization.domainobjects.ProtectionElementPrivilegeContext;

import java.util.Comparator;

public class ProtectionElementPrivilegesContextComparator  implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		ProtectionElementPrivilegeContext p1 = (ProtectionElementPrivilegeContext)o1;
		ProtectionElementPrivilegeContext p2 = (ProtectionElementPrivilegeContext)o2;
		return p1.getProtectionElement().getProtectionElementName().compareToIgnoreCase(p2.getProtectionElement().getProtectionElementName());
	}
}