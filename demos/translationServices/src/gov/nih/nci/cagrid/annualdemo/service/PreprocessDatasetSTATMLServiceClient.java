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
package gov.nih.nci.cagrid.annualdemo.service;

import edu.duke.cabig.javar.io.StatMLSerializer;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;
import gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata;
import gridextensions.Array;
import gridextensions.Data;
import gridextensions.PreprocessDatasetParameterSet;

import java.io.InputStream;
import java.rmi.RemoteException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.axis.utils.ClassUtils;
import org.genepattern.cabig.util.StatmlConverter;
import org.genepattern.cagrid.service.preprocessdataset.statml.common.PreprocessDatasetSTATMLServiceI;
import org.genepattern.cagrid.service.preprocessdataset.statml.stubs.PreprocessDatasetSTATMLServicePortType;
import org.genepattern.cagrid.service.preprocessdataset.statml.stubs.service.PreprocessDatasetSTATMLServiceAddressingLocator;
import org.globus.gsi.GlobusCredential;

/**
 * Test client for use with PreprocessDatasetSTATMLService.  It creates test
 * data, invokes the service, retrieves the result, and prints out the results 
 * to the console.
 * 
 * This class is autogenerated, DO NOT EDIT.
 *
 * This class is not thread safe.  A new instance should be created for any threads using this class.
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public class PreprocessDatasetSTATMLServiceClient extends ServiceSecurityClient implements PreprocessDatasetSTATMLServiceI {	
	protected PreprocessDatasetSTATMLServicePortType portType;
	private Object portTypeMutex;

	public PreprocessDatasetSTATMLServiceClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public PreprocessDatasetSTATMLServiceClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	   	initialize();
	}
	
	public PreprocessDatasetSTATMLServiceClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public PreprocessDatasetSTATMLServiceClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
		initialize();
	}
	
	private void initialize() throws RemoteException {
	    this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private PreprocessDatasetSTATMLServicePortType createPortType() throws RemoteException {

		PreprocessDatasetSTATMLServiceAddressingLocator locator = new PreprocessDatasetSTATMLServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = ClassUtils.getResourceAsStream(getClass(), "client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		PreprocessDatasetSTATMLServicePortType port = null;
		try {
			port = locator.getPreprocessDatasetSTATMLServicePortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:" + e.getMessage(), e);
		}

		return port;
	}

	public static void usage(){
		System.out.println(PreprocessDatasetSTATMLServiceClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  PreprocessDatasetSTATMLServiceClient client = new PreprocessDatasetSTATMLServiceClient(args[1]);
			  String[] rowNames = {"gene 1", "gene 2"};
			  String[] rowDescriptions = {"gene 1 description", "gene 2 description"};
			  String[] columnNames = {"Sample 1", "Sample 2", "Sample 3"};
			  double[][] values = {{1.1, 2.1, 3.1},
					  {1.2, 2.2, 3.2}};
			  Data data = StatmlConverter.createStatmlData(rowNames, rowDescriptions, columnNames, values);
			  
			  PreprocessDatasetParameterSet preprocessDatasetParameterSet = new PreprocessDatasetParameterSet();
			  preprocessDatasetParameterSet.setFilterFlag(0);
			  preprocessDatasetParameterSet.setPreprocessingFlag("0");
			  preprocessDatasetParameterSet.setMinChange(3f);
			  preprocessDatasetParameterSet.setMinDelta(100f);
			  preprocessDatasetParameterSet.setThreshold(20f);
			  preprocessDatasetParameterSet.setCeiling(2.1f);
			  preprocessDatasetParameterSet.setMaxSigmaBinning(1);
			  preprocessDatasetParameterSet.setProbThres(1f);
			  preprocessDatasetParameterSet.setNumExcl(0);
			  preprocessDatasetParameterSet.setLogBaseTwo(false);
			  preprocessDatasetParameterSet.setNumberOfColumnsAboveThreshold(1);
			 

			  Data result = client.performAnalysis(data, preprocessDatasetParameterSet);
			  Array[] arrays = result.getArray();
			  StatMLSerializer serializer = new StatMLSerializer();
			  
			  if (null != result) {
				  Array namesArray = arrays[0];
				  Object[] rowObj = serializer.deserialize(namesArray.getBase64Value());
				  int numRows = rowObj.length;
				  int numCols = arrays.length - 2;
				  
				  rowNames = new String[numRows];
				  System.arraycopy(rowObj, 0, rowNames, 0, numRows);

				  Array descArray = arrays[1];
				  Object[] descObj = serializer.deserialize(descArray.getBase64Value());
				  rowDescriptions = new String[numRows];
				  System.arraycopy(descObj, 0, rowDescriptions, 0, numRows);

				  for (int i = 0; i < rowNames.length; i++) { 
					  System.err.println("i=[" + i + "] rowName=[" + rowNames[i] + 
							  "] rowDescription=[" + rowDescriptions[i] + "]");
				  }
				  
				  Double[][] vals = new Double[numRows][numCols];
				  String[] colNames = new String[numCols];				  
				  for (int i = 2; i < arrays.length; i++) {
					  Array array = arrays[i];
					  int index = i - 2;
					  colNames[index] = array.getName();
					  System.err.println("index=[" + index + "] colName=[" + colNames[index] + "]");
					  System.err.println("value=[" + array.getBase64Value() + "]");
					  Object[] objs = serializer.deserialize(array.getBase64Value());
					  for (int row = 0; row < objs.length; row++) {
						  vals[row][index] = (Double) objs[row];
					  }
				  }
					
				  for (int i = 0; i < numRows; i++) {
					  System.err.println("i=[" + i + "] row name=[" + rowNames[i] + 
							  "] row description=[" + rowDescriptions[i] + "]");
				  }

				  for (int j = 0; j < numCols; j++) {
					  System.err.println("j=[" + j + "] column name=[" + colNames[j] + "]");
				  }
					
				  for (int i = 0; i < numRows; i++) {
					  for (int j = 0; j < numCols; j++) {
						  System.err.println("i=[" + i + "] j=[" + j + "] value=[" + vals[i][j] + "]");
					  }
				  }				  
			  }
			} else {
				usage();
				System.exit(1);
			}
		} else {
			usage();
			System.exit(1);
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

    public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"getServiceSecurityMetadata");
        gov.nih.nci.cagrid.introduce.security.GetServiceSecurityMetadataRequest params = new gov.nih.nci.cagrid.introduce.security.GetServiceSecurityMetadataRequest();
        gov.nih.nci.cagrid.introduce.security.GetServiceSecurityMetadataResponse boxedResult = portType.getServiceSecurityMetadata(params);
        return boxedResult.getServiceSecurityMetadata();
      }
    }
    public gridextensions.Data performAnalysis(gridextensions.Data data,gridextensions.PreprocessDatasetParameterSet preprocessDatasetParameterSet) throws RemoteException, org.genepattern.cagrid.service.preprocessdataset.statml.stubs.InvalidParameterException {
      synchronized(portTypeMutex){
       // configureStubSecurity((Stub)portType,"performAnalysis");
        org.genepattern.cagrid.service.preprocessdataset.statml.stubs.PerformAnalysisRequest params = new org.genepattern.cagrid.service.preprocessdataset.statml.stubs.PerformAnalysisRequest();
        org.genepattern.cagrid.service.preprocessdataset.statml.stubs.PerformAnalysisRequestData dataContainer = new org.genepattern.cagrid.service.preprocessdataset.statml.stubs.PerformAnalysisRequestData();
        dataContainer.setData(data);
        params.setData(dataContainer);
        org.genepattern.cagrid.service.preprocessdataset.statml.stubs.PerformAnalysisRequestPreprocessDatasetParameterSet preprocessDatasetParameterSetContainer = new org.genepattern.cagrid.service.preprocessdataset.statml.stubs.PerformAnalysisRequestPreprocessDatasetParameterSet();
        preprocessDatasetParameterSetContainer.setPreprocessDatasetParameterSet(preprocessDatasetParameterSet);
        params.setPreprocessDatasetParameterSet(preprocessDatasetParameterSetContainer);
        org.genepattern.cagrid.service.preprocessdataset.statml.stubs.PerformAnalysisResponse boxedResult = portType.performAnalysis(params);
        return boxedResult.getData();
      }
    }

}
