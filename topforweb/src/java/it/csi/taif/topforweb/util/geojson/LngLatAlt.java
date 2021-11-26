/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.geojson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import it.csi.taif.topforweb.util.geojson.jackson.LngLatAltDeserializer;
import it.csi.taif.topforweb.util.geojson.jackson.LngLatAltSerializer;

import java.io.Serializable;

/**
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
@JsonDeserialize(using = LngLatAltDeserializer.class)
@JsonSerialize(using = LngLatAltSerializer.class)
public final class LngLatAlt implements Serializable {

    private static final long serialVersionUID = 2142652203752007202L;

    private double longitude;
    private double latitude;
    private double altitude = Double.NaN;

    /**
     * Constructor.
     */
    public LngLatAlt() {
        /* NOP */
    }

    /**
     * Constructor.
     *
     * @param longitude
     * @param latitude
     */
    public LngLatAlt(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Constructor.
     *
     * @param longitude
     * @param latitude
     * @param altitude
     */
    public LngLatAlt(double longitude, double latitude, double altitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    /**
     * 
     * @return
     */
    public boolean hasAltitude() {
        return ! Double.isNaN(this.altitude);
    }

    /**
     * 
     * @return
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * 
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * 
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     */
    public double getAltitude() {
        return this.altitude;
    }

    /**
     * 
     * @param altitude
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(this.longitude);
        int result = (int)(temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.altitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
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
        if (! (o instanceof LngLatAlt)) {
            return false;
        }
        final LngLatAlt lngLatAlt = (LngLatAlt) o;
        return
            Double.compare(lngLatAlt.latitude, this.latitude) == 0 &&
            Double.compare(lngLatAlt.longitude, this.longitude) == 0 &&
            Double.compare(lngLatAlt.altitude, this.altitude) == 0;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LngLatAlt{" + "longitude=" + this.longitude + ", latitude=" + this.latitude + ", altitude=" + this.altitude + '}';
    }

}
