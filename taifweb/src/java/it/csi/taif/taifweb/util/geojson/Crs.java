/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.geojson;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import it.csi.taif.taifweb.util.geojson.jackson.CrsType;

/**
 *
 * @author 71740 (Simone Cornacchia)
 */
public class Crs implements Serializable {

    private static final long serialVersionUID = -8000151457519575116L;

    private CrsType type = CrsType.NAME;
    private Map<String, Object> properties = new HashMap<String, Object>();

    /**
     * 
     * @return
     */
    public CrsType getType() {
        return this.type;
    }

    /**
     * 
     * @param type
     */
    public void setType(CrsType type) {
        this.type = type;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Crs)) {
            return false;
        }
        final Crs crs = (Crs) o;

        if (this.properties != null ? ! this.properties.equals(crs.properties) : crs.properties != null) {
            return false;
        }

        return ! (this.type != null ? ! this.type.equals(crs.type) : crs.type != null);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = this.type != null ? this.type.hashCode() : 0;
        result = 31 * result + (this.properties != null ? this.properties.hashCode() : 0);
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Crs{" + "type='" + this.type + '\'' + ", properties=" + this.properties + '}';
    }

}
