/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.geojson.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import it.csi.taif.taifweb.util.geojson.LngLatAlt;

/**
 * Specialized {@link JsonDeserializer} for {@link LngLatAlt} instances.
 * 
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class LngLatAltDeserializer extends JsonDeserializer<LngLatAlt> {

    /*
     * (non-Javadoc)
     * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
     */
    @Override
    public LngLatAlt deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if (jp.isExpectedStartArrayToken()) {
            return this.deserializeArray(jp, ctxt);
        }

        throw ctxt.mappingException(LngLatAlt.class);
    }

    /**
     * 
     * @param jp
     * @param ctxt
     * @return
     * @throws IOException
     * @throws JsonProcessingException
     */
    private LngLatAlt deserializeArray(JsonParser jp, DeserializationContext ctxt) throws IOException {
        final LngLatAlt node = new LngLatAlt();
        node.setLongitude(this.extractDouble(jp, ctxt, false));
        node.setLatitude(this.extractDouble(jp, ctxt, false));
        node.setAltitude(this.extractDouble(jp, ctxt, true));

        if (jp.hasCurrentToken() && jp.getCurrentToken() != JsonToken.END_ARRAY) {
            jp.nextToken();
        }

        return node;
    }

    /**
     * 
     * @param jp
     * @param ctxt
     * @param optional
     * @return
     * @throws JsonParseException
     * @throws IOException
     */
    private double extractDouble(JsonParser jp, DeserializationContext ctxt, boolean optional) throws IOException {
        final JsonToken token = jp.nextToken();
        if (token == null) {
            if (optional) {
                return Double.NaN;
            } else {
                throw ctxt.mappingException("Unexpected end-of-input when binding data into LngLatAlt");
            }
        } else {
            switch (token) {
                case END_ARRAY:
                    if (optional) {
                        return Double.NaN;
                    }
                    throw ctxt.mappingException("Unexpected end-of-input when binding data into LngLatAlt");
                case VALUE_NUMBER_FLOAT:
                    return jp.getDoubleValue();
                case VALUE_NUMBER_INT:
                    return jp.getLongValue();
                default:
                    throw ctxt.mappingException("Unexpected token (" + token.name() + ") when binding data into LngLatAlt ");
            }
        }
    }

}
