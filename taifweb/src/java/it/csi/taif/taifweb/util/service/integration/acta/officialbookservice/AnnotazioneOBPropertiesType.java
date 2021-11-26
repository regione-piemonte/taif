/**
 * AnnotazioneOBPropertiesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.officialbookservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;

public class AnnotazioneOBPropertiesType  extends OfficialBookPropertiesType  implements java.io.Serializable {
    private java.lang.String descrizione;

    private java.util.Date data;

    private boolean annotazioneFormale;

    private ObjectIdType idUtenteCreazione;

    private ObjectIdType idRegistrazione;

    private ObjectIdType idRegistro;

    public AnnotazioneOBPropertiesType() {
    }

    public AnnotazioneOBPropertiesType(
           ObjectIdType objectId,
           ChangeTokenType changeToken,
           java.lang.String objectTypeId,
           java.lang.String descrizione,
           java.util.Date data,
           boolean annotazioneFormale,
           ObjectIdType idUtenteCreazione,
           ObjectIdType idRegistrazione,
           ObjectIdType idRegistro) {
        super(
            objectId,
            changeToken,
            objectTypeId);
        this.descrizione = descrizione;
        this.data = data;
        this.annotazioneFormale = annotazioneFormale;
        this.idUtenteCreazione = idUtenteCreazione;
        this.idRegistrazione = idRegistrazione;
        this.idRegistro = idRegistro;
    }


    /**
     * Gets the descrizione value for this AnnotazioneOBPropertiesType.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this AnnotazioneOBPropertiesType.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the data value for this AnnotazioneOBPropertiesType.
     * 
     * @return data
     */
    public java.util.Date getData() {
        return data;
    }


    /**
     * Sets the data value for this AnnotazioneOBPropertiesType.
     * 
     * @param data
     */
    public void setData(java.util.Date data) {
        this.data = data;
    }


    /**
     * Gets the annotazioneFormale value for this AnnotazioneOBPropertiesType.
     * 
     * @return annotazioneFormale
     */
    public boolean isAnnotazioneFormale() {
        return annotazioneFormale;
    }


    /**
     * Sets the annotazioneFormale value for this AnnotazioneOBPropertiesType.
     * 
     * @param annotazioneFormale
     */
    public void setAnnotazioneFormale(boolean annotazioneFormale) {
        this.annotazioneFormale = annotazioneFormale;
    }


    /**
     * Gets the idUtenteCreazione value for this AnnotazioneOBPropertiesType.
     * 
     * @return idUtenteCreazione
     */
    public ObjectIdType getIdUtenteCreazione() {
        return idUtenteCreazione;
    }


    /**
     * Sets the idUtenteCreazione value for this AnnotazioneOBPropertiesType.
     * 
     * @param idUtenteCreazione
     */
    public void setIdUtenteCreazione(ObjectIdType idUtenteCreazione) {
        this.idUtenteCreazione = idUtenteCreazione;
    }


    /**
     * Gets the idRegistrazione value for this AnnotazioneOBPropertiesType.
     * 
     * @return idRegistrazione
     */
    public ObjectIdType getIdRegistrazione() {
        return idRegistrazione;
    }


    /**
     * Sets the idRegistrazione value for this AnnotazioneOBPropertiesType.
     * 
     * @param idRegistrazione
     */
    public void setIdRegistrazione(ObjectIdType idRegistrazione) {
        this.idRegistrazione = idRegistrazione;
    }


    /**
     * Gets the idRegistro value for this AnnotazioneOBPropertiesType.
     * 
     * @return idRegistro
     */
    public ObjectIdType getIdRegistro() {
        return idRegistro;
    }


    /**
     * Sets the idRegistro value for this AnnotazioneOBPropertiesType.
     * 
     * @param idRegistro
     */
    public void setIdRegistro(ObjectIdType idRegistro) {
        this.idRegistro = idRegistro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnnotazioneOBPropertiesType)) return false;
        AnnotazioneOBPropertiesType other = (AnnotazioneOBPropertiesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            this.annotazioneFormale == other.isAnnotazioneFormale() &&
            ((this.idUtenteCreazione==null && other.getIdUtenteCreazione()==null) || 
             (this.idUtenteCreazione!=null &&
              this.idUtenteCreazione.equals(other.getIdUtenteCreazione()))) &&
            ((this.idRegistrazione==null && other.getIdRegistrazione()==null) || 
             (this.idRegistrazione!=null &&
              this.idRegistrazione.equals(other.getIdRegistrazione()))) &&
            ((this.idRegistro==null && other.getIdRegistro()==null) || 
             (this.idRegistro!=null &&
              this.idRegistro.equals(other.getIdRegistro())));
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
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        _hashCode += (isAnnotazioneFormale() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIdUtenteCreazione() != null) {
            _hashCode += getIdUtenteCreazione().hashCode();
        }
        if (getIdRegistrazione() != null) {
            _hashCode += getIdRegistrazione().hashCode();
        }
        if (getIdRegistro() != null) {
            _hashCode += getIdRegistro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AnnotazioneOBPropertiesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "AnnotazioneOBPropertiesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annotazioneFormale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "annotazioneFormale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUtenteCreazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUtenteCreazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRegistrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRegistrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRegistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRegistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
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
