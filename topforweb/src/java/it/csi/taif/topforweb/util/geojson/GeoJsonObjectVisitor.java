/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.geojson;

/**
 * Visitor to handle all different types of {@link GeoJsonObject}.
 * 
 * @param <T> return type of the visitor
 * 
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public interface GeoJsonObjectVisitor<T> {

    /**
     * 
     * @param geoJsonObject
     * @return
     */
    T visit(GeometryCollection geoJsonObject);

    /**
     * 
     * @param geoJsonObject
     * @return
     */
    T visit(FeatureCollection geoJsonObject);

    /**
     * 
     * @param geoJsonObject
     * @return
     */
    T visit(Point geoJsonObject);

    /**
     * 
     * @param geoJsonObject
     * @return
     */
    T visit(Feature geoJsonObject);

    /**
     * 
     * @param geoJsonObject
     * @return
     */
    T visit(MultiLineString geoJsonObject);

    /**
     * 
     * @param geoJsonObject
     * @return
     */
    T visit(Polygon geoJsonObject);

    /**
     * 
     * @param geoJsonObject
     * @return
     */
    T visit(MultiPolygon geoJsonObject);

    /**
     * 
     * @param geoJsonObject
     * @return
     */
    T visit(MultiPoint geoJsonObject);

    /**
     * 
     * @param geoJsonObject
     * @return
     */
    T visit(LineString geoJsonObject);

}
