/**
 * IdentificazioneSoggetto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class IdentificazioneSoggetto  implements java.io.Serializable {
    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType soggettoId;

    private java.lang.String tipoSoggetto;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType dataUltimoAggiornamento;

    public IdentificazioneSoggetto() {
    }

    public IdentificazioneSoggetto(
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType soggettoId,
           java.lang.String tipoSoggetto,
           it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType dataUltimoAggiornamento) {
           this.soggettoId = soggettoId;
           this.tipoSoggetto = tipoSoggetto;
           this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }


    /**
     * Gets the soggettoId value for this IdentificazioneSoggetto.
     * 
     * @return soggettoId
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getSoggettoId() {
        return soggettoId;
    }


    /**
     * Sets the soggettoId value for this IdentificazioneSoggetto.
     * 
     * @param soggettoId
     */
    public void setSoggettoId(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType soggettoId) {
        this.soggettoId = soggettoId;
    }


    /**
     * Gets the tipoSoggetto value for this IdentificazioneSoggetto.
     * 
     * @return tipoSoggetto
     */
    public java.lang.String getTipoSoggetto() {
        return tipoSoggetto;
    }


    /**
     * Sets the tipoSoggetto value for this IdentificazioneSoggetto.
     * 
     * @param tipoSoggetto
     */
    public void setTipoSoggetto(java.lang.String tipoSoggetto) {
        this.tipoSoggetto = tipoSoggetto;
    }


    /**
     * Gets the dataUltimoAggiornamento value for this IdentificazioneSoggetto.
     * 
     * @return dataUltimoAggiornamento
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }


    /**
     * Sets the dataUltimoAggiornamento value for this IdentificazioneSoggetto.
     * 
     * @param dataUltimoAggiornamento
     */
    public void setDataUltimoAggiornamento(it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType dataUltimoAggiornamento) {
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdentificazioneSoggetto)) return false;
        IdentificazioneSoggetto other = (IdentificazioneSoggetto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.soggettoId==null && other.getSoggettoId()==null) || 
             (this.soggettoId!=null &&
              this.soggettoId.equals(other.getSoggettoId()))) &&
            ((this.tipoSoggetto==null && other.getTipoSoggetto()==null) || 
             (this.tipoSoggetto!=null &&
              this.tipoSoggetto.equals(other.getTipoSoggetto()))) &&
            ((this.dataUltimoAggiornamento==null && other.getDataUltimoAggiornamento()==null) || 
             (this.dataUltimoAggiornamento!=null &&
              this.dataUltimoAggiornamento.equals(other.getDataUltimoAggiornamento())));
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
        if (getSoggettoId() != null) {
            _hashCode += getSoggettoId().hashCode();
        }
        if (getTipoSoggetto() != null) {
            _hashCode += getTipoSoggetto().hashCode();
        }
        if (getDataUltimoAggiornamento() != null) {
            _hashCode += getDataUltimoAggiornamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IdentificazioneSoggetto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "IdentificazioneSoggetto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("soggettoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "soggettoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoSoggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoSoggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataUltimoAggiornamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataUltimoAggiornamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ChangeTokenType"));
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
