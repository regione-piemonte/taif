/**
 * InfoComuniCreazioneSoggetto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class InfoComuniCreazioneSoggetto  implements java.io.Serializable {
    private java.lang.String denominazione;

    private java.lang.String cognome;

    private java.lang.String nome;

    private boolean soggettoInterno;

    private java.lang.String codice;

    private java.lang.String emailPEC;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType uuidSoggettoPadre;

    private java.lang.String chiaveEsterna;

    private boolean provenienzaInpa;

    private boolean forzareSePresentiSoggettiSimili;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idAOOSeSoggettoInterno;

    private long idTipoSoggettoAppartenenza;

    private long idTipoSoggettoOrigine;

    private java.lang.String pubblicaAmministrazione;

    private java.lang.String codiceTipoSoggetto;

    public InfoComuniCreazioneSoggetto() {
    }

    public InfoComuniCreazioneSoggetto(
           java.lang.String denominazione,
           java.lang.String cognome,
           java.lang.String nome,
           boolean soggettoInterno,
           java.lang.String codice,
           java.lang.String emailPEC,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType uuidSoggettoPadre,
           java.lang.String chiaveEsterna,
           boolean provenienzaInpa,
           boolean forzareSePresentiSoggettiSimili,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idAOOSeSoggettoInterno,
           long idTipoSoggettoAppartenenza,
           long idTipoSoggettoOrigine,
           java.lang.String pubblicaAmministrazione,
           java.lang.String codiceTipoSoggetto) {
           this.denominazione = denominazione;
           this.cognome = cognome;
           this.nome = nome;
           this.soggettoInterno = soggettoInterno;
           this.codice = codice;
           this.emailPEC = emailPEC;
           this.uuidSoggettoPadre = uuidSoggettoPadre;
           this.chiaveEsterna = chiaveEsterna;
           this.provenienzaInpa = provenienzaInpa;
           this.forzareSePresentiSoggettiSimili = forzareSePresentiSoggettiSimili;
           this.idAOOSeSoggettoInterno = idAOOSeSoggettoInterno;
           this.idTipoSoggettoAppartenenza = idTipoSoggettoAppartenenza;
           this.idTipoSoggettoOrigine = idTipoSoggettoOrigine;
           this.pubblicaAmministrazione = pubblicaAmministrazione;
           this.codiceTipoSoggetto = codiceTipoSoggetto;
    }


    /**
     * Gets the denominazione value for this InfoComuniCreazioneSoggetto.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this InfoComuniCreazioneSoggetto.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the cognome value for this InfoComuniCreazioneSoggetto.
     * 
     * @return cognome
     */
    public java.lang.String getCognome() {
        return cognome;
    }


    /**
     * Sets the cognome value for this InfoComuniCreazioneSoggetto.
     * 
     * @param cognome
     */
    public void setCognome(java.lang.String cognome) {
        this.cognome = cognome;
    }


    /**
     * Gets the nome value for this InfoComuniCreazioneSoggetto.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this InfoComuniCreazioneSoggetto.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the soggettoInterno value for this InfoComuniCreazioneSoggetto.
     * 
     * @return soggettoInterno
     */
    public boolean isSoggettoInterno() {
        return soggettoInterno;
    }


    /**
     * Sets the soggettoInterno value for this InfoComuniCreazioneSoggetto.
     * 
     * @param soggettoInterno
     */
    public void setSoggettoInterno(boolean soggettoInterno) {
        this.soggettoInterno = soggettoInterno;
    }


    /**
     * Gets the codice value for this InfoComuniCreazioneSoggetto.
     * 
     * @return codice
     */
    public java.lang.String getCodice() {
        return codice;
    }


    /**
     * Sets the codice value for this InfoComuniCreazioneSoggetto.
     * 
     * @param codice
     */
    public void setCodice(java.lang.String codice) {
        this.codice = codice;
    }


    /**
     * Gets the emailPEC value for this InfoComuniCreazioneSoggetto.
     * 
     * @return emailPEC
     */
    public java.lang.String getEmailPEC() {
        return emailPEC;
    }


    /**
     * Sets the emailPEC value for this InfoComuniCreazioneSoggetto.
     * 
     * @param emailPEC
     */
    public void setEmailPEC(java.lang.String emailPEC) {
        this.emailPEC = emailPEC;
    }


    /**
     * Gets the uuidSoggettoPadre value for this InfoComuniCreazioneSoggetto.
     * 
     * @return uuidSoggettoPadre
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getUuidSoggettoPadre() {
        return uuidSoggettoPadre;
    }


    /**
     * Sets the uuidSoggettoPadre value for this InfoComuniCreazioneSoggetto.
     * 
     * @param uuidSoggettoPadre
     */
    public void setUuidSoggettoPadre(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType uuidSoggettoPadre) {
        this.uuidSoggettoPadre = uuidSoggettoPadre;
    }


    /**
     * Gets the chiaveEsterna value for this InfoComuniCreazioneSoggetto.
     * 
     * @return chiaveEsterna
     */
    public java.lang.String getChiaveEsterna() {
        return chiaveEsterna;
    }


    /**
     * Sets the chiaveEsterna value for this InfoComuniCreazioneSoggetto.
     * 
     * @param chiaveEsterna
     */
    public void setChiaveEsterna(java.lang.String chiaveEsterna) {
        this.chiaveEsterna = chiaveEsterna;
    }


    /**
     * Gets the provenienzaInpa value for this InfoComuniCreazioneSoggetto.
     * 
     * @return provenienzaInpa
     */
    public boolean isProvenienzaInpa() {
        return provenienzaInpa;
    }


    /**
     * Sets the provenienzaInpa value for this InfoComuniCreazioneSoggetto.
     * 
     * @param provenienzaInpa
     */
    public void setProvenienzaInpa(boolean provenienzaInpa) {
        this.provenienzaInpa = provenienzaInpa;
    }


    /**
     * Gets the forzareSePresentiSoggettiSimili value for this InfoComuniCreazioneSoggetto.
     * 
     * @return forzareSePresentiSoggettiSimili
     */
    public boolean isForzareSePresentiSoggettiSimili() {
        return forzareSePresentiSoggettiSimili;
    }


    /**
     * Sets the forzareSePresentiSoggettiSimili value for this InfoComuniCreazioneSoggetto.
     * 
     * @param forzareSePresentiSoggettiSimili
     */
    public void setForzareSePresentiSoggettiSimili(boolean forzareSePresentiSoggettiSimili) {
        this.forzareSePresentiSoggettiSimili = forzareSePresentiSoggettiSimili;
    }


    /**
     * Gets the idAOOSeSoggettoInterno value for this InfoComuniCreazioneSoggetto.
     * 
     * @return idAOOSeSoggettoInterno
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdAOOSeSoggettoInterno() {
        return idAOOSeSoggettoInterno;
    }


    /**
     * Sets the idAOOSeSoggettoInterno value for this InfoComuniCreazioneSoggetto.
     * 
     * @param idAOOSeSoggettoInterno
     */
    public void setIdAOOSeSoggettoInterno(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idAOOSeSoggettoInterno) {
        this.idAOOSeSoggettoInterno = idAOOSeSoggettoInterno;
    }


    /**
     * Gets the idTipoSoggettoAppartenenza value for this InfoComuniCreazioneSoggetto.
     * 
     * @return idTipoSoggettoAppartenenza
     */
    public long getIdTipoSoggettoAppartenenza() {
        return idTipoSoggettoAppartenenza;
    }


    /**
     * Sets the idTipoSoggettoAppartenenza value for this InfoComuniCreazioneSoggetto.
     * 
     * @param idTipoSoggettoAppartenenza
     */
    public void setIdTipoSoggettoAppartenenza(long idTipoSoggettoAppartenenza) {
        this.idTipoSoggettoAppartenenza = idTipoSoggettoAppartenenza;
    }


    /**
     * Gets the idTipoSoggettoOrigine value for this InfoComuniCreazioneSoggetto.
     * 
     * @return idTipoSoggettoOrigine
     */
    public long getIdTipoSoggettoOrigine() {
        return idTipoSoggettoOrigine;
    }


    /**
     * Sets the idTipoSoggettoOrigine value for this InfoComuniCreazioneSoggetto.
     * 
     * @param idTipoSoggettoOrigine
     */
    public void setIdTipoSoggettoOrigine(long idTipoSoggettoOrigine) {
        this.idTipoSoggettoOrigine = idTipoSoggettoOrigine;
    }


    /**
     * Gets the pubblicaAmministrazione value for this InfoComuniCreazioneSoggetto.
     * 
     * @return pubblicaAmministrazione
     */
    public java.lang.String getPubblicaAmministrazione() {
        return pubblicaAmministrazione;
    }


    /**
     * Sets the pubblicaAmministrazione value for this InfoComuniCreazioneSoggetto.
     * 
     * @param pubblicaAmministrazione
     */
    public void setPubblicaAmministrazione(java.lang.String pubblicaAmministrazione) {
        this.pubblicaAmministrazione = pubblicaAmministrazione;
    }


    /**
     * Gets the codiceTipoSoggetto value for this InfoComuniCreazioneSoggetto.
     * 
     * @return codiceTipoSoggetto
     */
    public java.lang.String getCodiceTipoSoggetto() {
        return codiceTipoSoggetto;
    }


    /**
     * Sets the codiceTipoSoggetto value for this InfoComuniCreazioneSoggetto.
     * 
     * @param codiceTipoSoggetto
     */
    public void setCodiceTipoSoggetto(java.lang.String codiceTipoSoggetto) {
        this.codiceTipoSoggetto = codiceTipoSoggetto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InfoComuniCreazioneSoggetto)) return false;
        InfoComuniCreazioneSoggetto other = (InfoComuniCreazioneSoggetto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione()))) &&
            ((this.cognome==null && other.getCognome()==null) || 
             (this.cognome!=null &&
              this.cognome.equals(other.getCognome()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            this.soggettoInterno == other.isSoggettoInterno() &&
            ((this.codice==null && other.getCodice()==null) || 
             (this.codice!=null &&
              this.codice.equals(other.getCodice()))) &&
            ((this.emailPEC==null && other.getEmailPEC()==null) || 
             (this.emailPEC!=null &&
              this.emailPEC.equals(other.getEmailPEC()))) &&
            ((this.uuidSoggettoPadre==null && other.getUuidSoggettoPadre()==null) || 
             (this.uuidSoggettoPadre!=null &&
              this.uuidSoggettoPadre.equals(other.getUuidSoggettoPadre()))) &&
            ((this.chiaveEsterna==null && other.getChiaveEsterna()==null) || 
             (this.chiaveEsterna!=null &&
              this.chiaveEsterna.equals(other.getChiaveEsterna()))) &&
            this.provenienzaInpa == other.isProvenienzaInpa() &&
            this.forzareSePresentiSoggettiSimili == other.isForzareSePresentiSoggettiSimili() &&
            ((this.idAOOSeSoggettoInterno==null && other.getIdAOOSeSoggettoInterno()==null) || 
             (this.idAOOSeSoggettoInterno!=null &&
              this.idAOOSeSoggettoInterno.equals(other.getIdAOOSeSoggettoInterno()))) &&
            this.idTipoSoggettoAppartenenza == other.getIdTipoSoggettoAppartenenza() &&
            this.idTipoSoggettoOrigine == other.getIdTipoSoggettoOrigine() &&
            ((this.pubblicaAmministrazione==null && other.getPubblicaAmministrazione()==null) || 
             (this.pubblicaAmministrazione!=null &&
              this.pubblicaAmministrazione.equals(other.getPubblicaAmministrazione()))) &&
            ((this.codiceTipoSoggetto==null && other.getCodiceTipoSoggetto()==null) || 
             (this.codiceTipoSoggetto!=null &&
              this.codiceTipoSoggetto.equals(other.getCodiceTipoSoggetto())));
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
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        if (getCognome() != null) {
            _hashCode += getCognome().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        _hashCode += (isSoggettoInterno() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCodice() != null) {
            _hashCode += getCodice().hashCode();
        }
        if (getEmailPEC() != null) {
            _hashCode += getEmailPEC().hashCode();
        }
        if (getUuidSoggettoPadre() != null) {
            _hashCode += getUuidSoggettoPadre().hashCode();
        }
        if (getChiaveEsterna() != null) {
            _hashCode += getChiaveEsterna().hashCode();
        }
        _hashCode += (isProvenienzaInpa() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isForzareSePresentiSoggettiSimili() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIdAOOSeSoggettoInterno() != null) {
            _hashCode += getIdAOOSeSoggettoInterno().hashCode();
        }
        _hashCode += new Long(getIdTipoSoggettoAppartenenza()).hashCode();
        _hashCode += new Long(getIdTipoSoggettoOrigine()).hashCode();
        if (getPubblicaAmministrazione() != null) {
            _hashCode += getPubblicaAmministrazione().hashCode();
        }
        if (getCodiceTipoSoggetto() != null) {
            _hashCode += getCodiceTipoSoggetto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InfoComuniCreazioneSoggetto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "InfoComuniCreazioneSoggetto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cognome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cognome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("soggettoInterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "soggettoInterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codice"));
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
        elemField.setFieldName("uuidSoggettoPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uuidSoggettoPadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chiaveEsterna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chiaveEsterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provenienzaInpa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provenienzaInpa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forzareSePresentiSoggettiSimili");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forzareSePresentiSoggettiSimili"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAOOSeSoggettoInterno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAOOSeSoggettoInterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTipoSoggettoAppartenenza");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTipoSoggettoAppartenenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTipoSoggettoOrigine");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTipoSoggettoOrigine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pubblicaAmministrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pubblicaAmministrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceTipoSoggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceTipoSoggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
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
