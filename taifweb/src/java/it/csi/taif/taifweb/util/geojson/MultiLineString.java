/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.geojson;

import java.util.List;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public class MultiLineString extends Geometry<List<LngLatAlt>> {

    private static final long serialVersionUID = 5109109442136283187L;

    /**
     * Constructor.
     */
    public MultiLineString() {
        /* NOP */
    }

    /**
     * Constructor.
     * 
     * @param line
     */
    public MultiLineString(List<LngLatAlt> line) {
        this.add(line);
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#accept(it.csi.sipra.sipraweb.util.geojson.GeoJsonObjectVisitor)
     */
    @Override
    public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
        return geoJsonObjectVisitor.visit(this);
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.Geometry#toString()
     */
    @Override
    public String toString() {
        return "MultiLineString{} " + super.toString();
    }

}
