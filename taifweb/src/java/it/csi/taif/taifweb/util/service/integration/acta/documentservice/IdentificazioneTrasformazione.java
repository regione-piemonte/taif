/**
 * IdentificazioneTrasformazione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.archive.RelationshipPropertiesType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType;

public class IdentificazioneTrasformazione  implements java.io.Serializable {
    private RelationshipPropertiesType relazione;

    private ChangeTokenType dataUltimoAggiornamento;

    private FailedStepsInfo[] failedSteps;

    public IdentificazioneTrasformazione() {
    }

    public IdentificazioneTrasformazione(
           RelationshipPropertiesType relazione,
           ChangeTokenType dataUltimoAggiornamento,
           FailedStepsInfo[] failedSteps) {
           this.relazione = relazione;
           this.dataUltimoAggiornamento = dataUltimoAggiornamento;
           this.failedSteps = failedSteps;
    }


    /**
     * Gets the relazione value for this IdentificazioneTrasformazione.
     * 
     * @return relazione
     */
    public RelationshipPropertiesType getRelazione() {
        return relazione;
    }


    /**
     * Sets the relazione value for this IdentificazioneTrasformazione.
     * 
     * @param relazione
     */
    public void setRelazione(RelationshipPropertiesType relazione) {
        this.relazione = relazione;
    }


    /**
     * Gets the dataUltimoAggiornamento value for this IdentificazioneTrasformazione.
     * 
     * @return dataUltimoAggiornamento
     */
    public ChangeTokenType getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }


    /**
     * Sets the dataUltimoAggiornamento value for this IdentificazioneTrasformazione.
     * 
     * @param dataUltimoAggiornamento
     */
    public void setDataUltimoAggiornamento(ChangeTokenType dataUltimoAggiornamento) {
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }


    /**
     * Gets the failedSteps value for this IdentificazioneTrasformazione.
     * 
     * @return failedSteps
     */
    public FailedStepsInfo[] getFailedSteps() {
        return failedSteps;
    }


    /**
     * Sets the failedSteps value for this IdentificazioneTrasformazione.
     * 
     * @param failedSteps
     */
    public void setFailedSteps(FailedStepsInfo[] failedSteps) {
        this.failedSteps = failedSteps;
    }

    public FailedStepsInfo getFailedSteps(int i) {
        return this.failedSteps[i];
    }

    public void setFailedSteps(int i, FailedStepsInfo _value) {
        this.failedSteps[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdentificazioneTrasformazione)) return false;
        IdentificazioneTrasformazione other = (IdentificazioneTrasformazione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.relazione==null && other.getRelazione()==null) || 
             (this.relazione!=null &&
              this.relazione.equals(other.getRelazione()))) &&
            ((this.dataUltimoAggiornamento==null && other.getDataUltimoAggiornamento()==null) || 
             (this.dataUltimoAggiornamento!=null &&
              this.dataUltimoAggiornamento.equals(other.getDataUltimoAggiornamento()))) &&
            ((this.failedSteps==null && other.getFailedSteps()==null) || 
             (this.failedSteps!=null &&
              java.util.Arrays.equals(this.failedSteps, other.getFailedSteps())));
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
        if (getRelazione() != null) {
            _hashCode += getRelazione().hashCode();
        }
        if (getDataUltimoAggiornamento() != null) {
            _hashCode += getDataUltimoAggiornamento().hashCode();
        }
        if (getFailedSteps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFailedSteps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFailedSteps(), i);
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
        new org.apache.axis.description.TypeDesc(IdentificazioneTrasformazione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "IdentificazioneTrasformazione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "RelationshipPropertiesType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataUltimoAggiornamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataUltimoAggiornamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ChangeTokenType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("failedSteps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "failedSteps"));
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
