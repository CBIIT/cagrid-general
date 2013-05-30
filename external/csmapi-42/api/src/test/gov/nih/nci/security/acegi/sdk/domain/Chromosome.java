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

public class Chromosome {
	private String junk;

	public Chromosome(String junk1){
		this.junk=junk1;
	}
	
	public String getJunk() {
		return junk;
	}

	public void setJunk(String junk) {
		this.junk = junk;
	}
}
