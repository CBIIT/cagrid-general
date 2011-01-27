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
package org.globus.wsrf.impl.security.authentication.secureconv;

import javax.xml.namespace.QName;
import javax.xml.rpc.handler.GenericHandler;
import javax.xml.rpc.handler.MessageContext;
import javax.xml.rpc.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.globus.util.I18n;
import org.globus.wsrf.impl.security.authentication.Constants;
import org.globus.wsrf.impl.security.authentication.secureconv.service.SecurityContext;
import org.globus.wsrf.impl.security.authentication.signature.GssSignedSOAPEnvelopeBuilder;
import org.globus.wsrf.impl.security.authentication.wssec.WSSecurityFault;

/**
 * Used for GSI Secure Conversation. Signs and adds relevant information
 * into the security header.
 */
public class SignHandler extends GenericHandler {

    protected static I18n i18n = 
        I18n.getI18n("org.globus.wsrf.impl.security.authentication.errors");
    protected static Log log = LogFactory.getLog(SignHandler.class.getName());

    public boolean handleRequest(MessageContext context) {
        return handleMessage((SOAPMessageContext) context);
    }

    public boolean handleResponse(MessageContext context) {
        return handleMessage((SOAPMessageContext) context);
    }

    public boolean handleMessage(SOAPMessageContext ctx) {

        // get secure context from the msg context
        SecurityContext secContext =
            (SecurityContext) ctx.getProperty(Constants.CONTEXT);

        if (secContext == null) {
            log.debug("No context - not signing.");
            return true;
        }

        SOAPMessage msg = ctx.getMessage();
        if (msg == null) {
            log.debug("No message - not signing.");
            return true;
        }
        
        log.debug("Enter: sign");

        SOAPMessage signedMsg = null;

        try {
            SOAPEnvelope unsignedEnvelope = msg.getSOAPPart().getEnvelope();

            GssSignedSOAPEnvelopeBuilder builder =
                new GssSignedSOAPEnvelopeBuilder(
                    ctx, secContext.getContext(), (String) secContext.getID()
                );
            builder.setActor((String) ctx.getProperty("gssActor"));

            signedMsg = builder.buildMessage(unsignedEnvelope);
        } catch (Exception e) {
            log.error(i18n.getMessage("signErr"), e);
            throw WSSecurityFault.makeFault(e);
        }

        ctx.setMessage(signedMsg);

        log.debug("Exit: sign");

        return true;
    }

    public QName[] getHeaders() {
        return null;
    }
}