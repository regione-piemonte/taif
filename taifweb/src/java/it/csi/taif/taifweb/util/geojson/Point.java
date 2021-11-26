/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.geojson;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public class Point extends GeoJsonObject {

    private static final long serialVersionUID = -1505396605832917419L;

    private LngLatAlt coordinates;

    /**
     * Constructor.
     */
    public Point() {
        /* NOP */
    }

    /**
     * Constructor.
     * 
     * @param coordinates
     */
    public Point(LngLatAlt coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Constructor.
     * 
     * @param longitude
     * @param latitude
     */
    public Point(double longitude, double latitude) {
        coordinates = new LngLatAlt(longitude, latitude);
    }

    /**
     * Constructor.
     * 
     * @param longitude
     * @param latitude
     * @param altitude
     */
    public Point(double longitude, double latitude, double altitude) {
        coordinates = new LngLatAlt(longitude, latitude, altitude);
    }

    /**
     * 
     * @return
     */
    public LngLatAlt getCoordinates() {
        return this.coordinates;
    }

    /**
     * 
     * @param coordinates
     */
    public void setCoordinates(LngLatAlt coordinates) {
        this.coordinates = coordinates;
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
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof Point)) {
            return false;
        }
        if (! super.equals(o)) {
            return false;
        }
        final Point point = (Point) o;

        return ! (this.coordinates != null ? ! this.coordinates.equals(point.coordinates) : point.coordinates != null);
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#hashCode()
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (this.coordinates != null ? this.coordinates.hashCode() : 0);
        return result;
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#toString()
     */
    @Override
    public String toString() {
        return "Point{" + "coordinates=" + this.coordinates + "} " + super.toString();
    }

}
