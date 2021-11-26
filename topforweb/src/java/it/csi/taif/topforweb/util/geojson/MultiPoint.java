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
public class MultiPoint extends Geometry<LngLatAlt> {

    private static final long serialVersionUID = 7146289261212313093L;

    /**
     * Constructor.
     */
    public MultiPoint() {
        /* NOP */
    }

    /**
     * Constructor.
     * 
     * @param points
     */
    public MultiPoint(LngLatAlt... points) {
        super(points);
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
        return "MultiPoint{} " + super.toString();
    }

}
