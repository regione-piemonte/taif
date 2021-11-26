/**
 * ComplexPropertyType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.common;

public class ComplexPropertyType  extends PropertyType  implements java.io.Serializable {
    private ComplexPropertyType nested;

    public ComplexPropertyType() {
    }

    public ComplexPropertyType(
           QueryNameType queryName,
           java.lang.String[] value,
           ComplexPropertyType nested) {
        super(
            queryName,
            value);
        this.nested = nested;
    }


    /**
     * Gets the nested value for this ComplexPropertyType.
     * 
     * @return nested
     */
    public ComplexPropertyType getNested() {
        return nested;
    }


    /**
     * Sets the nested value for this ComplexPropertyType.
     * 
     * @param nested
     */
    public void setNested(ComplexPropertyType nested) {
        this.nested = nested;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ComplexPropertyType)) return false;
        ComplexPropertyType other = (ComplexPropertyType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.nested==null && other.getNested()==null) || 
             (this.nested!=null &&
              this.nested.equals(other.getNested())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getNested() != null) {
            _hashCode += getNested().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ComplexPropertyType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ComplexPropertyType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nested");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nested"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ComplexPropertyType"));
        elemField.setNillable(false);
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
