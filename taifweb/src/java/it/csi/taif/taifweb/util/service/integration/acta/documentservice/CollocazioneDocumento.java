/**
 * CollocazioneDocumento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;

public class CollocazioneDocumento  implements java.io.Serializable {
    private ObjectIdType classificazioneId;

    private ObjectIdType parentId;

    private java.lang.String parentFolderType;

    private ObjectIdType classificazionePrincipaleId;

    private ObjectIdType gruppoAllegatiId;

    public CollocazioneDocumento() {
    }

    public CollocazioneDocumento(
           ObjectIdType classificazioneId,
           ObjectIdType parentId,
           java.lang.String parentFolderType,
           ObjectIdType classificazionePrincipaleId,
           ObjectIdType gruppoAllegatiId) {
           this.classificazioneId = classificazioneId;
           this.parentId = parentId;
           this.parentFolderType = parentFolderType;
           this.classificazionePrincipaleId = classificazionePrincipaleId;
           this.gruppoAllegatiId = gruppoAllegatiId;
    }


    /**
     * Gets the classificazioneId value for this CollocazioneDocumento.
     * 
     * @return classificazioneId
     */
    public ObjectIdType getClassificazioneId() {
        return classificazioneId;
    }


    /**
     * Sets the classificazioneId value for this CollocazioneDocumento.
     * 
     * @param classificazioneId
     */
    public void setClassificazioneId(ObjectIdType classificazioneId) {
        this.classificazioneId = classificazioneId;
    }


    /**
     * Gets the parentId value for this CollocazioneDocumento.
     * 
     * @return parentId
     */
    public ObjectIdType getParentId() {
        return parentId;
    }


    /**
     * Sets the parentId value for this CollocazioneDocumento.
     * 
     * @param parentId
     */
    public void setParentId(ObjectIdType parentId) {
        this.parentId = parentId;
    }


    /**
     * Gets the parentFolderType value for this CollocazioneDocumento.
     * 
     * @return parentFolderType
     */
    public java.lang.String getParentFolderType() {
        return parentFolderType;
    }


    /**
     * Sets the parentFolderType value for this CollocazioneDocumento.
     * 
     * @param parentFolderType
     */
    public void setParentFolderType(java.lang.String parentFolderType) {
        this.parentFolderType = parentFolderType;
    }


    /**
     * Gets the classificazionePrincipaleId value for this CollocazioneDocumento.
     * 
     * @return classificazionePrincipaleId
     */
    public ObjectIdType getClassificazionePrincipaleId() {
        return classificazionePrincipaleId;
    }


    /**
     * Sets the classificazionePrincipaleId value for this CollocazioneDocumento.
     * 
     * @param classificazionePrincipaleId
     */
    public void setClassificazionePrincipaleId(ObjectIdType classificazionePrincipaleId) {
        this.classificazionePrincipaleId = classificazionePrincipaleId;
    }


    /**
     * Gets the gruppoAllegatiId value for this CollocazioneDocumento.
     * 
     * @return gruppoAllegatiId
     */
    public ObjectIdType getGruppoAllegatiId() {
        return gruppoAllegatiId;
    }


    /**
     * Sets the gruppoAllegatiId value for this CollocazioneDocumento.
     * 
     * @param gruppoAllegatiId
     */
    public void setGruppoAllegatiId(ObjectIdType gruppoAllegatiId) {
        this.gruppoAllegatiId = gruppoAllegatiId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CollocazioneDocumento)) return false;
        CollocazioneDocumento other = (CollocazioneDocumento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.classificazioneId==null && other.getClassificazioneId()==null) || 
             (this.classificazioneId!=null &&
              this.classificazioneId.equals(other.getClassificazioneId()))) &&
            ((this.parentId==null && other.getParentId()==null) || 
             (this.parentId!=null &&
              this.parentId.equals(other.getParentId()))) &&
            ((this.parentFolderType==null && other.getParentFolderType()==null) || 
             (this.parentFolderType!=null &&
              this.parentFolderType.equals(other.getParentFolderType()))) &&
            ((this.classificazionePrincipaleId==null && other.getClassificazionePrincipaleId()==null) || 
             (this.classificazionePrincipaleId!=null &&
              this.classificazionePrincipaleId.equals(other.getClassificazionePrincipaleId()))) &&
            ((this.gruppoAllegatiId==null && other.getGruppoAllegatiId()==null) || 
             (this.gruppoAllegatiId!=null &&
              this.gruppoAllegatiId.equals(other.getGruppoAllegatiId())));
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
        if (getClassificazioneId() != null) {
            _hashCode += getClassificazioneId().hashCode();
        }
        if (getParentId() != null) {
            _hashCode += getParentId().hashCode();
        }
        if (getParentFolderType() != null) {
            _hashCode += getParentFolderType().hashCode();
        }
        if (getClassificazionePrincipaleId() != null) {
            _hashCode += getClassificazionePrincipaleId().hashCode();
        }
        if (getGruppoAllegatiId() != null) {
            _hashCode += getGruppoAllegatiId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CollocazioneDocumento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "CollocazioneDocumento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classificazioneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classificazioneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentFolderType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parentFolderType"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classificazionePrincipaleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classificazionePrincipaleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gruppoAllegatiId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gruppoAllegatiId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setMinOccurs(0);
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
