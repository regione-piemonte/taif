/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.geojson;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public abstract class Geometry<T> extends GeoJsonObject {

    private static final long serialVersionUID = -6462772046699973358L;

    protected List<T> coordinates = new ArrayList<T>();

    /**
     * Constructor.
     */
    public Geometry() {
        /* NOP */
    }

    /**
     * Constructor.
     * 
     * @param elements
     */
    public Geometry(T... elements) {
        for (T coordinate : elements) {
            coordinates.add(coordinate);
        }
    }

    /**
     * 
     * @param elements
     * @return
     */
    public Geometry<T> add(T elements) {
        this.coordinates.add(elements);

        return this;
    }

    /**
     * 
     * @return
     */
    public List<T> getCoordinates() {
        return this.coordinates;
    }

    /**
     * 
     * @param coordinates
     */
    public void setCoordinates(List<T> coordinates) {
        this.coordinates = coordinates;
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#equals(java.lang.Object)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof Geometry)) {
            return false;
        }
        if (! super.equals(o)) {
            return false;
        }
        final Geometry geometry = (Geometry)o;
        return ! (this.coordinates != null ? ! this.coordinates.equals(geometry.coordinates) : geometry.coordinates != null);
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
        return "Geometry{" + "coordinates=" + this.coordinates + "} " + super.toString();
    }

}
