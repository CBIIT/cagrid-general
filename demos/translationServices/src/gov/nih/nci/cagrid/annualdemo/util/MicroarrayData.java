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
 * Created on Jan 27, 2007
 */
package gov.nih.nci.cagrid.annualdemo.util;

import java.util.ArrayList;

public class MicroarrayData
{
	public ArrayList<double[]> data = new ArrayList<double[]>();
	public ArrayList<String> arrayNames = new ArrayList<String>();
	public ArrayList<String> geneNames = new ArrayList<String>();
	
	public void invert()
	{
		double[][] inverted = new double[data.get(0).length][data.size()];
		for (int i = 0; i < inverted.length; i++) {
			for (int j = 0; j < inverted[i].length; j++) {
				inverted[i][j] = data.get(j)[i];
			}
		}
		data = new ArrayList<double[]>(inverted.length);
		for (double[] d : inverted) data.add(d);
		
	}

}
