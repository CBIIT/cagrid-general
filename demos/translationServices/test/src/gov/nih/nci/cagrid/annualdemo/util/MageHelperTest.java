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
/*
 * Created on Jan 25, 2007
 */
package gov.nih.nci.cagrid.annualdemo.util;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class MageHelperTest
	extends TestCase
{
	public MageHelperTest(String name)
	{
		super(name);
	}
	
	public void testFetchBioassay()
		throws Exception
	{
		MageHelper helper = new MageHelper();
		String bioassay = helper.fetchBioassay(
			"gov.nih.nci.ncicb.caarray:MeasuredBioAssayData:1015897540501674:1"
		);
		System.out.println(bioassay);
	}
	
	public static void main(String[] args) throws Exception
	{
		TestRunner runner = new TestRunner();
		TestResult result = runner.doRun(new TestSuite(MageHelperTest.class));
		System.exit(result.errorCount() + result.failureCount());
	}
}
