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
package test.gov.nih.nci.security.acegi.sdk.domain;

public class Taxon {
	
	private String attribute;
	
	public Taxon(String str){
		this.attribute=str;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String someAttribute) {
		this.attribute = someAttribute;
	}

}
