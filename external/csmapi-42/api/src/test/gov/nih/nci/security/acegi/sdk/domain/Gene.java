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
package test.gov.nih.nci.security.acegi.sdk.domain;

public class Gene {
	
	private String someAttribute;
	public Gene(String str){
		this.someAttribute=str;
	}
	public String getSomeAttribute() {
		return someAttribute;
	}
	public void setSomeAttribute(String someAttribute) {
		this.someAttribute = someAttribute;
	}

}
