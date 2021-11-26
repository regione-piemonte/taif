/**
 * InfoCreazioneCorrispondente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.officialbookservice;

public class InfoCreazioneCorrispondente  implements java.io.Serializable {
    private java.lang.String denominazione;

    private java.lang.String nome;

    private java.lang.String cognome;

    private java.lang.Integer ordinale;

    private java.lang.String carica;

    private java.lang.String persona;

    private java.lang.String testoFoglioTrasmissione;

    private InfoSoggettoAssociato infoSoggettoAssociato;

    public InfoCreazioneCorrispondente() {
    }

    public InfoCreazioneCorrispondente(
           java.lang.String denominazione,
           java.lang.String nome,
           java.lang.String cognome,
           java.lang.Integer ordinale,
           java.lang.String carica,
           java.lang.String persona,
           java.lang.String testoFoglioTrasmissione,
           InfoSoggettoAssociato infoSoggettoAssociato) {
           this.denominazione = denominazione;
           this.nome = nome;
           this.cognome = cognome;
           this.ordinale = ordinale;
           this.carica = carica;
           this.persona = persona;
           this.testoFoglioTrasmissione = testoFoglioTrasmissione;
           this.infoSoggettoAssociato = infoSoggettoAssociato;
    }


    /**
     * Gets the denominazione value for this InfoCreazioneCorrispondente.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this InfoCreazioneCorrispondente.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the nome value for this InfoCreazioneCorrispondente.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this InfoCreazioneCorrispondente.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the cognome value for this InfoCreazioneCorrispondente.
     * 
     * @return cognome
     */
    public java.lang.String getCognome() {
        return cognome;
    }


    /**
     * Sets the cognome value for this InfoCreazioneCorrispondente.
     * 
     * @param cognome
     */
    public void setCognome(java.lang.String cognome) {
        this.cognome = cognome;
    }


    /**
     * Gets the ordinale value for this InfoCreazioneCorrispondente.
     * 
     * @return ordinale
     */
    public java.lang.Integer getOrdinale() {
        return ordinale;
    }


    /**
     * Sets the ordinale value for this InfoCreazioneCorrispondente.
     * 
     * @param ordinale
     */
    public void setOrdinale(java.lang.Integer ordinale) {
        this.ordinale = ordinale;
    }


    /**
     * Gets the carica value for this InfoCreazioneCorrispondente.
     * 
     * @return carica
     */
    public java.lang.String getCarica() {
        return carica;
    }


    /**
     * Sets the carica value for this InfoCreazioneCorrispondente.
     * 
     * @param carica
     */
    public void setCarica(java.lang.String carica) {
        this.carica = carica;
    }


    /**
     * Gets the persona value for this InfoCreazioneCorrispondente.
     * 
     * @return persona
     */
    public java.lang.String getPersona() {
        return persona;
    }


    /**
     * Sets the persona value for this InfoCreazioneCorrispondente.
     * 
     * @param persona
     */
    public void setPersona(java.lang.String persona) {
        this.persona = persona;
    }


    /**
     * Gets the testoFoglioTrasmissione value for this InfoCreazioneCorrispondente.
     * 
     * @return testoFoglioTrasmissione
     */
    public java.lang.String getTestoFoglioTrasmissione() {
        return testoFoglioTrasmissione;
    }


    /**
     * Sets the testoFoglioTrasmissione value for this InfoCreazioneCorrispondente.
     * 
     * @param testoFoglioTrasmissione
     */
    public void setTestoFoglioTrasmissione(java.lang.String testoFoglioTrasmissione) {
        this.testoFoglioTrasmissione = testoFoglioTrasmissione;
    }


    /**
     * Gets the infoSoggettoAssociato value for this InfoCreazioneCorrispondente.
     * 
     * @return infoSoggettoAssociato
     */
    public InfoSoggettoAssociato getInfoSoggettoAssociato() {
        return infoSoggettoAssociato;
    }


    /**
     * Sets the infoSoggettoAssociato value for this InfoCreazioneCorrispondente.
     * 
     * @param infoSoggettoAssociato
     */
    public void setInfoSoggettoAssociato(InfoSoggettoAssociato infoSoggettoAssociato) {
        this.infoSoggettoAssociato = infoSoggettoAssociato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InfoCreazioneCorrispondente)) return false;
        InfoCreazioneCorrispondente other = (InfoCreazioneCorrispondente) obj;
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
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.cognome==null && other.getCognome()==null) || 
             (this.cognome!=null &&
              this.cognome.equals(other.getCognome()))) &&
            ((this.ordinale==null && other.getOrdinale()==null) || 
             (this.ordinale!=null &&
              this.ordinale.equals(other.getOrdinale()))) &&
            ((this.carica==null && other.getCarica()==null) || 
             (this.carica!=null &&
              this.carica.equals(other.getCarica()))) &&
            ((this.persona==null && other.getPersona()==null) || 
             (this.persona!=null &&
              this.persona.equals(other.getPersona()))) &&
            ((this.testoFoglioTrasmissione==null && other.getTestoFoglioTrasmissione()==null) || 
             (this.testoFoglioTrasmissione!=null &&
              this.testoFoglioTrasmissione.equals(other.getTestoFoglioTrasmissione()))) &&
            ((this.infoSoggettoAssociato==null && other.getInfoSoggettoAssociato()==null) || 
             (this.infoSoggettoAssociato!=null &&
              this.infoSoggettoAssociato.equals(other.getInfoSoggettoAssociato())));
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
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getCognome() != null) {
            _hashCode += getCognome().hashCode();
        }
        if (getOrdinale() != null) {
            _hashCode += getOrdinale().hashCode();
        }
        if (getCarica() != null) {
            _hashCode += getCarica().hashCode();
        }
        if (getPersona() != null) {
            _hashCode += getPersona().hashCode();
        }
        if (getTestoFoglioTrasmissione() != null) {
            _hashCode += getTestoFoglioTrasmissione().hashCode();
        }
        if (getInfoSoggettoAssociato() != null) {
            _hashCode += getInfoSoggettoAssociato().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InfoCreazioneCorrispondente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoCreazioneCorrispondente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denominazione"));
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
        elemField.setFieldName("cognome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cognome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordinale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordinale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("persona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "persona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testoFoglioTrasmissione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "testoFoglioTrasmissione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoSoggettoAssociato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "infoSoggettoAssociato"));
        elemField.setXmlType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoSoggettoAssociato"));
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
