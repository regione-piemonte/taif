/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.manager.http.client;

import java.io.IOException;

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpResponse;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public interface HttpClientManager {

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    HttpResponse executeGetRequest(String url) throws IOException;

    /**
     *
     * @param url
     * @param content
     * @return
     * @throws IOException
     */
    HttpResponse executePostRequest(String url, HttpContent content) throws IOException;

}
