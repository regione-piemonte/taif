/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpResponse;

import it.csi.taif.taifweb.business.helper.dto.Comune;
import it.csi.taif.taifweb.business.helper.dto.factory.LimAmmDtoFactory;
import it.csi.taif.taifweb.business.manager.http.client.HttpClientManager;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.taifweb.exception.ServiceException;
import it.csi.taif.taifweb.util.CollectionUtils;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.geojson.Feature;
import it.csi.taif.taifweb.util.geojson.FeatureCollection;


/**
 * Classe Helper, <code>facade</code> al servizio <code>WFS</code> <code>LimitiAmministrativi</code>.
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class LimitiAmministrativiServiceHelper extends AbstractServiceHelper {

    
    /**
     * Parametri costanti per la <code>request</code> al servizio dei <em>Limiti Amministrativi</em>.
     */
    // @formatter:off
    public static final String FIXED_PARAMS =
            "request=GetFeature&"
            + "service=wfs&"
            + "srs=EPSG:32632&"
            + "typename=LimitiComunali&"
            + "version=1.1.0&"
            + "outputFormat=geojson";
    // @formatter:on

    /**
     * Istanza di {@link HttpClientManager}.
     */
    private final HttpClientManager httpClientManager;

    /**
     * <code>URL</code> di base per il servizio dei. <em>Limiti Amministrativi</em>
     */
    private final String baseUrl;

    /**
     * Constructor.
     *
     * @param httpClientManager
     * @param baseUrl
     */
    public LimitiAmministrativiServiceHelper(HttpClientManager httpClientManager, String baseUrl) {
        this.httpClientManager = httpClientManager;
        this.baseUrl = baseUrl;
    }

    /**
     * Restituisce un'istanza di tipo {@link Comune} per le coordinate {@code x} e {@code y} date.
     *
     * @param x la coordinata {@code x}
     * @param y la coordinata {@code y}
     * @return l'istanza di tipo {@link Comune} per le coordinate {@code x} e {@code y} date
     * @throws ServiceException
     */
    public Comune identifyComune(double x, double y) throws ServiceException {
        LOGGER.debug("[LimitiAmministrativiService::identifyComune] BEGIN");

        try {
            final String url = this.composeRequestUrl(x, y);

            LOGGER.debug("[LimitiAmministrativiServiceHelper::identifyComune] URL: " + url);

            final HttpResponse response = this.httpClientManager.executeGetRequest(url);

            final FeatureCollection fc = new ObjectMapper().readValue(response.getContent(), FeatureCollection.class);

            final Comune comune = buildComune(fc);

            LOGGER.debug("[LimitiAmministrativiServiceHelper::identifyComune] Comune: " + comune);

            return comune;
        } catch (IOException e) {
            final Message errorMessage = this.buildMessage(MsgCodeEnum.G002, Constants.ERR_LIMAMM);
            final String errorLog = "[LimitiAmministrativiService::identifyComune] ERROR (%s): " + errorMessage.getText();

            LOGGER.error(String.format(errorLog, e.getClass().getName()), e);

            throw new ServiceException(e, errorMessage);
        } finally {
            LOGGER.debug("[LimitiAmministrativiService::identifyComune] END");
        }
    }

    /**
     * Compone l'<code>URL</code> per la <code>request</code> al servizio dei <em>Limiti Amministrativi</em>,
     * per le coordinate {@code x} e {@code y} date.
     *
     * @param x la coordinata {@code x}
     * @param y la coordinata {@code y}
     * @return l'<code>URL</code> per la <code>request</code> al servizio dei <em>Limiti Amministrativi</em>
     *         per le coordinate {@code x} e {@code y} date
     */
    private String composeRequestUrl(double x, double y) {
        // utilizzo un bounding box i cui vertici coincidono con il punto selezionato.
        final String bbox = String.format(Locale.ENGLISH, "&bbox=%f,%f,%f,%f", x, y, x, y);

        return String.format("%s?%s%s", this.baseUrl, FIXED_PARAMS, bbox);
    }

    /**
     * Restituisce un'istanza di tipo {@link Comune},
     * convertendo la prima {@link Feature} presente nella {@link FeatureCollection} data,
     * o {@code null} se quest'ultima &egrave; vuota.
     *
     * @param fc la {@link FeatureCollection} data
     * @return l'istanza di tipo {@link Comune}
     */
    private static Comune buildComune(FeatureCollection fc) {
        if (fc == null) {
            return null;
        }

        Comune comune = null;
        final List<Feature> features = fc.getFeatures();
        if (CollectionUtils.isNotEmpty(features)) {
            comune = LimAmmDtoFactory.createComune(features.get(0));
        }

        return comune;
    }

}
