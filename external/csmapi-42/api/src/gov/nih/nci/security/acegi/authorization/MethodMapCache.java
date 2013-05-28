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
package gov.nih.nci.security.acegi.authorization;
import java.util.Map;

public interface MethodMapCache {

public Map getMethodMapFromCache(String mapName);

public void putMethodMapInCache(String mapName,Map methodMap);

public void removeMethodMapFromCache(String mapName);
}
