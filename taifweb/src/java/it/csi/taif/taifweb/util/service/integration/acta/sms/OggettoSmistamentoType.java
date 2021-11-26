/**
 * OggettoSmistamentoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.sms;

public class OggettoSmistamentoType  implements java.io.Serializable {
    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType classificazione;

    private it.csi.taif.taifweb.util.service.integration.acta.common.IdRegistrazioneType registrazione;

    public OggettoSmistamentoType() {
    }

    public OggettoSmistamentoType(
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType classificazione,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdRegistrazioneType registrazione) {
           this.classificazione = classificazione;
           this.registrazione = registrazione;
    }


    /**
     * Gets the classificazione value for this OggettoSmistamentoType.
     * 
     * @return classificazione
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getClassificazione() {
        return classificazione;
    }


    /**
     * Sets the classificazione value for this OggettoSmistamentoType.
     * 
     * @param classificazione
     */
    public void setClassificazione(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType classificazione) {
        this.classificazione = classificazione;
    }


    /**
     * Gets the registrazione value for this OggettoSmistamentoType.
     * 
     * @return registrazione
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.IdRegistrazioneType getRegistrazione() {
        return registrazione;
    }


    /**
     * Sets the registrazione value for this OggettoSmistamentoType.
     * 
     * @param registrazione
     */
    public void setRegistrazione(it.csi.taif.taifweb.util.service.integration.acta.common.IdRegistrazioneType registrazione) {
        this.registrazione = registrazione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OggettoSmistamentoType)) return false;
        OggettoSmistamentoType other = (OggettoSmistamentoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.classificazione==null && other.getClassificazione()==null) || 
             (this.classificazione!=null &&
              this.classificazione.equals(other.getClassificazione()))) &&
            ((this.registrazione==null && other.getRegistrazione()==null) || 
             (this.registrazione!=null &&
              this.registrazione.equals(other.getRegistrazione())));
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
        if (getClassificazione() != null) {
            _hashCode += getClassificazione().hashCode();
        }
        if (getRegistrazione() != null) {
            _hashCode += getRegistrazione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OggettoSmistamentoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("sms.acaris.acta.doqui.it", "OggettoSmistamentoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classificazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classificazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "IdRegistrazioneType"));
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
