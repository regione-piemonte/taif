/**
 * InfoCreazioneIndirizzo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class InfoCreazioneIndirizzo  implements java.io.Serializable {
    private int idTipoIndirizzo;

    private java.lang.String indirizzo;

    private java.lang.String cap;

    private java.lang.String frazione;

    private java.lang.String regione;

    private java.lang.String provincia;

    private java.lang.String comune;

    private java.lang.String siglaProvincia;

    private java.lang.String stato;

    public InfoCreazioneIndirizzo() {
    }

    public InfoCreazioneIndirizzo(
           int idTipoIndirizzo,
           java.lang.String indirizzo,
           java.lang.String cap,
           java.lang.String frazione,
           java.lang.String regione,
           java.lang.String provincia,
           java.lang.String comune,
           java.lang.String siglaProvincia,
           java.lang.String stato) {
           this.idTipoIndirizzo = idTipoIndirizzo;
           this.indirizzo = indirizzo;
           this.cap = cap;
           this.frazione = frazione;
           this.regione = regione;
           this.provincia = provincia;
           this.comune = comune;
           this.siglaProvincia = siglaProvincia;
           this.stato = stato;
    }


    /**
     * Gets the idTipoIndirizzo value for this InfoCreazioneIndirizzo.
     * 
     * @return idTipoIndirizzo
     */
    public int getIdTipoIndirizzo() {
        return idTipoIndirizzo;
    }


    /**
     * Sets the idTipoIndirizzo value for this InfoCreazioneIndirizzo.
     * 
     * @param idTipoIndirizzo
     */
    public void setIdTipoIndirizzo(int idTipoIndirizzo) {
        this.idTipoIndirizzo = idTipoIndirizzo;
    }


    /**
     * Gets the indirizzo value for this InfoCreazioneIndirizzo.
     * 
     * @return indirizzo
     */
    public java.lang.String getIndirizzo() {
        return indirizzo;
    }


    /**
     * Sets the indirizzo value for this InfoCreazioneIndirizzo.
     * 
     * @param indirizzo
     */
    public void setIndirizzo(java.lang.String indirizzo) {
        this.indirizzo = indirizzo;
    }


    /**
     * Gets the cap value for this InfoCreazioneIndirizzo.
     * 
     * @return cap
     */
    public java.lang.String getCap() {
        return cap;
    }


    /**
     * Sets the cap value for this InfoCreazioneIndirizzo.
     * 
     * @param cap
     */
    public void setCap(java.lang.String cap) {
        this.cap = cap;
    }


    /**
     * Gets the frazione value for this InfoCreazioneIndirizzo.
     * 
     * @return frazione
     */
    public java.lang.String getFrazione() {
        return frazione;
    }


    /**
     * Sets the frazione value for this InfoCreazioneIndirizzo.
     * 
     * @param frazione
     */
    public void setFrazione(java.lang.String frazione) {
        this.frazione = frazione;
    }


    /**
     * Gets the regione value for this InfoCreazioneIndirizzo.
     * 
     * @return regione
     */
    public java.lang.String getRegione() {
        return regione;
    }


    /**
     * Sets the regione value for this InfoCreazioneIndirizzo.
     * 
     * @param regione
     */
    public void setRegione(java.lang.String regione) {
        this.regione = regione;
    }


    /**
     * Gets the provincia value for this InfoCreazioneIndirizzo.
     * 
     * @return provincia
     */
    public java.lang.String getProvincia() {
        return provincia;
    }


    /**
     * Sets the provincia value for this InfoCreazioneIndirizzo.
     * 
     * @param provincia
     */
    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }


    /**
     * Gets the comune value for this InfoCreazioneIndirizzo.
     * 
     * @return comune
     */
    public java.lang.String getComune() {
        return comune;
    }


    /**
     * Sets the comune value for this InfoCreazioneIndirizzo.
     * 
     * @param comune
     */
    public void setComune(java.lang.String comune) {
        this.comune = comune;
    }


    /**
     * Gets the siglaProvincia value for this InfoCreazioneIndirizzo.
     * 
     * @return siglaProvincia
     */
    public java.lang.String getSiglaProvincia() {
        return siglaProvincia;
    }


    /**
     * Sets the siglaProvincia value for this InfoCreazioneIndirizzo.
     * 
     * @param siglaProvincia
     */
    public void setSiglaProvincia(java.lang.String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }


    /**
     * Gets the stato value for this InfoCreazioneIndirizzo.
     * 
     * @return stato
     */
    public java.lang.String getStato() {
        return stato;
    }


    /**
     * Sets the stato value for this InfoCreazioneIndirizzo.
     * 
     * @param stato
     */
    public void setStato(java.lang.String stato) {
        this.stato = stato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InfoCreazioneIndirizzo)) return false;
        InfoCreazioneIndirizzo other = (InfoCreazioneIndirizzo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idTipoIndirizzo == other.getIdTipoIndirizzo() &&
            ((this.indirizzo==null && other.getIndirizzo()==null) || 
             (this.indirizzo!=null &&
              this.indirizzo.equals(other.getIndirizzo()))) &&
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
              this.stato.equals(other.getStato())));
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
        _hashCode += getIdTipoIndirizzo();
        if (getIndirizzo() != null) {
            _hashCode += getIndirizzo().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InfoCreazioneIndirizzo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "InfoCreazioneIndirizzo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTipoIndirizzo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTipoIndirizzo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indirizzo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
