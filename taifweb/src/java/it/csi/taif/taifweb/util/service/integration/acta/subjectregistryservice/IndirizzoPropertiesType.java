/**
 * IndirizzoPropertiesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class IndirizzoPropertiesType  extends SubjectRegistryPropertiesType  implements java.io.Serializable {
    private java.lang.String indirizzo;

    private it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType tipoIndirizzo;

    private java.lang.String cap;

    private java.lang.String frazione;

    private java.lang.String regione;

    private java.lang.String provincia;

    private java.lang.String comune;

    private java.lang.String siglaProvincia;

    private java.lang.String stato;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idSoggetto;

    public IndirizzoPropertiesType() {
    }

    public IndirizzoPropertiesType(
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId,
           it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType changeToken,
           java.lang.String objectTypeId,
           java.lang.String indirizzo,
           it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType tipoIndirizzo,
           java.lang.String cap,
           java.lang.String frazione,
           java.lang.String regione,
           java.lang.String provincia,
           java.lang.String comune,
           java.lang.String siglaProvincia,
           java.lang.String stato,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idSoggetto) {
        super(
            objectId,
            changeToken,
            objectTypeId);
        this.indirizzo = indirizzo;
        this.tipoIndirizzo = tipoIndirizzo;
        this.cap = cap;
        this.frazione = frazione;
        this.regione = regione;
        this.provincia = provincia;
        this.comune = comune;
        this.siglaProvincia = siglaProvincia;
        this.stato = stato;
        this.idSoggetto = idSoggetto;
    }


    /**
     * Gets the indirizzo value for this IndirizzoPropertiesType.
     * 
     * @return indirizzo
     */
    public java.lang.String getIndirizzo() {
        return indirizzo;
    }


    /**
     * Sets the indirizzo value for this IndirizzoPropertiesType.
     * 
     * @param indirizzo
     */
    public void setIndirizzo(java.lang.String indirizzo) {
        this.indirizzo = indirizzo;
    }


    /**
     * Gets the tipoIndirizzo value for this IndirizzoPropertiesType.
     * 
     * @return tipoIndirizzo
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType getTipoIndirizzo() {
        return tipoIndirizzo;
    }


    /**
     * Sets the tipoIndirizzo value for this IndirizzoPropertiesType.
     * 
     * @param tipoIndirizzo
     */
    public void setTipoIndirizzo(it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType tipoIndirizzo) {
        this.tipoIndirizzo = tipoIndirizzo;
    }


    /**
     * Gets the cap value for this IndirizzoPropertiesType.
     * 
     * @return cap
     */
    public java.lang.String getCap() {
        return cap;
    }


    /**
     * Sets the cap value for this IndirizzoPropertiesType.
     * 
     * @param cap
     */
    public void setCap(java.lang.String cap) {
        this.cap = cap;
    }


    /**
     * Gets the frazione value for this IndirizzoPropertiesType.
     * 
     * @return frazione
     */
    public java.lang.String getFrazione() {
        return frazione;
    }


    /**
     * Sets the frazione value for this IndirizzoPropertiesType.
     * 
     * @param frazione
     */
    public void setFrazione(java.lang.String frazione) {
        this.frazione = frazione;
    }


    /**
     * Gets the regione value for this IndirizzoPropertiesType.
     * 
     * @return regione
     */
    public java.lang.String getRegione() {
        return regione;
    }


    /**
     * Sets the regione value for this IndirizzoPropertiesType.
     * 
     * @param regione
     */
    public void setRegione(java.lang.String regione) {
        this.regione = regione;
    }


    /**
     * Gets the provincia value for this IndirizzoPropertiesType.
     * 
     * @return provincia
     */
    public java.lang.String getProvincia() {
        return provincia;
    }


    /**
     * Sets the provincia value for this IndirizzoPropertiesType.
     * 
     * @param provincia
     */
    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }


    /**
     * Gets the comune value for this IndirizzoPropertiesType.
     * 
     * @return comune
     */
    public java.lang.String getComune() {
        return comune;
    }


    /**
     * Sets the comune value for this IndirizzoPropertiesType.
     * 
     * @param comune
     */
    public void setComune(java.lang.String comune) {
        this.comune = comune;
    }


    /**
     * Gets the siglaProvincia value for this IndirizzoPropertiesType.
     * 
     * @return siglaProvincia
     */
    public java.lang.String getSiglaProvincia() {
        return siglaProvincia;
    }


    /**
     * Sets the siglaProvincia value for this IndirizzoPropertiesType.
     * 
     * @param siglaProvincia
     */
    public void setSiglaProvincia(java.lang.String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }


    /**
     * Gets the stato value for this IndirizzoPropertiesType.
     * 
     * @return stato
     */
    public java.lang.String getStato() {
        return stato;
    }


    /**
     * Sets the stato value for this IndirizzoPropertiesType.
     * 
     * @param stato
     */
    public void setStato(java.lang.String stato) {
        this.stato = stato;
    }


    /**
     * Gets the idSoggetto value for this IndirizzoPropertiesType.
     * 
     * @return idSoggetto
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdSoggetto() {
        return idSoggetto;
    }


    /**
     * Sets the idSoggetto value for this IndirizzoPropertiesType.
     * 
     * @param idSoggetto
     */
    public void setIdSoggetto(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idSoggetto) {
        this.idSoggetto = idSoggetto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IndirizzoPropertiesType)) return false;
        IndirizzoPropertiesType other = (IndirizzoPropertiesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.indirizzo==null && other.getIndirizzo()==null) || 
             (this.indirizzo!=null &&
              this.indirizzo.equals(other.getIndirizzo()))) &&
            ((this.tipoIndirizzo==null && other.getTipoIndirizzo()==null) || 
             (this.tipoIndirizzo!=null &&
              this.tipoIndirizzo.equals(other.getTipoIndirizzo()))) &&
            ((this.cap==null && other.getCap()==null) || 
             (this.cap!=null &&
              this.cap.equals(other.getCap()))) &&
            ((this.frazione==null && other.getFrazione()==null) || 
             (this.frazione!=null &&
              this.frazione.equals(other.getFrazione()))) &&
            ((this.regione==null && other.getRegione()==null) || 
             (this.regione!=null &&
              this.regione.equals(other.getRegione()))) &&
            ((this.provincia==null && other.getProvincia()==null) || 
             (this.provincia!=null &&
              this.provincia.equals(other.getProvincia()))) &&
            ((this.comune==null && other.getComune()==null) || 
             (this.comune!=null &&
              this.comune.equals(other.getComune()))) &&
            ((this.siglaProvincia==null && other.getSiglaProvincia()==null) || 
             (this.siglaProvincia!=null &&
              this.siglaProvincia.equals(other.getSiglaProvincia()))) &&
            ((this.stato==null && other.getStato()==null) || 
             (this.stato!=null &&
              this.stato.equals(other.getStato()))) &&
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
        if (getIndirizzo() != null) {
            _hashCode += getIndirizzo().hashCode();
        }
        if (getTipoIndirizzo() != null) {
            _hashCode += getTipoIndirizzo().hashCode();
        }
        if (getCap() != null) {
            _hashCode += getCap().hashCode();
        }
        if (getFrazione() != null) {
            _hashCode += getFrazione().hashCode();
        }
        if (getRegione() != null) {
            _hashCode += getRegione().hashCode();
        }
        if (getProvincia() != null) {
            _hashCode += getProvincia().hashCode();
        }
        if (getComune() != null) {
            _hashCode += getComune().hashCode();
        }
        if (getSiglaProvincia() != null) {
            _hashCode += getSiglaProvincia().hashCode();
        }
        if (getStato() != null) {
            _hashCode += getStato().hashCode();
        }
        if (getIdSoggetto() != null) {
            _hashCode += getIdSoggetto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IndirizzoPropertiesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "IndirizzoPropertiesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indirizzo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoIndirizzo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoIndirizzo"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provincia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provincia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comune");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comune"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siglaProvincia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "siglaProvincia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
