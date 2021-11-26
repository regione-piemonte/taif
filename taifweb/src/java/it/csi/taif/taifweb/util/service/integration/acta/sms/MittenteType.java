/**
 * MittenteType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.sms;

public class MittenteType  implements java.io.Serializable {
    private it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType utente;

    public MittenteType() {
    }

    public MittenteType(
           it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType utente) {
           this.utente = utente;
    }


    /**
     * Gets the utente value for this MittenteType.
     * 
     * @return utente
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType getUtente() {
        return utente;
    }


    /**
     * Sets the utente value for this MittenteType.
     * 
     * @param utente
     */
    public void setUtente(it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType utente) {
        this.utente = utente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MittenteType)) return false;
        MittenteType other = (MittenteType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.utente==null && other.getUtente()==null) || 
             (this.utente!=null &&
              this.utente.equals(other.getUtente())));
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
        if (getUtente() != null) {
            _hashCode += getUtente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MittenteType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("sms.acaris.acta.doqui.it", "MittenteType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("utente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "utente"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "IdUtenteType"));
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
