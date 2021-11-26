/**
 * CodiceFiscalePartitaIvaCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class CodiceFiscalePartitaIvaCR  implements java.io.Serializable {
    private java.lang.String valoreCFPI;

    public CodiceFiscalePartitaIvaCR() {
    }

    public CodiceFiscalePartitaIvaCR(
           java.lang.String valoreCFPI) {
           this.valoreCFPI = valoreCFPI;
    }


    /**
     * Gets the valoreCFPI value for this CodiceFiscalePartitaIvaCR.
     * 
     * @return valoreCFPI
     */
    public java.lang.String getValoreCFPI() {
        return valoreCFPI;
    }


    /**
     * Sets the valoreCFPI value for this CodiceFiscalePartitaIvaCR.
     * 
     * @param valoreCFPI
     */
    public void setValoreCFPI(java.lang.String valoreCFPI) {
        this.valoreCFPI = valoreCFPI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CodiceFiscalePartitaIvaCR)) return false;
        CodiceFiscalePartitaIvaCR other = (CodiceFiscalePartitaIvaCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.valoreCFPI==null && other.getValoreCFPI()==null) || 
             (this.valoreCFPI!=null &&
              this.valoreCFPI.equals(other.getValoreCFPI())));
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
        if (getValoreCFPI() != null) {
            _hashCode += getValoreCFPI().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CodiceFiscalePartitaIvaCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "CodiceFiscalePartitaIvaCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valoreCFPI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valoreCFPI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
