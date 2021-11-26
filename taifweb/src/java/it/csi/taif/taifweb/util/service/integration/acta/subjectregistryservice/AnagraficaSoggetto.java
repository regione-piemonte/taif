/**
 * AnagraficaSoggetto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class AnagraficaSoggetto  implements java.io.Serializable {
    private java.lang.String codiceFiscale;

    private java.lang.String partitaIva;

    private java.lang.String denominazione;

    private java.lang.String tipoAnagrafica;

    private java.lang.String cognome;

    private java.lang.String nome;

    private java.lang.String sesso;

    private java.lang.String statoAnagrafico;

    private java.lang.String codiceFonte;

    private java.lang.String descrizioneFonte;

    private java.lang.String dataNascita;

    private java.lang.String luogoNascita;

    private java.lang.Boolean provvisoria;

    private IndirizzoFonteEsterna[] indirizzi;

    public AnagraficaSoggetto() {
    }

    public AnagraficaSoggetto(
           java.lang.String codiceFiscale,
           java.lang.String partitaIva,
           java.lang.String denominazione,
           java.lang.String tipoAnagrafica,
           java.lang.String cognome,
           java.lang.String nome,
           java.lang.String sesso,
           java.lang.String statoAnagrafico,
           java.lang.String codiceFonte,
           java.lang.String descrizioneFonte,
           java.lang.String dataNascita,
           java.lang.String luogoNascita,
           java.lang.Boolean provvisoria,
           IndirizzoFonteEsterna[] indirizzi) {
           this.codiceFiscale = codiceFiscale;
           this.partitaIva = partitaIva;
           this.denominazione = denominazione;
           this.tipoAnagrafica = tipoAnagrafica;
           this.cognome = cognome;
           this.nome = nome;
           this.sesso = sesso;
           this.statoAnagrafico = statoAnagrafico;
           this.codiceFonte = codiceFonte;
           this.descrizioneFonte = descrizioneFonte;
           this.dataNascita = dataNascita;
           this.luogoNascita = luogoNascita;
           this.provvisoria = provvisoria;
           this.indirizzi = indirizzi;
    }


    /**
     * Gets the codiceFiscale value for this AnagraficaSoggetto.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this AnagraficaSoggetto.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the partitaIva value for this AnagraficaSoggetto.
     * 
     * @return partitaIva
     */
    public java.lang.String getPartitaIva() {
        return partitaIva;
    }


    /**
     * Sets the partitaIva value for this AnagraficaSoggetto.
     * 
     * @param partitaIva
     */
    public void setPartitaIva(java.lang.String partitaIva) {
        this.partitaIva = partitaIva;
    }


    /**
     * Gets the denominazione value for this AnagraficaSoggetto.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this AnagraficaSoggetto.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the tipoAnagrafica value for this AnagraficaSoggetto.
     * 
     * @return tipoAnagrafica
     */
    public java.lang.String getTipoAnagrafica() {
        return tipoAnagrafica;
    }


    /**
     * Sets the tipoAnagrafica value for this AnagraficaSoggetto.
     * 
     * @param tipoAnagrafica
     */
    public void setTipoAnagrafica(java.lang.String tipoAnagrafica) {
        this.tipoAnagrafica = tipoAnagrafica;
    }


    /**
     * Gets the cognome value for this AnagraficaSoggetto.
     * 
     * @return cognome
     */
    public java.lang.String getCognome() {
        return cognome;
    }


    /**
     * Sets the cognome value for this AnagraficaSoggetto.
     * 
     * @param cognome
     */
    public void setCognome(java.lang.String cognome) {
        this.cognome = cognome;
    }


    /**
     * Gets the nome value for this AnagraficaSoggetto.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this AnagraficaSoggetto.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the sesso value for this AnagraficaSoggetto.
     * 
     * @return sesso
     */
    public java.lang.String getSesso() {
        return sesso;
    }


    /**
     * Sets the sesso value for this AnagraficaSoggetto.
     * 
     * @param sesso
     */
    public void setSesso(java.lang.String sesso) {
        this.sesso = sesso;
    }


    /**
     * Gets the statoAnagrafico value for this AnagraficaSoggetto.
     * 
     * @return statoAnagrafico
     */
    public java.lang.String getStatoAnagrafico() {
        return statoAnagrafico;
    }


    /**
     * Sets the statoAnagrafico value for this AnagraficaSoggetto.
     * 
     * @param statoAnagrafico
     */
    public void setStatoAnagrafico(java.lang.String statoAnagrafico) {
        this.statoAnagrafico = statoAnagrafico;
    }


    /**
     * Gets the codiceFonte value for this AnagraficaSoggetto.
     * 
     * @return codiceFonte
     */
    public java.lang.String getCodiceFonte() {
        return codiceFonte;
    }


    /**
     * Sets the codiceFonte value for this AnagraficaSoggetto.
     * 
     * @param codiceFonte
     */
    public void setCodiceFonte(java.lang.String codiceFonte) {
        this.codiceFonte = codiceFonte;
    }


    /**
     * Gets the descrizioneFonte value for this AnagraficaSoggetto.
     * 
     * @return descrizioneFonte
     */
    public java.lang.String getDescrizioneFonte() {
        return descrizioneFonte;
    }


    /**
     * Sets the descrizioneFonte value for this AnagraficaSoggetto.
     * 
     * @param descrizioneFonte
     */
    public void setDescrizioneFonte(java.lang.String descrizioneFonte) {
        this.descrizioneFonte = descrizioneFonte;
    }


    /**
     * Gets the dataNascita value for this AnagraficaSoggetto.
     * 
     * @return dataNascita
     */
    public java.lang.String getDataNascita() {
        return dataNascita;
    }


    /**
     * Sets the dataNascita value for this AnagraficaSoggetto.
     * 
     * @param dataNascita
     */
    public void setDataNascita(java.lang.String dataNascita) {
        this.dataNascita = dataNascita;
    }


    /**
     * Gets the luogoNascita value for this AnagraficaSoggetto.
     * 
     * @return luogoNascita
     */
    public java.lang.String getLuogoNascita() {
        return luogoNascita;
    }


    /**
     * Sets the luogoNascita value for this AnagraficaSoggetto.
     * 
     * @param luogoNascita
     */
    public void setLuogoNascita(java.lang.String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }


    /**
     * Gets the provvisoria value for this AnagraficaSoggetto.
     * 
     * @return provvisoria
     */
    public java.lang.Boolean getProvvisoria() {
        return provvisoria;
    }


    /**
     * Sets the provvisoria value for this AnagraficaSoggetto.
     * 
     * @param provvisoria
     */
    public void setProvvisoria(java.lang.Boolean provvisoria) {
        this.provvisoria = provvisoria;
    }


    /**
     * Gets the indirizzi value for this AnagraficaSoggetto.
     * 
     * @return indirizzi
     */
    public IndirizzoFonteEsterna[] getIndirizzi() {
        return indirizzi;
    }


    /**
     * Sets the indirizzi value for this AnagraficaSoggetto.
     * 
     * @param indirizzi
     */
    public void setIndirizzi(IndirizzoFonteEsterna[] indirizzi) {
        this.indirizzi = indirizzi;
    }

    public IndirizzoFonteEsterna getIndirizzi(int i) {
        return this.indirizzi[i];
    }

    public void setIndirizzi(int i, IndirizzoFonteEsterna _value) {
        this.indirizzi[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnagraficaSoggetto)) return false;
        AnagraficaSoggetto other = (AnagraficaSoggetto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) || 
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale()))) &&
            ((this.partitaIva==null && other.getPartitaIva()==null) || 
             (this.partitaIva!=null &&
              this.partitaIva.equals(other.getPartitaIva()))) &&
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione()))) &&
            ((this.tipoAnagrafica==null && other.getTipoAnagrafica()==null) || 
             (this.tipoAnagrafica!=null &&
              this.tipoAnagrafica.equals(other.getTipoAnagrafica()))) &&
            ((this.cognome==null && other.getCognome()==null) || 
             (this.cognome!=null &&
              this.cognome.equals(other.getCognome()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.sesso==null && other.getSesso()==null) || 
             (this.sesso!=null &&
              this.sesso.equals(other.getSesso()))) &&
            ((this.statoAnagrafico==null && other.getStatoAnagrafico()==null) || 
             (this.statoAnagrafico!=null &&
              this.statoAnagrafico.equals(other.getStatoAnagrafico()))) &&
            ((this.codiceFonte==null && other.getCodiceFonte()==null) || 
             (this.codiceFonte!=null &&
              this.codiceFonte.equals(other.getCodiceFonte()))) &&
            ((this.descrizioneFonte==null && other.getDescrizioneFonte()==null) || 
             (this.descrizioneFonte!=null &&
              this.descrizioneFonte.equals(other.getDescrizioneFonte()))) &&
            ((this.dataNascita==null && other.getDataNascita()==null) || 
             (this.dataNascita!=null &&
              this.dataNascita.equals(other.getDataNascita()))) &&
            ((this.luogoNascita==null && other.getLuogoNascita()==null) || 
             (this.luogoNascita!=null &&
              this.luogoNascita.equals(other.getLuogoNascita()))) &&
            ((this.provvisoria==null && other.getProvvisoria()==null) || 
             (this.provvisoria!=null &&
              this.provvisoria.equals(other.getProvvisoria()))) &&
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
        int _hashCode = 1;
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        if (getPartitaIva() != null) {
            _hashCode += getPartitaIva().hashCode();
        }
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        if (getTipoAnagrafica() != null) {
            _hashCode += getTipoAnagrafica().hashCode();
        }
        if (getCognome() != null) {
            _hashCode += getCognome().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getSesso() != null) {
            _hashCode += getSesso().hashCode();
        }
        if (getStatoAnagrafico() != null) {
            _hashCode += getStatoAnagrafico().hashCode();
        }
        if (getCodiceFonte() != null) {
            _hashCode += getCodiceFonte().hashCode();
        }
        if (getDescrizioneFonte() != null) {
            _hashCode += getDescrizioneFonte().hashCode();
        }
        if (getDataNascita() != null) {
            _hashCode += getDataNascita().hashCode();
        }
        if (getLuogoNascita() != null) {
            _hashCode += getLuogoNascita().hashCode();
        }
        if (getProvvisoria() != null) {
            _hashCode += getProvvisoria().hashCode();
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
        new org.apache.axis.description.TypeDesc(AnagraficaSoggetto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "AnagraficaSoggetto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partitaIva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partitaIva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoAnagrafica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoAnagrafica"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cognome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cognome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoAnagrafico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statoAnagrafico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFonte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFonte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneFonte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descrizioneFonte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataNascita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataNascita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("luogoNascita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "luogoNascita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provvisoria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "provvisoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indirizzi"));
        elemField.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "IndirizzoFonteEsterna"));
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
