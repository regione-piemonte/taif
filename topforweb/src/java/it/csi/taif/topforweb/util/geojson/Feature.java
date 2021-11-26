/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.geojson;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class Feature extends GeoJsonObject {

    private static final long serialVersionUID = -2488785814920082521L;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private Map<String, Object> properties = new HashMap<String, Object>();

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private GeoJsonObject geometry;
    private String id;

    /**
     * 
     * @param key
     * @param value
     */
    public void setProperty(String key, Object value) {
        this.properties.put(key, value);
    }

    /**
     * 
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getProperty(String key) {
        return (T) this.properties.get(key);
    }

    /**
     * 
     * @return
     */
    public Map<String, Object> getProperties() {
        return this.properties;
    }

    /**
     * 
     * @param properties
     */
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * 
     * @return
     */
    public GeoJsonObject getGeometry() {
        return this.geometry;
    }

    /**
     * 
     * @param geometry
     */
    public void setGeometry(GeoJsonObject geometry) {
        this.geometry = geometry;
    }

    /**
     * 
     * @return
     */
    public String getId() {
        return this.id;
    }

    /**
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#hashCode()
     */
    @Override public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (this.properties != null ? this.properties.hashCode() : 0);
        result = 31 * result + (this.geometry != null ? this.geometry.hashCode() : 0);
        result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
        return result;
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (! super.equals(o)) {
            return false;
        }

        final Feature feature = (Feature) o;

        if (this.properties != null ? ! this.properties.equals(feature.properties) : feature.properties != null) {
            return false;
        }
        if (this.geometry != null ? ! this.geometry.equals(feature.geometry) : feature.geometry != null) {
            return false;
        }
        return ! (this.id != null ? ! this.id.equals(feature.id) : feature.id != null);
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#toString()
     */
    @Override
    public String toString() {
        return "Feature{properties=" + this.properties + ", geometry=" + this.geometry + ", id='" + this.id + "'}";
    }

}
