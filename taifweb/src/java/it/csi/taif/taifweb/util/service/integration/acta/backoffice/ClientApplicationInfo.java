/**
 * ClientApplicationInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.backoffice;

public class ClientApplicationInfo  implements java.io.Serializable {
    private java.lang.String appKey;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ItemType[] info;

    public ClientApplicationInfo() {
    }

    public ClientApplicationInfo(
           java.lang.String appKey,
           it.csi.taif.taifweb.util.service.integration.acta.common.ItemType[] info) {
           this.appKey = appKey;
           this.info = info;
    }


    /**
     * Gets the appKey value for this ClientApplicationInfo.
     * 
     * @return appKey
     */
    public java.lang.String getAppKey() {
        return appKey;
    }


    /**
     * Sets the appKey value for this ClientApplicationInfo.
     * 
     * @param appKey
     */
    public void setAppKey(java.lang.String appKey) {
        this.appKey = appKey;
    }


    /**
     * Gets the info value for this ClientApplicationInfo.
     * 
     * @return info
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ItemType[] getInfo() {
        return info;
    }


    /**
     * Sets the info value for this ClientApplicationInfo.
     * 
     * @param info
     */
    public void setInfo(it.csi.taif.taifweb.util.service.integration.acta.common.ItemType[] info) {
        this.info = info;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClientApplicationInfo)) return false;
        ClientApplicationInfo other = (ClientApplicationInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.appKey==null && other.getAppKey()==null) || 
             (this.appKey!=null &&
              this.appKey.equals(other.getAppKey()))) &&
            ((this.info==null && other.getInfo()==null) || 
             (this.info!=null &&
              java.util.Arrays.equals(this.info, other.getInfo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAppKey() != null) {
            _hashCode += getAppKey().hashCode();
        }
        if (getInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInfo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClientApplicationInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("backoffice.acaris.acta.doqui.it", "ClientApplicationInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "appKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("info");
        elemField.setXmlName(new javax.xml.namespace.QName("", "info"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ItemType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "items"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
