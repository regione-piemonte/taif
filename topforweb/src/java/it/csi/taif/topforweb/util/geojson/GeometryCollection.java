/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.geojson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public class GeometryCollection extends GeoJsonObject implements Iterable<GeoJsonObject> {

    private static final long serialVersionUID = 5867617657181008611L;

    /**
     * The collected geometries.
     */
    private List<GeoJsonObject> geometries = new ArrayList<GeoJsonObject>();

    /**
     * Returns the collected geometries.
     * 
     * @return the collected geometries
     */
    public List<GeoJsonObject> getGeometries() {
        return this.geometries;
    }

    /**
     * Set the collected geometries.
     * 
     * @param geometries the collected geometries
     */
    public void setGeometries(List<GeoJsonObject> geometries) {
        this.geometries = geometries;
    }

    /**
     * Returns an {@link Iterator} on the underlying collected geometries.
     * 
     * @return an {@link Iterator} on the underlying collected geometries
     */
    public Iterator<GeoJsonObject> iterator() {
        return geometries.iterator();
    }

    /**
     * Add a new geometry to the collected geometries.
     * 
     * @param geometry the new geometry to be added to the collected geometries
     * @return the collected geometries
     */
    public GeometryCollection add(GeoJsonObject geometry) {
        this.geometries.add(geometry);

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
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof GeometryCollection)) {
            return false;
        }
        if (! super.equals(o)) {
            return false;
        }
        final GeometryCollection that = (GeometryCollection) o;

        return ! (this.geometries != null ? ! this.geometries.equals(that.geometries) : that.geometries != null);
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#hashCode()
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (this.geometries != null ? this.geometries.hashCode() : 0);
        return result;
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#toString()
     */
    @Override
    public String toString() {
        return "GeometryCollection{" + "geometries=" + this.geometries + "} " + super.toString();
    }

}
