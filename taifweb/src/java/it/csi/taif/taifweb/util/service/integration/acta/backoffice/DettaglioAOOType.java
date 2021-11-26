/**
 * DettaglioAOOType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.backoffice;

public class DettaglioAOOType  implements java.io.Serializable {
    private it.csi.taif.taifweb.util.service.integration.acta.common.IdAOOType idAOO;

    private java.lang.String codice;

    private java.lang.String denominazione;

    private java.lang.String indirizzo;

    private java.lang.String citta;

    private java.lang.String email;

    private java.lang.String emailPEC;

    private java.lang.String sitoWeb;

    private java.lang.String telefono;

    private java.lang.String fax;

    public DettaglioAOOType() {
    }

    public DettaglioAOOType(
           it.csi.taif.taifweb.util.service.integration.acta.common.IdAOOType idAOO,
           java.lang.String codice,
           java.lang.String denominazione,
           java.lang.String indirizzo,
           java.lang.String citta,
           java.lang.String email,
           java.lang.String emailPEC,
           java.lang.String sitoWeb,
           java.lang.String telefono,
           java.lang.String fax) {
           this.idAOO = idAOO;
           this.codice = codice;
           this.denominazione = denominazione;
           this.indirizzo = indirizzo;
           this.citta = citta;
           this.email = email;
           this.emailPEC = emailPEC;
           this.sitoWeb = sitoWeb;
           this.telefono = telefono;
           this.fax = fax;
    }


    /**
     * Gets the idAOO value for this DettaglioAOOType.
     * 
     * @return idAOO
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.IdAOOType getIdAOO() {
        return idAOO;
    }


    /**
     * Sets the idAOO value for this DettaglioAOOType.
     * 
     * @param idAOO
     */
    public void setIdAOO(it.csi.taif.taifweb.util.service.integration.acta.common.IdAOOType idAOO) {
        this.idAOO = idAOO;
    }


    /**
     * Gets the codice value for this DettaglioAOOType.
     * 
     * @return codice
     */
    public java.lang.String getCodice() {
        return codice;
    }


    /**
     * Sets the codice value for this DettaglioAOOType.
     * 
     * @param codice
     */
    public void setCodice(java.lang.String codice) {
        this.codice = codice;
    }


    /**
     * Gets the denominazione value for this DettaglioAOOType.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this DettaglioAOOType.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the indirizzo value for this DettaglioAOOType.
     * 
     * @return indirizzo
     */
    public java.lang.String getIndirizzo() {
        return indirizzo;
    }


    /**
     * Sets the indirizzo value for this DettaglioAOOType.
     * 
     * @param indirizzo
     */
    public void setIndirizzo(java.lang.String indirizzo) {
        this.indirizzo = indirizzo;
    }


    /**
     * Gets the citta value for this DettaglioAOOType.
     * 
     * @return citta
     */
    public java.lang.String getCitta() {
        return citta;
    }


    /**
     * Sets the citta value for this DettaglioAOOType.
     * 
     * @param citta
     */
    public void setCitta(java.lang.String citta) {
        this.citta = citta;
    }


    /**
     * Gets the email value for this DettaglioAOOType.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this DettaglioAOOType.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the emailPEC value for this DettaglioAOOType.
     * 
     * @return emailPEC
     */
    public java.lang.String getEmailPEC() {
        return emailPEC;
    }


    /**
     * Sets the emailPEC value for this DettaglioAOOType.
     * 
     * @param emailPEC
     */
    public void setEmailPEC(java.lang.String emailPEC) {
        this.emailPEC = emailPEC;
    }


    /**
     * Gets the sitoWeb value for this DettaglioAOOType.
     * 
     * @return sitoWeb
     */
    public java.lang.String getSitoWeb() {
        return sitoWeb;
    }


    /**
     * Sets the sitoWeb value for this DettaglioAOOType.
     * 
     * @param sitoWeb
     */
    public void setSitoWeb(java.lang.String sitoWeb) {
        this.sitoWeb = sitoWeb;
    }


    /**
     * Gets the telefono value for this DettaglioAOOType.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this DettaglioAOOType.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the fax value for this DettaglioAOOType.
     * 
     * @return fax
     */
    public java.lang.String getFax() {
        return fax;
    }


    /**
     * Sets the fax value for this DettaglioAOOType.
     * 
     * @param fax
     */
    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DettaglioAOOType)) return false;
        DettaglioAOOType other = (DettaglioAOOType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idAOO==null && other.getIdAOO()==null) || 
             (this.idAOO!=null &&
              this.idAOO.equals(other.getIdAOO()))) &&
            ((this.codice==null && other.getCodice()==null) || 
             (this.codice!=null &&
              this.codice.equals(other.getCodice()))) &&
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione()))) &&
            ((this.indirizzo==null && other.getIndirizzo()==null) || 
             (this.indirizzo!=null &&
              this.indirizzo.equals(other.getIndirizzo()))) &&
            ((this.citta==null && other.getCitta()==null) || 
             (this.citta!=null &&
              this.citta.equals(other.getCitta()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.emailPEC==null && other.getEmailPEC()==null) || 
             (this.emailPEC!=null &&
              this.emailPEC.equals(other.getEmailPEC()))) &&
            ((this.sitoWeb==null && other.getSitoWeb()==null) || 
             (this.sitoWeb!=null &&
              this.sitoWeb.equals(other.getSitoWeb()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.fax==null && other.getFax()==null) || 
             (this.fax!=null &&
              this.fax.equals(other.getFax())));
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
        if (getIdAOO() != null) {
            _hashCode += getIdAOO().hashCode();
        }
        if (getCodice() != null) {
            _hashCode += getCodice().hashCode();
        }
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        if (getIndirizzo() != null) {
            _hashCode += getIndirizzo().hashCode();
        }
        if (getCitta() != null) {
            _hashCode += getCitta().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getEmailPEC() != null) {
            _hashCode += getEmailPEC().hashCode();
        }
        if (getSitoWeb() != null) {
            _hashCode += getSitoWeb().hashCode();
        }
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getFax() != null) {
            _hashCode += getFax().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DettaglioAOOType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("backoffice.acaris.acta.doqui.it", "DettaglioAOOType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAOO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAOO"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "IdAOOType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indirizzo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "citta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailPEC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailPEC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sitoWeb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sitoWeb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fax"));
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
