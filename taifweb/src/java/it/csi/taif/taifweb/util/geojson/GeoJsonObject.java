/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.geojson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import it.csi.taif.taifweb.util.ArrayUtils;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
@JsonTypeInfo(property = "type", use = Id.NAME)
@JsonSubTypes({
    @Type(Feature.class),
    @Type(Polygon.class),
    @Type(MultiPolygon.class),
    @Type(FeatureCollection.class),
    @Type(Point.class),
    @Type(MultiPoint.class),
    @Type(MultiLineString.class),
    @Type(LineString.class),
    @Type(GeometryCollection.class)
})
@JsonInclude(Include.NON_NULL)
public abstract class GeoJsonObject implements Serializable {

    private static final long serialVersionUID = 7888524755529479197L;

    private Crs crs;
    private double[] bbox;

    /**
     * 
     * @return
     */
    public final Crs getCrs() {
        return this.crs;
    }

    /**
     * 
     * @param crs
     */
    public final void setCrs(Crs crs) {
        this.crs = crs;
    }

    /**
     * 
     * @return
     */
    public final double[] getBbox() {
        return ArrayUtils.copyOf(
            this.bbox, 
            org.apache.commons.lang3.ArrayUtils.getLength(this.bbox)
        );
    }

    /**
     * 
     * @param bbox
     */
    public final void setBbox(double[] bbox) {
        this.bbox = ArrayUtils.copyOf(
            bbox, 
            org.apache.commons.lang3.ArrayUtils.getLength(bbox)
        );
    }

    /**
     * 
     * @param geoJsonObjectVisitor
     * @return
     */
    public abstract <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor);

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = this.crs != null ? this.crs.hashCode() : 0;
        result = 31 * result + (this.bbox != null ? Arrays.hashCode(this.bbox) : 0);
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final GeoJsonObject geoJsonObj = (GeoJsonObject) o;
        if (this.crs != null ? ! this.crs.equals(geoJsonObj.crs) : geoJsonObj.crs != null) {
            return false;
        }
        return Arrays.equals(this.bbox, geoJsonObj.bbox);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "GeoJsonObject{}";
    }

}
