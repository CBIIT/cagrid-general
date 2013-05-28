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
package gov.nih.nci.cagrid.annualdemo.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.axis.utils.ClassUtils;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import gov.nih.nci.cagrid.annualdemo.stubs.MageTranslationServicesPortType;
import gov.nih.nci.cagrid.annualdemo.stubs.service.MageTranslationServicesServiceAddressingLocator;
import gov.nih.nci.cagrid.annualdemo.common.MageTranslationServicesI;
import gov.nih.nci.cagrid.cqlresultset.CQLQueryResults;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;
import gridextensions.Data;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public class MageTranslationServicesClient extends ServiceSecurityClient implements MageTranslationServicesI {	
	protected MageTranslationServicesPortType portType;
	private Object portTypeMutex;

	public MageTranslationServicesClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public MageTranslationServicesClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	   	initialize();
	}
	
	public MageTranslationServicesClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public MageTranslationServicesClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
		initialize();
	}
	
	private void initialize() throws RemoteException {
	    this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private MageTranslationServicesPortType createPortType() throws RemoteException {

		MageTranslationServicesServiceAddressingLocator locator = new MageTranslationServicesServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = ClassUtils.getResourceAsStream(getClass(), "client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		MageTranslationServicesPortType port = null;
		try {
			port = locator.getMageTranslationServicesPortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:" + e.getMessage(), e);
		}

		return port;
	}
	
	public GetResourcePropertyResponse getResourceProperty(QName resourcePropertyQName) throws RemoteException {
		return portType.getResourceProperty(resourcePropertyQName);
	}

	public static void usage(){
		System.out.println(MageTranslationServicesClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  MageTranslationServicesClient client = new MageTranslationServicesClient(args[1]);
			  CQLQueryResults cQLQueryResultCollection = new CQLQueryResults() ;
			  Data data = client.mageToStatML(cQLQueryResultCollection );
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

	public gridextensions.Data bioAssayToStatML(gov.nih.nci.mageom.domain.bioassay.MeasuredBioAssay[] measuredBioAssay) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"bioAssayToStatML");
        gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToStatMLRequest params = new gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToStatMLRequest();
        gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToStatMLRequestMeasuredBioAssay measuredBioAssayContainer = new gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToStatMLRequestMeasuredBioAssay();
        measuredBioAssayContainer.setMeasuredBioAssay(measuredBioAssay);
        params.setMeasuredBioAssay(measuredBioAssayContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToStatMLResponse boxedResult = portType.bioAssayToStatML(params);
        return boxedResult.getData();
      }
    }
	public gridextensions.Data bioAssayToMicroArraySet(gridextensions.MeasuredBioAssay[] measuredBioAssay) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"bioAssayToMicroArraySet");
        gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToMicroArraySetRequest params = new gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToMicroArraySetRequest();
        gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToMicroArraySetRequestMeasuredBioAssay measuredBioAssayContainer = new gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToMicroArraySetRequestMeasuredBioAssay();
        measuredBioAssayContainer.setMeasuredBioAssay(measuredBioAssay);
        params.setMeasuredBioAssay(measuredBioAssayContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.BioAssayToMicroArraySetResponse boxedResult = portType.bioAssayToMicroArraySet(params);
        return boxedResult.getData();
      }
    }
	public gov.nih.nci.cagrid.metadata.security.ServiceSecurityMetadata getServiceSecurityMetadata() throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"getServiceSecurityMetadata");
        gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest params = new gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataRequest();
        gov.nih.nci.cagrid.introduce.security.stubs.GetServiceSecurityMetadataResponse boxedResult = portType.getServiceSecurityMetadata(params);
        return boxedResult.getServiceSecurityMetadata();
      }
    }
	public edu.columbia.geworkbench.cagrid.microarray.MicroarraySet mageToMicroArraySet(gov.nih.nci.cagrid.cqlresultset.CQLQueryResults cQLQueryResultCollection) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"mageToMicroArraySet");
        gov.nih.nci.cagrid.annualdemo.stubs.MageToMicroArraySetRequest params = new gov.nih.nci.cagrid.annualdemo.stubs.MageToMicroArraySetRequest();
        gov.nih.nci.cagrid.annualdemo.stubs.MageToMicroArraySetRequestCQLQueryResultCollection cQLQueryResultCollectionContainer = new gov.nih.nci.cagrid.annualdemo.stubs.MageToMicroArraySetRequestCQLQueryResultCollection();
        cQLQueryResultCollectionContainer.setCQLQueryResultCollection(cQLQueryResultCollection);
        params.setCQLQueryResultCollection(cQLQueryResultCollectionContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.MageToMicroArraySetResponse boxedResult = portType.mageToMicroArraySet(params);
        return boxedResult.getMicroarraySet();
      }
    }
	public gridextensions.Data mageToStatML(gov.nih.nci.cagrid.cqlresultset.CQLQueryResults cQLQueryResultCollection) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"mageToStatML");
        gov.nih.nci.cagrid.annualdemo.stubs.MageToStatMLRequest params = new gov.nih.nci.cagrid.annualdemo.stubs.MageToStatMLRequest();
        gov.nih.nci.cagrid.annualdemo.stubs.MageToStatMLRequestCQLQueryResultCollection cQLQueryResultCollectionContainer = new gov.nih.nci.cagrid.annualdemo.stubs.MageToStatMLRequestCQLQueryResultCollection();
        cQLQueryResultCollectionContainer.setCQLQueryResultCollection(cQLQueryResultCollection);
        params.setCQLQueryResultCollection(cQLQueryResultCollectionContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.MageToStatMLResponse boxedResult = portType.mageToStatML(params);
        return boxedResult.getData();
      }
    }
	public edu.columbia.geworkbench.cagrid.cluster.hierarchical.TreeViewInput gwClusterToTreeView(edu.columbia.geworkbench.cagrid.cluster.hierarchical.HierarchicalCluster hierarchicalCluster,edu.columbia.geworkbench.cagrid.microarray.MicroarraySet microarraySet) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"gwClusterToTreeView");
        gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToTreeViewRequest params = new gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToTreeViewRequest();
        gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToTreeViewRequestHierarchicalCluster hierarchicalClusterContainer = new gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToTreeViewRequestHierarchicalCluster();
        hierarchicalClusterContainer.setHierarchicalCluster(hierarchicalCluster);
        params.setHierarchicalCluster(hierarchicalClusterContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToTreeViewRequestMicroarraySet microarraySetContainer = new gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToTreeViewRequestMicroarraySet();
        microarraySetContainer.setMicroarraySet(microarraySet);
        params.setMicroarraySet(microarraySetContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.GwClusterToTreeViewResponse boxedResult = portType.gwClusterToTreeView(params);
        return boxedResult.getTreeViewInputElement();
      }
    }
	public edu.columbia.geworkbench.cagrid.microarray.MicroarraySet statmlToMicroarraySet(gridextensions.Data data) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"statmlToMicroarraySet");
        gov.nih.nci.cagrid.annualdemo.stubs.StatmlToMicroarraySetRequest params = new gov.nih.nci.cagrid.annualdemo.stubs.StatmlToMicroarraySetRequest();
        gov.nih.nci.cagrid.annualdemo.stubs.StatmlToMicroarraySetRequestData dataContainer = new gov.nih.nci.cagrid.annualdemo.stubs.StatmlToMicroarraySetRequestData();
        dataContainer.setData(data);
        params.setData(dataContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.StatmlToMicroarraySetResponse boxedResult = portType.statmlToMicroarraySet(params);
        return boxedResult.getMicroarraySet();
      }
    }
	public edu.columbia.geworkbench.cagrid.cluster.hierarchical.TreeViewInput gpClusterToTreeView(gridextensions.ConsensusClusterResultCollection consensusClusterResultCollection,gridextensions.Data data) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"gpClusterToTreeView");
        gov.nih.nci.cagrid.annualdemo.stubs.GpClusterToTreeViewRequest params = new gov.nih.nci.cagrid.annualdemo.stubs.GpClusterToTreeViewRequest();
        gov.nih.nci.cagrid.annualdemo.stubs.GpClusterToTreeViewRequestConsensusClusterResultCollection consensusClusterResultCollectionContainer = new gov.nih.nci.cagrid.annualdemo.stubs.GpClusterToTreeViewRequestConsensusClusterResultCollection();
        consensusClusterResultCollectionContainer.setConsensusClusterResultCollection(consensusClusterResultCollection);
        params.setConsensusClusterResultCollection(consensusClusterResultCollectionContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.GpClusterToTreeViewRequestData dataContainer = new gov.nih.nci.cagrid.annualdemo.stubs.GpClusterToTreeViewRequestData();
        dataContainer.setData(data);
        params.setData(dataContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.GpClusterToTreeViewResponse boxedResult = portType.gpClusterToTreeView(params);
        return boxedResult.getTreeViewInputElement();
      }
    }
	public gridextensions.Data microarraySetToStatml(edu.columbia.geworkbench.cagrid.microarray.MicroarraySet microarraySet) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"microarraySetToStatml");
        gov.nih.nci.cagrid.annualdemo.stubs.MicroarraySetToStatmlRequest params = new gov.nih.nci.cagrid.annualdemo.stubs.MicroarraySetToStatmlRequest();
        gov.nih.nci.cagrid.annualdemo.stubs.MicroarraySetToStatmlRequestMicroarraySet microarraySetContainer = new gov.nih.nci.cagrid.annualdemo.stubs.MicroarraySetToStatmlRequestMicroarraySet();
        microarraySetContainer.setMicroarraySet(microarraySet);
        params.setMicroarraySet(microarraySetContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.MicroarraySetToStatmlResponse boxedResult = portType.microarraySetToStatml(params);
        return boxedResult.getData();
      }
    }
	public gridextensions.Data performAnalysis(gridextensions.Data data,gridextensions.PreprocessDatasetParameterSet preprocessDatasetParameterSet) throws RemoteException {
      synchronized(portTypeMutex){
        configureStubSecurity((Stub)portType,"performAnalysis");
        gov.nih.nci.cagrid.annualdemo.stubs.PerformAnalysisRequest params = new gov.nih.nci.cagrid.annualdemo.stubs.PerformAnalysisRequest();
        gov.nih.nci.cagrid.annualdemo.stubs.PerformAnalysisRequestData dataContainer = new gov.nih.nci.cagrid.annualdemo.stubs.PerformAnalysisRequestData();
        dataContainer.setData(data);
        params.setData(dataContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.PerformAnalysisRequestPreprocessDatasetParameterSet preprocessDatasetParameterSetContainer = new gov.nih.nci.cagrid.annualdemo.stubs.PerformAnalysisRequestPreprocessDatasetParameterSet();
        preprocessDatasetParameterSetContainer.setPreprocessDatasetParameterSet(preprocessDatasetParameterSet);
        params.setPreprocessDatasetParameterSet(preprocessDatasetParameterSetContainer);
        gov.nih.nci.cagrid.annualdemo.stubs.PerformAnalysisResponse boxedResult = portType.performAnalysis(params);
        return boxedResult.getData();
      }
    }

}
