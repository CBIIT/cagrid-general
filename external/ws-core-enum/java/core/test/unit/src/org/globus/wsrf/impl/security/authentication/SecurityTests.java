/*
 * Portions of this file Copyright 1999-2005 University of Chicago
 * Portions of this file Copyright 1999-2005 The University of Southern California.
 *
 * This file or a portion of this file is licensed under the
 * terms of the Globus Toolkit Public License, found at
 * http://www.globus.org/toolkit/download/license.html.
 * If you redistribute this file, with or without
 * modifications, you must include this notice in the file.
 */
package org.globus.wsrf.impl.security.authentication;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.globus.wsrf.test.GridTestSuite;

public class SecurityTests extends GridTestSuite {

    public SecurityTests(String name) {
        super(name);
    }

    public static Test suite() throws Exception {
        TestSuite suite = new SecurityTests("SoapSecurityTests");
        suite.addTestSuite(TestGssXMLSignature.class);
        suite.addTestSuite(TestGssXMLEncryption.class);
        suite.addTestSuite(TestWSSecurity.class);
        suite.addTestSuite(TestReplayAttackFilter.class);
        return suite;
    }
}
