/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.geojson.jackson;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import it.csi.taif.topforweb.util.geojson.LngLatAlt;

/**
 * Specialized {@link JsonSerializer} for {@link LngLatAlt} instances.
 * 
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class LngLatAltSerializer extends JsonSerializer<LngLatAlt> {

    /*
     * (non-Javadoc)
     * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
     */
    @Override
    public void serialize(LngLatAlt value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartArray();
        jgen.writeNumber(Utils.fastDoubleToString(value.getLongitude(), 9));
        jgen.writeNumber(Utils.fastDoubleToString(value.getLatitude(), 9));
        if (value.hasAltitude()) {
            jgen.writeNumber(value.getAltitude());
        }
        jgen.writeEndArray();
    }

}
