/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager.http.client.impl;

import it.csi.taif.topforweb.business.manager.http.client.HttpClientManager;
import it.csi.taif.topforweb.util.Constants;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.repackaged.com.google.common.base.Preconditions;
import com.google.api.client.util.ObjectParser;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class HttpClientManagerImpl implements HttpClientManager {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

    /**
     * Porta <code>Proxy</code>, limite inferiore.
     */
    private static final int MIN_PROXY_PORT = 0;

    /**
     * Porta <code>Proxy</code>, limite superiore.
     */
    private static final int MAX_PROXY_PORT = 65535;

    /**
     * Proxy.
     */
    private Proxy proxy;

    /**
     * Constructor.
     */
 /*   public HttpClientManagerImpl() {
         NOP 
    }
*/
    /**
     * Constructor.
     *
     * @param proxyHost
     * @param proxyPort
     * @throws UnknownHostException
     */
    public HttpClientManagerImpl(String proxyHost, int proxyPort) throws UnknownHostException {
        Preconditions.checkArgument(StringUtils.isNotBlank(proxyHost));
        Preconditions.checkArgument(proxyPort >= MIN_PROXY_PORT && proxyPort <= MAX_PROXY_PORT);

        final InetAddress       inetAddress   = InetAddress.getByName(proxyHost);
        final InetSocketAddress socketAddress = new InetSocketAddress(inetAddress, proxyPort);

        this.proxy = new Proxy(Proxy.Type.HTTP, socketAddress);
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.business.manager.http.client.HttpClientManager#executeGetRequest(java.lang.String)
     */
    public HttpResponse executeGetRequest(String url) throws IOException {
        LOGGER.debug("[HttpClientManagerImpl::executeGetRequest] BEGIN");

        Preconditions.checkArgument(StringUtils.isNotBlank(url));

        final HttpResponse response = this.executeRequest(url, null, RequestType.GET);

        LOGGER.debug("[HttpClientManagerImpl::executeGetRequest] END");

        return response;
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.business.manager.http.client.HttpClientManager#executePostRequest(java.lang.String, com.google.api.client.http.HttpContent)
     */
    public HttpResponse executePostRequest(String url, HttpContent content) throws IOException {
        LOGGER.debug("[HttpClientManagerImpl::executePostRequest] BEGIN");

        Preconditions.checkArgument(StringUtils.isNotBlank(url));
        Preconditions.checkArgument(content != null);

        final HttpResponse response = this.executeRequest(url, content, RequestType.POST);

        LOGGER.debug("[HttpClientManagerImpl::executePostRequest] END");

        return response;
    }

    /**
     *
     * @param url
     * @param content
     * @param requestType
     * @return
     * @throws IOException
     */
    private HttpResponse executeRequest(String url, HttpContent content, RequestType requestType) throws IOException {
        final HttpRequestFactory requestFactory = this.buildHttpRequestFactory(ServiceResponseType.JSON);

        HttpResponse response;
        try {
            HttpRequest request;
            switch (requestType) {
            case GET:
                request = requestFactory.buildGetRequest(new GenericUrl(url));
                break;
            case POST:
                request = requestFactory.buildPostRequest(new GenericUrl(url), content);
                break;
            default:
                throw new IllegalArgumentException();
            }

            response = request.execute();
        } catch (IOException e) {
            LOGGER.error("[HttpClientManagerImpl::executeRequest] ERROR: " + e.getMessage(), e);

            throw e;
        }

        return response;
    }

    /**
     *
     * @param srt
     * @return
     */
    private HttpRequestFactory buildHttpRequestFactory(final ServiceResponseType srt) {
        final HttpTransport httpTransport = this.getHttpTransport();

        final HttpRequestFactory requestFactory = httpTransport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
                request.setParser(getParser(srt));
            }
        });

        return requestFactory;
    }

    /**
     *
     * @return
     */
    private HttpTransport getHttpTransport() {
        if (this.proxy == null) {
            return new NetHttpTransport();
        } else {
            return new NetHttpTransport.Builder().setProxy(this.proxy).build();
        }
    }

    /**
     *
     * @param srt
     * @return
     * @throws IllegalArgumentException
     */
    private static ObjectParser getParser(ServiceResponseType srt) {
        if (srt == ServiceResponseType.JSON) {
            return new JsonObjectParser(new JacksonFactory());
        }

        throw new IllegalArgumentException();
    }

    /**
     *
     * @author 71781 (Luca Davico)
     * @author 71740 (Simone Cornacchia)
     */
    private static enum ServiceResponseType {
        // @formatter:off
        /**
         * <code>JSON</code> response format.
         */
        JSON,
        ;
        // @formatter:on

    }

    /**
     *
     * @author 71781 (Luca Davico)
     * @author 71740 (Simone Cornacchia)
     */
    private static enum RequestType {
        // @formatter:off
        /**
         * <code>GET</code> method.
         */
        GET,
        /**
         * <code>POST</code> method.
         */
        POST,
        ;
        // @formatter:on

    }

}
