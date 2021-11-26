/**
 * SoggettoDefinitivo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class SoggettoDefinitivo  extends SoggettoRequest  implements java.io.Serializable {
    private java.util.Date dataFineValidita;

    private boolean preferito;

    private java.lang.String codiceFiscale;

    private java.lang.String partitaIva;

    private java.lang.String email;

    private java.lang.String matricola;

    private java.util.Date dataNascita;

    private java.lang.String luogoNascita;

    private java.lang.String note;

    private InfoComuniCreazioneSoggetto infoComuniCreazioneSoggetto;

    private CategoriaAnagraficaPropertiesType[] categorieAnagrafiche;

    private Numero[] numeri;

    private InfoCreazioneIndirizzo[] indirizzi;

    public SoggettoDefinitivo() {
    }

    public SoggettoDefinitivo(
           java.util.Date dataFineValidita,
           boolean preferito,
           java.lang.String codiceFiscale,
           java.lang.String partitaIva,
           java.lang.String email,
           java.lang.String matricola,
           java.util.Date dataNascita,
           java.lang.String luogoNascita,
           java.lang.String note,
           InfoComuniCreazioneSoggetto infoComuniCreazioneSoggetto,
           CategoriaAnagraficaPropertiesType[] categorieAnagrafiche,
           Numero[] numeri,
           InfoCreazioneIndirizzo[] indirizzi) {
        this.dataFineValidita = dataFineValidita;
        this.preferito = preferito;
        this.codiceFiscale = codiceFiscale;
        this.partitaIva = partitaIva;
        this.email = email;
        this.matricola = matricola;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.note = note;
        this.infoComuniCreazioneSoggetto = infoComuniCreazioneSoggetto;
        this.categorieAnagrafiche = categorieAnagrafiche;
        this.numeri = numeri;
        this.indirizzi = indirizzi;
    }


    /**
     * Gets the dataFineValidita value for this SoggettoDefinitivo.
     * 
     * @return dataFineValidita
     */
    public java.util.Date getDataFineValidita() {
        return dataFineValidita;
    }


    /**
     * Sets the dataFineValidita value for this SoggettoDefinitivo.
     * 
     * @param dataFineValidita
     */
    public void setDataFineValidita(java.util.Date dataFineValidita) {
        this.dataFineValidita = dataFineValidita;
    }


    /**
     * Gets the preferito value for this SoggettoDefinitivo.
     * 
     * @return preferito
     */
    public boolean isPreferito() {
        return preferito;
    }


    /**
     * Sets the preferito value for this SoggettoDefinitivo.
     * 
     * @param preferito
     */
    public void setPreferito(boolean preferito) {
        this.preferito = preferito;
    }


    /**
     * Gets the codiceFiscale value for this SoggettoDefinitivo.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this SoggettoDefinitivo.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the partitaIva value for this SoggettoDefinitivo.
     * 
     * @return partitaIva
     */
    public java.lang.String getPartitaIva() {
        return partitaIva;
    }


    /**
     * Sets the partitaIva value for this SoggettoDefinitivo.
     * 
     * @param partitaIva
     */
    public void setPartitaIva(java.lang.String partitaIva) {
        this.partitaIva = partitaIva;
    }


    /**
     * Gets the email value for this SoggettoDefinitivo.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this SoggettoDefinitivo.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the matricola value for this SoggettoDefinitivo.
     * 
     * @return matricola
     */
    public java.lang.String getMatricola() {
        return matricola;
    }


    /**
     * Sets the matricola value for this SoggettoDefinitivo.
     * 
     * @param matricola
     */
    public void setMatricola(java.lang.String matricola) {
        this.matricola = matricola;
    }


    /**
     * Gets the dataNascita value for this SoggettoDefinitivo.
     * 
     * @return dataNascita
     */
    public java.util.Date getDataNascita() {
        return dataNascita;
    }


    /**
     * Sets the dataNascita value for this SoggettoDefinitivo.
     * 
     * @param dataNascita
     */
    public void setDataNascita(java.util.Date dataNascita) {
        this.dataNascita = dataNascita;
    }


    /**
     * Gets the luogoNascita value for this SoggettoDefinitivo.
     * 
     * @return luogoNascita
     */
    public java.lang.String getLuogoNascita() {
        return luogoNascita;
    }


    /**
     * Sets the luogoNascita value for this SoggettoDefinitivo.
     * 
     * @param luogoNascita
     */
    public void setLuogoNascita(java.lang.String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }


    /**
     * Gets the note value for this SoggettoDefinitivo.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this SoggettoDefinitivo.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the infoComuniCreazioneSoggetto value for this SoggettoDefinitivo.
     * 
     * @return infoComuniCreazioneSoggetto
     */
    public InfoComuniCreazioneSoggetto getInfoComuniCreazioneSoggetto() {
        return infoComuniCreazioneSoggetto;
    }


    /**
     * Sets the infoComuniCreazioneSoggetto value for this SoggettoDefinitivo.
     * 
     * @param infoComuniCreazioneSoggetto
     */
    public void setInfoComuniCreazioneSoggetto(InfoComuniCreazioneSoggetto infoComuniCreazioneSoggetto) {
        this.infoComuniCreazioneSoggetto = infoComuniCreazioneSoggetto;
    }


    /**
     * Gets the categorieAnagrafiche value for this SoggettoDefinitivo.
     * 
     * @return categorieAnagrafiche
     */
    public CategoriaAnagraficaPropertiesType[] getCategorieAnagrafiche() {
        return categorieAnagrafiche;
    }


    /**
     * Sets the categorieAnagrafiche value for this SoggettoDefinitivo.
     * 
     * @param categorieAnagrafiche
     */
    public void setCategorieAnagrafiche(CategoriaAnagraficaPropertiesType[] categorieAnagrafiche) {
        this.categorieAnagrafiche = categorieAnagrafiche;
    }

    public CategoriaAnagraficaPropertiesType getCategorieAnagrafiche(int i) {
        return this.categorieAnagrafiche[i];
    }

    public void setCategorieAnagrafiche(int i, CategoriaAnagraficaPropertiesType _value) {
        this.categorieAnagrafiche[i] = _value;
    }


    /**
     * Gets the numeri value for this SoggettoDefinitivo.
     * 
     * @return numeri
     */
    public Numero[] getNumeri() {
        return numeri;
    }


    /**
     * Sets the numeri value for this SoggettoDefinitivo.
     * 
     * @param numeri
     */
    public void setNumeri(Numero[] numeri) {
        this.numeri = numeri;
    }

    public Numero getNumeri(int i) {
        return this.numeri[i];
    }

    public void setNumeri(int i, Numero _value) {
        this.numeri[i] = _value;
    }


    /**
     * Gets the indirizzi value for this SoggettoDefinitivo.
     * 
     * @return indirizzi
     */
    public InfoCreazioneIndirizzo[] getIndirizzi() {
        return indirizzi;
    }


    /**
     * Sets the indirizzi value for this SoggettoDefinitivo.
     * 
     * @param indirizzi
     */
    public void setIndirizzi(InfoCreazioneIndirizzo[] indirizzi) {
        this.indirizzi = indirizzi;
    }

    public InfoCreazioneIndirizzo getIndirizzi(int i) {
        return this.indirizzi[i];
    }

    public void setIndirizzi(int i, InfoCreazioneIndirizzo _value) {
        this.indirizzi[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoggettoDefinitivo)) return false;
        SoggettoDefinitivo other = (SoggettoDefinitivo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dataFineValidita==null && other.getDataFineValidita()==null) || 
             (this.dataFineValidita!=null &&
              this.dataFineValidita.equals(other.getDataFineValidita()))) &&
            this.preferito == other.isPreferito() &&
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) || 
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale()))) &&
            ((this.partitaIva==null && other.getPartitaIva()==null) || 
             (this.partitaIva!=null &&
              this.partitaIva.equals(other.getPartitaIva()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.matricola==null && other.getMatricola()==null) || 
             (this.matricola!=null &&
              this.matricola.equals(other.getMatricola()))) &&
            ((this.dataNascita==null && other.getDataNascita()==null) || 
             (this.dataNascita!=null &&
              this.dataNascita.equals(other.getDataNascita()))) &&
            ((this.luogoNascita==null && other.getLuogoNascita()==null) || 
             (this.luogoNascita!=null &&
              this.luogoNascita.equals(other.getLuogoNascita()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.infoComuniCreazioneSoggetto==null && other.getInfoComuniCreazioneSoggetto()==null) || 
             (this.infoComuniCreazioneSoggetto!=null &&
              this.infoComuniCreazioneSoggetto.equals(other.getInfoComuniCreazioneSoggetto()))) &&
            ((this.categorieAnagrafiche==null && other.getCategorieAnagrafiche()==null) || 
             (this.categorieAnagrafiche!=null &&
              java.util.Arrays.equals(this.categorieAnagrafiche, other.getCategorieAnagrafiche()))) &&
            ((this.numeri==null && other.getNumeri()==null) || 
             (this.numeri!=null &&
              java.util.Arrays.equals(this.numeri, other.getNumeri()))) &&
            ((this.indirizzi==null && other.getIndirizzi()==null) || 
             (this.indirizzi!=null &&
              java.util.Arrays.equals(this.indirizzi, other.getIndirizzi())));
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
        if (getDataFineValidita() != null) {
            _hashCode += getDataFineValidita().hashCode();
        }
        _hashCode += (isPreferito() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        if (getPartitaIva() != null) {
            _hashCode += getPartitaIva().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getMatricola() != null) {
            _hashCode += getMatricola().hashCode();
        }
        if (getDataNascita() != null) {
            _hashCode += getDataNascita().hashCode();
        }
        if (getLuogoNascita() != null) {
            _hashCode += getLuogoNascita().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getInfoComuniCreazioneSoggetto() != null) {
            _hashCode += getInfoComuniCreazioneSoggetto().hashCode();
        }
        if (getCategorieAnagrafiche() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategorieAnagrafiche());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategorieAnagrafiche(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNumeri() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNumeri());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNumeri(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIndirizzi() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIndirizzi());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIndirizzi(), i);
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
        new org.apache.axis.description.TypeDesc(SoggettoDefinitivo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "SoggettoDefinitivo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFineValidita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataFineValidita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preferito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preferito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partitaIva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partitaIva"));
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
        elemField.setFieldName("matricola");
        elemField.setXmlName(new javax.xml.namespace.QName("", "matricola"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataNascita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataNascita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("luogoNascita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "luogoNascita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("", "note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoComuniCreazioneSoggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "infoComuniCreazioneSoggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "InfoComuniCreazioneSoggetto"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categorieAnagrafiche");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categorieAnagrafiche"));
        elemField.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "CategoriaAnagraficaPropertiesType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeri");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeri"));
        elemField.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "Numero"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indirizzi"));
        elemField.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "InfoCreazioneIndirizzo"));
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
