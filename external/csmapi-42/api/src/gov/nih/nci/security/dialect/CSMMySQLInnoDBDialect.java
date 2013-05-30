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
package gov.nih.nci.security.dialect;
import gov.nih.nci.security.constants.Constants;

import org.hibernate.dialect.MySQLInnoDBDialect;

public class CSMMySQLInnoDBDialect extends MySQLInnoDBDialect {
    
    /**
     * Create a new dialect.
     */
    public CSMMySQLInnoDBDialect() {
        super();
        registerKeyword(Constants.CSM_FILTER_ALIAS);
    }
}
