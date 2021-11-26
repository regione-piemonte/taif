/**
 * LogAnagraficaPropertiesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class LogAnagraficaPropertiesType  extends SubjectRegistryPropertiesType  implements java.io.Serializable {
    private java.util.Date dataModifica;

    private java.lang.String vecchioValore;

    private boolean modificatoDaFonte;

    private int idCampo;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idUtenteCreazione;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idSoggetto;

    public LogAnagraficaPropertiesType() {
    }

    public LogAnagraficaPropertiesType(
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId,
           it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType changeToken,
           java.lang.String objectTypeId,
           java.util.Date dataModifica,
           java.lang.String vecchioValore,
           boolean modificatoDaFonte,
           int idCampo,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idUtenteCreazione,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idSoggetto) {
        super(
            objectId,
            changeToken,
            objectTypeId);
        this.dataModifica = dataModifica;
        this.vecchioValore = vecchioValore;
        this.modificatoDaFonte = modificatoDaFonte;
        this.idCampo = idCampo;
        this.idUtenteCreazione = idUtenteCreazione;
        this.idSoggetto = idSoggetto;
    }


    /**
     * Gets the dataModifica value for this LogAnagraficaPropertiesType.
     * 
     * @return dataModifica
     */
    public java.util.Date getDataModifica() {
        return dataModifica;
    }


    /**
     * Sets the dataModifica value for this LogAnagraficaPropertiesType.
     * 
     * @param dataModifica
     */
    public void setDataModifica(java.util.Date dataModifica) {
        this.dataModifica = dataModifica;
    }


    /**
     * Gets the vecchioValore value for this LogAnagraficaPropertiesType.
     * 
     * @return vecchioValore
     */
    public java.lang.String getVecchioValore() {
        return vecchioValore;
    }


    /**
     * Sets the vecchioValore value for this LogAnagraficaPropertiesType.
     * 
     * @param vecchioValore
     */
    public void setVecchioValore(java.lang.String vecchioValore) {
        this.vecchioValore = vecchioValore;
    }


    /**
     * Gets the modificatoDaFonte value for this LogAnagraficaPropertiesType.
     * 
     * @return modificatoDaFonte
     */
    public boolean isModificatoDaFonte() {
        return modificatoDaFonte;
    }


    /**
     * Sets the modificatoDaFonte value for this LogAnagraficaPropertiesType.
     * 
     * @param modificatoDaFonte
     */
    public void setModificatoDaFonte(boolean modificatoDaFonte) {
        this.modificatoDaFonte = modificatoDaFonte;
    }


    /**
     * Gets the idCampo value for this LogAnagraficaPropertiesType.
     * 
     * @return idCampo
     */
    public int getIdCampo() {
        return idCampo;
    }


    /**
     * Sets the idCampo value for this LogAnagraficaPropertiesType.
     * 
     * @param idCampo
     */
    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }


    /**
     * Gets the idUtenteCreazione value for this LogAnagraficaPropertiesType.
     * 
     * @return idUtenteCreazione
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdUtenteCreazione() {
        return idUtenteCreazione;
    }


    /**
     * Sets the idUtenteCreazione value for this LogAnagraficaPropertiesType.
     * 
     * @param idUtenteCreazione
     */
    public void setIdUtenteCreazione(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idUtenteCreazione) {
        this.idUtenteCreazione = idUtenteCreazione;
    }


    /**
     * Gets the idSoggetto value for this LogAnagraficaPropertiesType.
     * 
     * @return idSoggetto
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdSoggetto() {
        return idSoggetto;
    }


    /**
     * Sets the idSoggetto value for this LogAnagraficaPropertiesType.
     * 
     * @param idSoggetto
     */
    public void setIdSoggetto(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idSoggetto) {
        this.idSoggetto = idSoggetto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LogAnagraficaPropertiesType)) return false;
        LogAnagraficaPropertiesType other = (LogAnagraficaPropertiesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dataModifica==null && other.getDataModifica()==null) || 
             (this.dataModifica!=null &&
              this.dataModifica.equals(other.getDataModifica()))) &&
            ((this.vecchioValore==null && other.getVecchioValore()==null) || 
             (this.vecchioValore!=null &&
              this.vecchioValore.equals(other.getVecchioValore()))) &&
            this.modificatoDaFonte == other.isModificatoDaFonte() &&
            this.idCampo == other.getIdCampo() &&
            ((this.idUtenteCreazione==null && other.getIdUtenteCreazione()==null) || 
             (this.idUtenteCreazione!=null &&
              this.idUtenteCreazione.equals(other.getIdUtenteCreazione()))) &&
            ((this.idSoggetto==null && other.getIdSoggetto()==null) || 
             (this.idSoggetto!=null &&
              this.idSoggetto.equals(other.getIdSoggetto())));
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
        if (getDataModifica() != null) {
            _hashCode += getDataModifica().hashCode();
        }
        if (getVecchioValore() != null) {
            _hashCode += getVecchioValore().hashCode();
        }
        _hashCode += (isModificatoDaFonte() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getIdCampo();
        if (getIdUtenteCreazione() != null) {
            _hashCode += getIdUtenteCreazione().hashCode();
        }
        if (getIdSoggetto() != null) {
            _hashCode += getIdSoggetto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LogAnagraficaPropertiesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "LogAnagraficaPropertiesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataModifica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataModifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vecchioValore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vecchioValore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modificatoDaFonte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modificatoDaFonte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCampo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCampo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUtenteCreazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUtenteCreazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idSoggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idSoggetto"));
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
