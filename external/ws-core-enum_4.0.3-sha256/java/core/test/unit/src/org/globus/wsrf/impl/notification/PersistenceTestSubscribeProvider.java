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
package org.globus.wsrf.impl.notification;

import org.globus.wsrf.Resource;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.ResourceKey;
import org.oasis.wsn.Subscribe;

public class PersistenceTestSubscribeProvider extends SubscribeProvider
{
    protected SubscribeHelper getSubscribeHelper(
        ResourceContext context, Resource producerResource,
        ResourceKey producerKey, String producerHomeLocation,
        Subscribe request)
    {
        return new PersistentSubscribeHelper(
            context, producerResource, producerKey,
            producerHomeLocation, request);
    }

}