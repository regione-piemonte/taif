/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.geojson;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public class Polygon extends Geometry<List<LngLatAlt>> {

    private static final long serialVersionUID = -1195925362008306013L;

    /**
     * Constructor.
     */
    public Polygon() {
        /* NOP */
    }

    /**
     * Constructor.
     * 
     * @param polygon
     */
    public Polygon(List<LngLatAlt> polygon) {
        this.add(polygon);
    }

    /**
     * Constructor.
     * 
     * @param polygon
     */
    public Polygon(LngLatAlt... polygon) {
        this.add(Arrays.asList(polygon));
    }

    /**
     * 
     * @param points
     */
    public void setExteriorRing(List<LngLatAlt> points) {
        this.coordinates.add(0, points);
    }

    /**
     * 
     * @return
     */
    @JsonIgnore
    public List<LngLatAlt> getExteriorRing() {
        this.assertExteriorRing();

        return coordinates.get(0);
    }

    /**
     * 
     * @return
     */
    @JsonIgnore
    public List<List<LngLatAlt>> getInteriorRings() {
        this.assertExteriorRing();

        return coordinates.subList(1, coordinates.size());
    }

    /**
     * 
     * @param index
     * @return
     */
    public List<LngLatAlt> getInteriorRing(int index) {
        this.assertExteriorRing();

        return coordinates.get(1 + index);
    }

    /**
     * 
     * @param points
     */
    public void addInteriorRing(List<LngLatAlt> points) {
        this.assertExteriorRing();

        this.coordinates.add(points);
    }

    /**
     * 
     * @param points
     */
    public void addInteriorRing(LngLatAlt... points) {
        this.assertExteriorRing();

        this.coordinates.add(Arrays.asList(points));
    }

    /**
     * 
     * @throws IllegalStateException if there is no exterior ring defined
     */
    private void assertExteriorRing() {
        if (this.coordinates.isEmpty()) {
            throw new IllegalStateException("No exterior ring definied");
        }
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
        return "Polygon{} " + super.toString();
    }

}
