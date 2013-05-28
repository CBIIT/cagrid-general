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
package org.globus.cagrid.RProteomics.client;


import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.message.addressing.Address;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.globus.gsi.GlobusCredential;

import org.globus.cagrid.RProteomics.stubs.RProteomicsPortType;
import org.globus.cagrid.RProteomics.stubs.service.RProteomicsServiceAddressingLocator;
import org.globus.cagrid.RProteomics.common.RProteomicsI;

import edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType;

import edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType;


/**
 * This class is autogenerated, DO NOT EDIT.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public class RProteomicsClient implements RProteomicsI {
	
	private RProteomicsServiceAddressingLocator locator;
	private GlobusCredential proxy;
	private String url;
	
	public RProteomicsClient(String url) {
		this(url,null);	
	}

	public RProteomicsClient(String url, GlobusCredential proxy) {
	   	this.proxy = proxy;
	   	this.url = url;	
	}

	private RProteomicsPortType getPortType(){
		try {
		RProteomicsServiceAddressingLocator locator = new RProteomicsServiceAddressingLocator();
		EndpointReferenceType endpoint = new EndpointReferenceType();
		endpoint.setAddress(new Address(url));
			RProteomicsPortType port = locator.getRProteomicsPortTypePort(endpoint);
			return port;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void usage(){
		System.out.println(RProteomicsClient.class.getName() + " -gsh [gsh]");
	}
	
	public static void main(String [] args) throws Exception {
		try{
			args = new String[] {
				//"-gsh", "http://ccis1716.duhs.duke.edu/wsrf/services/cagrid/RProteomics",
				"-gsh", "http://localhost:8080/wsrf/services/cagrid/RProteomics",
			};
		if(!(args.length < 2)){
			if(args[0].equals("-gsh")){
			  RProteomicsClient client = new RProteomicsClient(args[1]);
			  
			  LsidType[] lsids = client.echo(new LsidType[] {
				  new LsidType("hi"), new LsidType("there")
			  });
			  for (int i = 0; i < lsids.length; i++) System.out.println(lsids[i].getValue());
			  
			  File dir = new File("data");
			  ScanFeaturesType[] scans = ServiceUtils.readScanFeaturesFromDir(new File("data"));
			  
			  //scans = client.general_interpolateByValue(scans);
			  client.echoByValue(scans);
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
		}
	}
	






























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_log(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_log params = new org.globus.cagrid.RProteomics.stubs.Normalize_log();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Normalize_logResponse boxedResult = port.normalize_log(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_log10(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_log10 params = new org.globus.cagrid.RProteomics.stubs.Normalize_log10();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Normalize_log10Response boxedResult = port.normalize_log10(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_log2(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_log2 params = new org.globus.cagrid.RProteomics.stubs.Normalize_log2();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Normalize_log2Response boxedResult = port.normalize_log2(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_sqrt(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_sqrt params = new org.globus.cagrid.RProteomics.stubs.Normalize_sqrt();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Normalize_sqrtResponse boxedResult = port.normalize_sqrt(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_square(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_square params = new org.globus.cagrid.RProteomics.stubs.Normalize_square();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Normalize_squareResponse boxedResult = port.normalize_square(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_cubeRoot(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_cubeRoot params = new org.globus.cagrid.RProteomics.stubs.Normalize_cubeRoot();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Normalize_cubeRootResponse boxedResult = port.normalize_cubeRoot(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_power(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.ExponentType exponent) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_power params = new org.globus.cagrid.RProteomics.stubs.Normalize_power();
               params.setLsids(lsids);
               params.setExponent(exponent);
               org.globus.cagrid.RProteomics.stubs.Normalize_powerResponse boxedResult = port.normalize_power(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_byMax(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_byMax params = new org.globus.cagrid.RProteomics.stubs.Normalize_byMax();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Normalize_byMaxResponse boxedResult = port.normalize_byMax(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_usingMinAndMax(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_usingMinAndMax params = new org.globus.cagrid.RProteomics.stubs.Normalize_usingMinAndMax();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Normalize_usingMinAndMaxResponse boxedResult = port.normalize_usingMinAndMax(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_IOC(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_IOC params = new org.globus.cagrid.RProteomics.stubs.Normalize_IOC();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Normalize_IOCResponse boxedResult = port.normalize_IOC(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] normalize_quantile(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.QuantileType startQuantile) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_quantile params = new org.globus.cagrid.RProteomics.stubs.Normalize_quantile();
               params.setLsids(lsids);
               params.setStartQuantile(startQuantile);
               org.globus.cagrid.RProteomics.stubs.Normalize_quantileResponse boxedResult = port.normalize_quantile(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] normalize_quantileByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml,edu.duke.cabig.rproteomics.domain.serviceinterface.QuantileType startQuantile) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Normalize_quantileByValue params = new org.globus.cagrid.RProteomics.stubs.Normalize_quantileByValue();
               params.setScanFeaturesXml(scanFeaturesXml);
               params.setStartQuantile(startQuantile);
               org.globus.cagrid.RProteomics.stubs.Normalize_quantileByValueResponse boxedResult = port.normalize_quantileByValue(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_MAD(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.PercentileType percentile,edu.duke.cabig.rproteomics.domain.serviceinterface.ValuesNearToCutoffType valuesNearCutoff,edu.duke.cabig.rproteomics.domain.serviceinterface.LambdaType lambda) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_MAD params = new org.globus.cagrid.RProteomics.stubs.Denoise_MAD();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setPercentile(percentile);
               params.setValuesNearCutoff(valuesNearCutoff);
               params.setLambda(lambda);
               org.globus.cagrid.RProteomics.stubs.Denoise_MADResponse boxedResult = port.denoise_MAD(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_MADNormalize(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.PercentileType percentile,edu.duke.cabig.rproteomics.domain.serviceinterface.ValuesNearToCutoffType valuesNearCutoff,edu.duke.cabig.rproteomics.domain.serviceinterface.LambdaType lambda,edu.duke.cabig.rproteomics.domain.serviceinterface.NoiseType minNoise) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_MADNormalize params = new org.globus.cagrid.RProteomics.stubs.Denoise_MADNormalize();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setPercentile(percentile);
               params.setValuesNearCutoff(valuesNearCutoff);
               params.setLambda(lambda);
               params.setMinNoise(minNoise);
               org.globus.cagrid.RProteomics.stubs.Denoise_MADNormalizeResponse boxedResult = port.denoise_MADNormalize(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_waveletUDWT(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.ThresholdType thresholdMultiplier) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWT params = new org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWT();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setThresholdMultiplier(thresholdMultiplier);
               org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTResponse boxedResult = port.denoise_waveletUDWT(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_waveletUDWTW(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.ThresholdType thresholdMultiplier) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTW params = new org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTW();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setThresholdMultiplier(thresholdMultiplier);
               org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWResponse boxedResult = port.denoise_waveletUDWTW(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] denoise_waveletUDWTWByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.ThresholdType thresholdMultiplier) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWByValue params = new org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWByValue();
               params.setScanFeaturesXml(scanFeaturesXml);
               params.setWindowSize(windowSize);
               params.setThresholdMultiplier(thresholdMultiplier);
               org.globus.cagrid.RProteomics.stubs.Denoise_waveletUDWTWByValueResponse boxedResult = port.denoise_waveletUDWTWByValue(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_highPass(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.CoefficientsType numCoeffsToDrop) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_highPass params = new org.globus.cagrid.RProteomics.stubs.Denoise_highPass();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setNumCoeffsToDrop(numCoeffsToDrop);
               org.globus.cagrid.RProteomics.stubs.Denoise_highPassResponse boxedResult = port.denoise_highPass(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_highPassW(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.CoefficientsType numCoeffsToDrop) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_highPassW params = new org.globus.cagrid.RProteomics.stubs.Denoise_highPassW();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setNumCoeffsToDrop(numCoeffsToDrop);
               org.globus.cagrid.RProteomics.stubs.Denoise_highPassWResponse boxedResult = port.denoise_highPassW(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_PCAFilter(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.CoefficientsType numCoeffsToDrop) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_PCAFilter params = new org.globus.cagrid.RProteomics.stubs.Denoise_PCAFilter();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setNumCoeffsToDrop(numCoeffsToDrop);
               org.globus.cagrid.RProteomics.stubs.Denoise_PCAFilterResponse boxedResult = port.denoise_PCAFilter(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_q5_PCAFilter(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.CoefficientsType numCoeffsToDrop) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_q5_PCAFilter params = new org.globus.cagrid.RProteomics.stubs.Denoise_q5_PCAFilter();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setNumCoeffsToDrop(numCoeffsToDrop);
               org.globus.cagrid.RProteomics.stubs.Denoise_q5_PCAFilterResponse boxedResult = port.denoise_q5_PCAFilter(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] denoise_loess(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.SpanType span,edu.duke.cabig.rproteomics.domain.serviceinterface.PolynomialDegreeType degree) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Denoise_loess params = new org.globus.cagrid.RProteomics.stubs.Denoise_loess();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setSpan(span);
               params.setDegree(degree);
               org.globus.cagrid.RProteomics.stubs.Denoise_loessResponse boxedResult = port.denoise_loess(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_runningQuantile(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.PercentileType percentile) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantile params = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantile();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setPercentile(percentile);
               org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileResponse boxedResult = port.removeBackground_runningQuantile(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] removeBackground_runningQuantileByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.PercentileType percentile) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileByValue params = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileByValue();
               params.setScanFeaturesXml(scanFeaturesXml);
               params.setWindowSize(windowSize);
               params.setPercentile(percentile);
               org.globus.cagrid.RProteomics.stubs.RemoveBackground_runningQuantileByValueResponse boxedResult = port.removeBackground_runningQuantileByValue(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_loess(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize,edu.duke.cabig.rproteomics.domain.serviceinterface.SpanType span) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.RemoveBackground_loess params = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_loess();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               params.setSpan(span);
               org.globus.cagrid.RProteomics.stubs.RemoveBackground_loessResponse boxedResult = port.removeBackground_loess(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_linearFit(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.RemoveBackground_linearFit params = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_linearFit();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               org.globus.cagrid.RProteomics.stubs.RemoveBackground_linearFitResponse boxedResult = port.removeBackground_linearFit(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_exponentialFit(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.RemoveBackground_exponentialFit params = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_exponentialFit();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               org.globus.cagrid.RProteomics.stubs.RemoveBackground_exponentialFitResponse boxedResult = port.removeBackground_exponentialFit(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_logistic(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.RemoveBackground_logistic params = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_logistic();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               org.globus.cagrid.RProteomics.stubs.RemoveBackground_logisticResponse boxedResult = port.removeBackground_logistic(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_quadraticFit(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids,edu.duke.cabig.rproteomics.domain.serviceinterface.WindowType windowSize) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.RemoveBackground_quadraticFit params = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_quadraticFit();
               params.setLsids(lsids);
               params.setWindowSize(windowSize);
               org.globus.cagrid.RProteomics.stubs.RemoveBackground_quadraticFitResponse boxedResult = port.removeBackground_quadraticFit(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] removeBackground_minus(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids1,edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids2) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.RemoveBackground_minus params = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_minus();
               params.setLsids1(lsids1);
               params.setLsids2(lsids2);
               org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusResponse boxedResult = port.removeBackground_minus(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] removeBackground_minusByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml1,edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml2) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusByValue params = new org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusByValue();
               params.setScanFeaturesXml1(scanFeaturesXml1);
               params.setScanFeaturesXml2(scanFeaturesXml2);
               org.globus.cagrid.RProteomics.stubs.RemoveBackground_minusByValueResponse boxedResult = port.removeBackground_minusByValue(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.JpegImageType plot_2DStacked(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsidsTop,edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsidsBottom) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Plot_2DStacked params = new org.globus.cagrid.RProteomics.stubs.Plot_2DStacked();
               params.setLsidsTop(lsidsTop);
               params.setLsidsBottom(lsidsBottom);
               org.globus.cagrid.RProteomics.stubs.Plot_2DStackedResponse boxedResult = port.plot_2DStacked(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.JpegImageType plot_2DStackedByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXmlTop,edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXmlBottom) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Plot_2DStackedByValue params = new org.globus.cagrid.RProteomics.stubs.Plot_2DStackedByValue();
               params.setScanFeaturesXmlTop(scanFeaturesXmlTop);
               params.setScanFeaturesXmlBottom(scanFeaturesXmlBottom);
               org.globus.cagrid.RProteomics.stubs.Plot_2DStackedByValueResponse boxedResult = port.plot_2DStackedByValue(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.JpegImageType plot_2D(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Plot_2D params = new org.globus.cagrid.RProteomics.stubs.Plot_2D();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Plot_2DResponse boxedResult = port.plot_2D(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.JpegImageType plot_2DByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Plot_2DByValue params = new org.globus.cagrid.RProteomics.stubs.Plot_2DByValue();
               params.setScanFeaturesXml(scanFeaturesXml);
               org.globus.cagrid.RProteomics.stubs.Plot_2DByValueResponse boxedResult = port.plot_2DByValue(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] general_interpolate(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.General_interpolate params = new org.globus.cagrid.RProteomics.stubs.General_interpolate();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.General_interpolateResponse boxedResult = port.general_interpolate(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] general_interpolateByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.General_interpolateByValue params = new org.globus.cagrid.RProteomics.stubs.General_interpolateByValue();
               params.setScanFeaturesXml(scanFeaturesXml);
               org.globus.cagrid.RProteomics.stubs.General_interpolateByValueResponse boxedResult = port.general_interpolateByValue(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] align_alignx(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Align_alignx params = new org.globus.cagrid.RProteomics.stubs.Align_alignx();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.Align_alignxResponse boxedResult = port.align_alignx(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] align_alignxByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Align_alignxByValue params = new org.globus.cagrid.RProteomics.stubs.Align_alignxByValue();
               params.setScanFeaturesXml(scanFeaturesXml);
               org.globus.cagrid.RProteomics.stubs.Align_alignxByValueResponse boxedResult = port.align_alignxByValue(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] echo(edu.duke.cabig.rproteomics.domain.serviceinterface.LsidType[] lsids) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.Echo params = new org.globus.cagrid.RProteomics.stubs.Echo();
               params.setLsids(lsids);
               org.globus.cagrid.RProteomics.stubs.EchoResponse boxedResult = port.echo(params);
               return boxedResult.getResponse();

	}

	     public edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] echoByValue(edu.duke.cabig.rproteomics.domain.serviceinterface.ScanFeaturesType[] scanFeaturesXml) throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.EchoByValue params = new org.globus.cagrid.RProteomics.stubs.EchoByValue();
               params.setScanFeaturesXml(scanFeaturesXml);
               org.globus.cagrid.RProteomics.stubs.EchoByValueResponse boxedResult = port.echoByValue(params);
               return boxedResult.getResponse();

	}

	     public void throwException() throws RemoteException {
		RProteomicsPortType port = this.getPortType();
org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

               org.globus.cagrid.RProteomics.stubs.ThrowException params = new org.globus.cagrid.RProteomics.stubs.ThrowException();
               org.globus.cagrid.RProteomics.stubs.ThrowExceptionResponse boxedResult = port.throwException(params);
               
	}


}
