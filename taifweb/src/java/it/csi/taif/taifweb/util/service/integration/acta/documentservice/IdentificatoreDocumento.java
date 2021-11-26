/**
 * IdentificatoreDocumento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;

public class IdentificatoreDocumento  implements java.io.Serializable {
    private ObjectIdType objectIdDocumento;

    private ObjectIdType objectIdClassificazione;

    private java.lang.String tipoDocumento;

    private ChangeTokenType dataUltimoAggiornamento;

    private FailedStepsInfo[] failedStepsInfo;

    public IdentificatoreDocumento() {
    }

    public IdentificatoreDocumento(
           ObjectIdType objectIdDocumento,
           ObjectIdType objectIdClassificazione,
           java.lang.String tipoDocumento,
           ChangeTokenType dataUltimoAggiornamento,
           FailedStepsInfo[] failedStepsInfo) {
           this.objectIdDocumento = objectIdDocumento;
           this.objectIdClassificazione = objectIdClassificazione;
           this.tipoDocumento = tipoDocumento;
           this.dataUltimoAggiornamento = dataUltimoAggiornamento;
           this.failedStepsInfo = failedStepsInfo;
    }


    /**
     * Gets the objectIdDocumento value for this IdentificatoreDocumento.
     * 
     * @return objectIdDocumento
     */
    public ObjectIdType getObjectIdDocumento() {
        return objectIdDocumento;
    }


    /**
     * Sets the objectIdDocumento value for this IdentificatoreDocumento.
     * 
     * @param objectIdDocumento
     */
    public void setObjectIdDocumento(ObjectIdType objectIdDocumento) {
        this.objectIdDocumento = objectIdDocumento;
    }


    /**
     * Gets the objectIdClassificazione value for this IdentificatoreDocumento.
     * 
     * @return objectIdClassificazione
     */
    public ObjectIdType getObjectIdClassificazione() {
        return objectIdClassificazione;
    }


    /**
     * Sets the objectIdClassificazione value for this IdentificatoreDocumento.
     * 
     * @param objectIdClassificazione
     */
    public void setObjectIdClassificazione(ObjectIdType objectIdClassificazione) {
        this.objectIdClassificazione = objectIdClassificazione;
    }


    /**
     * Gets the tipoDocumento value for this IdentificatoreDocumento.
     * 
     * @return tipoDocumento
     */
    public java.lang.String getTipoDocumento() {
        return tipoDocumento;
    }


    /**
     * Sets the tipoDocumento value for this IdentificatoreDocumento.
     * 
     * @param tipoDocumento
     */
    public void setTipoDocumento(java.lang.String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    /**
     * Gets the dataUltimoAggiornamento value for this IdentificatoreDocumento.
     * 
     * @return dataUltimoAggiornamento
     */
    public ChangeTokenType getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }


    /**
     * Sets the dataUltimoAggiornamento value for this IdentificatoreDocumento.
     * 
     * @param dataUltimoAggiornamento
     */
    public void setDataUltimoAggiornamento(ChangeTokenType dataUltimoAggiornamento) {
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }


    /**
     * Gets the failedStepsInfo value for this IdentificatoreDocumento.
     * 
     * @return failedStepsInfo
     */
    public FailedStepsInfo[] getFailedStepsInfo() {
        return failedStepsInfo;
    }


    /**
     * Sets the failedStepsInfo value for this IdentificatoreDocumento.
     * 
     * @param failedStepsInfo
     */
    public void setFailedStepsInfo(FailedStepsInfo[] failedStepsInfo) {
        this.failedStepsInfo = failedStepsInfo;
    }

    public FailedStepsInfo getFailedStepsInfo(int i) {
        return this.failedStepsInfo[i];
    }

    public void setFailedStepsInfo(int i, FailedStepsInfo _value) {
        this.failedStepsInfo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdentificatoreDocumento)) return false;
        IdentificatoreDocumento other = (IdentificatoreDocumento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objectIdDocumento==null && other.getObjectIdDocumento()==null) || 
             (this.objectIdDocumento!=null &&
              this.objectIdDocumento.equals(other.getObjectIdDocumento()))) &&
            ((this.objectIdClassificazione==null && other.getObjectIdClassificazione()==null) || 
             (this.objectIdClassificazione!=null &&
              this.objectIdClassificazione.equals(other.getObjectIdClassificazione()))) &&
            ((this.tipoDocumento==null && other.getTipoDocumento()==null) || 
             (this.tipoDocumento!=null &&
              this.tipoDocumento.equals(other.getTipoDocumento()))) &&
            ((this.dataUltimoAggiornamento==null && other.getDataUltimoAggiornamento()==null) || 
             (this.dataUltimoAggiornamento!=null &&
              this.dataUltimoAggiornamento.equals(other.getDataUltimoAggiornamento()))) &&
            ((this.failedStepsInfo==null && other.getFailedStepsInfo()==null) || 
             (this.failedStepsInfo!=null &&
              java.util.Arrays.equals(this.failedStepsInfo, other.getFailedStepsInfo())));
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
        if (getObjectIdDocumento() != null) {
            _hashCode += getObjectIdDocumento().hashCode();
        }
        if (getObjectIdClassificazione() != null) {
            _hashCode += getObjectIdClassificazione().hashCode();
        }
        if (getTipoDocumento() != null) {
            _hashCode += getTipoDocumento().hashCode();
        }
        if (getDataUltimoAggiornamento() != null) {
            _hashCode += getDataUltimoAggiornamento().hashCode();
        }
        if (getFailedStepsInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFailedStepsInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFailedStepsInfo(), i);
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
        new org.apache.axis.description.TypeDesc(IdentificatoreDocumento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "IdentificatoreDocumento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectIdDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objectIdDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectIdClassificazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objectIdClassificazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataUltimoAggiornamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataUltimoAggiornamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ChangeTokenType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("failedStepsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "failedStepsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "FailedStepsInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
