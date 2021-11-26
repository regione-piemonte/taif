/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.geojson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class FeatureCollection extends GeoJsonObject implements Iterable<Feature> {

    private static final long serialVersionUID = 6881547692156796439L;

    private List<Feature> features = new ArrayList<Feature>();

    /**
     * 
     * @return
     */
    public List<Feature> getFeatures() {
        return this.features;
    }

    /**
     * 
     * @param features
     */
    public void setFeatures(List<Feature> features) {
        this.features = (features == null ? new ArrayList<Feature>() : features);
    }

    /**
     * 
     * @param feature
     * @return
     */
    public FeatureCollection add(Feature feature) {
        this.features.add(feature);

        return this;
    }

    /**
     * 
     * @param features
     */
    public void addAll(Collection<Feature> features) {
        this.features.addAll(features);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<Feature> iterator() {
        return features.iterator();
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
        if (! (o instanceof FeatureCollection)) {
            return false;
        }
        final FeatureCollection features1 = (FeatureCollection) o;

        return this.features.equals(features1.features);
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#hashCode()
     */
    @Override
    public int hashCode() {
        return this.features.hashCode();
    }

    /*
     * (non-Javadoc)
     * @see it.csi.sipra.sipraweb.util.geojson.GeoJsonObject#toString()
     */
    @Override
    public String toString() {
        return "FeatureCollection{" + "features=" + this.features + '}';
    }

}
