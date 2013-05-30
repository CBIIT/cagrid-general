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
package gov.nih.nci.cagrid.annualdemo.service;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.cqlresultset.CQLQueryResults;
import gridextensions.Data;

import java.io.File;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class MageTranslationServicesImplTest
	extends TestCase
{
	public MageTranslationServicesImplTest(String name)
	{
		super(name);
	}
	
	public void testMageToStatML()
		throws Exception
	{
		/*
		DOMParser parser = new DOMParser();
		parser.parse("test" + File.separator + "resources" + File.separator + "mage.xml");
		
		CQLQueryResults results = new CQLQueryResults();
		
		CQLObjectResult result = new CQLObjectResult();
		
		results.setObjectResult(new CQLObjectResult[] { result });

		MessageElement message = new MessageElement(parser.getDocument().getDocumentElement());
		result.set_any(new MessageElement[] { message });
		*/

		CQLQueryResults results = (CQLQueryResults) Utils.deserializeDocument(
			"test" + File.separator + "resources" + File.separator + "mage.xml",
			CQLQueryResults.class
		);
		
		MageTranslationServicesImpl service = new MageTranslationServicesImpl();
		Data staml = service.mageToStatML(results);
	}
	
	public static void main(String[] args) throws Exception
	{
		TestRunner runner = new TestRunner();
		TestResult result = runner.doRun(new TestSuite(MageTranslationServicesImplTest.class));
		System.exit(result.errorCount() + result.failureCount());
	}
}
