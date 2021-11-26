/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.geojson;

import java.util.List;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public class MultiPolygon extends Geometry<List<List<LngLatAlt>>> {

    private static final long serialVersionUID = 7448458616875640839L;

    /**
     * Constructor.
     */
    public MultiPolygon() {
        /* NOP */
    }

    /**
     * Constructor.
     * 
     * @param polygon
     */
    public MultiPolygon(Polygon polygon) {
        this.add(polygon);
    }

    /**
     * 
     * @param polygon
     * @return
     */
    public MultiPolygon add(Polygon polygon) {
        this.coordinates.add(polygon.getCoordinates());

        return this;
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
        return "MultiPolygon{} " + super.toString();
    }

}
