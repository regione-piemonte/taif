/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.geojson;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public class LineString extends MultiPoint {

    private static final long serialVersionUID = -1864822276062905627L;

    /**
     * Constructor.
     */
    public LineString() {
        /* NOP */
    }

    /**
     * Constructor.
     * 
     * @param points
     */
    public LineString(LngLatAlt... points) {
        super(points);
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.MultiPoint#accept(it.csi.sipra.sipraweb.util.geojson.GeoJsonObjectVisitor)
     */
    @Override
    public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
        return geoJsonObjectVisitor.visit(this);
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.MultiPoint#toString()
     */
    @Override
    public String toString() {
        return "LineString{} " + super.toString();
    }

}
