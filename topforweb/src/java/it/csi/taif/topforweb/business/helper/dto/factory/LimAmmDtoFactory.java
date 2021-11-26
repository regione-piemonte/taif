/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.helper.dto.factory;

import static it.csi.taif.topforweb.util.ConvertUtil.toStringValue;

import java.util.Map;

import it.csi.taif.topforweb.util.geojson.Feature;
import it.csi.taif.topforweb.business.helper.dto.Comune;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class LimAmmDtoFactory {

    /**
     * Converte le informazioni definite nella {@link Feature} data per un <em>Comune</em>,
     * ottenuta dall'invocazione al servizio dei <em>Limiti Amministrativi</em>,
     * in un'istanza di tipo {@link Comune}.<br />
     * Delle informazioni definite nella {@link Feature} data vengono prese in considerazione le seguenti:
     * <ul>
     *    <li><code>Codice</code> <code>ISTAT</code> del <em>Comune</em></li>
     *    <li><code>Toponimo</code> del <em>Comune</em></li>
     * </ul>
     *
     * @param source la {@link Feature} data per un <em>Comune</em>,
     *               ottenuta dall'invocazione al servizio dei <em>Limiti Amministrativi</em>
     * @return l'istanza di tipo {@link Comune}
     */
    public static Comune createComune(Feature source) {
        if (source == null) {
            return null;
        }

        final Map<String, Object> properties = source.getProperties();

        final Comune target = new Comune(
            toStringValue(properties.get(ComuneFeatureProperty.ISTAT)),
            toStringValue(properties.get(ComuneFeatureProperty.TOPONIMO))
        );

        return target;
    }

    /**
     * Constructor.
     */
    private LimAmmDtoFactory() {
        /* NOP */
    }

    /**
     *
     * @author 71740 (Simone Cornacchia)
     */
    private static final class ComuneFeatureProperty {

        /**
         * Propriet&agrave; nella <code>Feature</code> <code>GeoJSON</code>
         * corrispondente al <code>Codice</code> <code>ISTAT</code> del <em>Comune</em>.
         */
        static final String ISTAT = "comune_ist";

        /**
         * Propriet&agrave; nella <code>Feature</code> <code>GeoJSON</code>
         * corrispondente al <code>Toponimo</code> del <em>Comune</em>.
         */
        static final String TOPONIMO = "comune_nom";

        /**
         * Constructor.
         */
        private ComuneFeatureProperty() {
            /* NOP */
        }

    }

}
