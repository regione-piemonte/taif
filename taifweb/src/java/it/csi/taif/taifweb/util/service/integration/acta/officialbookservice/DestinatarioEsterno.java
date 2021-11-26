/**
 * DestinatarioEsterno.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.officialbookservice;

public class DestinatarioEsterno  implements java.io.Serializable {
    private InfoCreazioneCorrispondente corrispondente;

    private long idRuoloCorrispondente;

    public DestinatarioEsterno() {
    }

    public DestinatarioEsterno(
           InfoCreazioneCorrispondente corrispondente,
           long idRuoloCorrispondente) {
           this.corrispondente = corrispondente;
           this.idRuoloCorrispondente = idRuoloCorrispondente;
    }


    /**
     * Gets the corrispondente value for this DestinatarioEsterno.
     * 
     * @return corrispondente
     */
    public InfoCreazioneCorrispondente getCorrispondente() {
        return corrispondente;
    }


    /**
     * Sets the corrispondente value for this DestinatarioEsterno.
     * 
     * @param corrispondente
     */
    public void setCorrispondente(InfoCreazioneCorrispondente corrispondente) {
        this.corrispondente = corrispondente;
    }


    /**
     * Gets the idRuoloCorrispondente value for this DestinatarioEsterno.
     * 
     * @return idRuoloCorrispondente
     */
    public long getIdRuoloCorrispondente() {
        return idRuoloCorrispondente;
    }


    /**
     * Sets the idRuoloCorrispondente value for this DestinatarioEsterno.
     * 
     * @param idRuoloCorrispondente
     */
    public void setIdRuoloCorrispondente(long idRuoloCorrispondente) {
        this.idRuoloCorrispondente = idRuoloCorrispondente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DestinatarioEsterno)) return false;
        DestinatarioEsterno other = (DestinatarioEsterno) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.corrispondente==null && other.getCorrispondente()==null) || 
             (this.corrispondente!=null &&
              this.corrispondente.equals(other.getCorrispondente()))) &&
            this.idRuoloCorrispondente == other.getIdRuoloCorrispondente();
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
        if (getCorrispondente() != null) {
            _hashCode += getCorrispondente().hashCode();
        }
        _hashCode += new Long(getIdRuoloCorrispondente()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DestinatarioEsterno.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "DestinatarioEsterno"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corrispondente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corrispondente"));
        elemField.setXmlType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoCreazioneCorrispondente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRuoloCorrispondente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRuoloCorrispondente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
