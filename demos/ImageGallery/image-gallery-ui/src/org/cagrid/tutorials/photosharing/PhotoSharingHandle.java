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
package org.cagrid.tutorials.photosharing;

import gov.nih.nci.cagrid.common.security.ProxyUtil;

import java.util.ArrayList;
import java.util.List;

import org.cagrid.demo.photosharing.client.PhotoSharingClient;
import org.cagrid.demo.photosharing.gallery.client.GalleryClient;
import org.cagrid.gaards.ui.common.ServiceHandle;
import org.cagrid.grape.configuration.ServiceDescriptor;
import org.globus.gsi.GlobusCredential;


public class PhotoSharingHandle extends ServiceHandle {

    private PhotoSharingClient client;
    private GlobusCredential cred;


    public PhotoSharingHandle(ServiceDescriptor des) throws Exception {
        super(des);
        cred = ProxyUtil.getDefaultProxy();
        client = new PhotoSharingClient(des.getServiceURL(), cred);
    }


    public void createGallery(String galleryName) throws Exception {
        client.createGallery(galleryName);
    }


    public List<GalleryHandle> getGalleries() throws Exception {
        List<GalleryHandle> handles = new ArrayList<GalleryHandle>();
        GalleryClient[] clients = client.listGalleries();
        if (clients != null) {
            for (int i = 0; i < clients.length; i++) {
                GalleryClient c = new GalleryClient(clients[i].getEndpointReference(), cred);
                handles.add(new GalleryHandle(c));
            }
        }
        return handles;
    }

}
