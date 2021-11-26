/**
 * CriteriRicercaSoggetto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class CriteriRicercaSoggetto  implements java.io.Serializable {
    private java.lang.String tipoAnagrafica;

    private java.lang.String codiceFonteEsterna;

    private PersonaGiuridicaCR personaGiuridicaCR;

    private PersonaFisicaCR personaFisicaCR;

    private CodiceFiscalePartitaIvaCR codiceFiscalePartitaIva;

    public CriteriRicercaSoggetto() {
    }

    public CriteriRicercaSoggetto(
           java.lang.String tipoAnagrafica,
           java.lang.String codiceFonteEsterna,
           PersonaGiuridicaCR personaGiuridicaCR,
           PersonaFisicaCR personaFisicaCR,
           CodiceFiscalePartitaIvaCR codiceFiscalePartitaIva) {
           this.tipoAnagrafica = tipoAnagrafica;
           this.codiceFonteEsterna = codiceFonteEsterna;
           this.personaGiuridicaCR = personaGiuridicaCR;
           this.personaFisicaCR = personaFisicaCR;
           this.codiceFiscalePartitaIva = codiceFiscalePartitaIva;
    }


    /**
     * Gets the tipoAnagrafica value for this CriteriRicercaSoggetto.
     * 
     * @return tipoAnagrafica
     */
    public java.lang.String getTipoAnagrafica() {
        return tipoAnagrafica;
    }


    /**
     * Sets the tipoAnagrafica value for this CriteriRicercaSoggetto.
     * 
     * @param tipoAnagrafica
     */
    public void setTipoAnagrafica(java.lang.String tipoAnagrafica) {
        this.tipoAnagrafica = tipoAnagrafica;
    }


    /**
     * Gets the codiceFonteEsterna value for this CriteriRicercaSoggetto.
     * 
     * @return codiceFonteEsterna
     */
    public java.lang.String getCodiceFonteEsterna() {
        return codiceFonteEsterna;
    }


    /**
     * Sets the codiceFonteEsterna value for this CriteriRicercaSoggetto.
     * 
     * @param codiceFonteEsterna
     */
    public void setCodiceFonteEsterna(java.lang.String codiceFonteEsterna) {
        this.codiceFonteEsterna = codiceFonteEsterna;
    }


    /**
     * Gets the personaGiuridicaCR value for this CriteriRicercaSoggetto.
     * 
     * @return personaGiuridicaCR
     */
    public PersonaGiuridicaCR getPersonaGiuridicaCR() {
        return personaGiuridicaCR;
    }


    /**
     * Sets the personaGiuridicaCR value for this CriteriRicercaSoggetto.
     * 
     * @param personaGiuridicaCR
     */
    public void setPersonaGiuridicaCR(PersonaGiuridicaCR personaGiuridicaCR) {
        this.personaGiuridicaCR = personaGiuridicaCR;
    }


    /**
     * Gets the personaFisicaCR value for this CriteriRicercaSoggetto.
     * 
     * @return personaFisicaCR
     */
    public PersonaFisicaCR getPersonaFisicaCR() {
        return personaFisicaCR;
    }


    /**
     * Sets the personaFisicaCR value for this CriteriRicercaSoggetto.
     * 
     * @param personaFisicaCR
     */
    public void setPersonaFisicaCR(PersonaFisicaCR personaFisicaCR) {
        this.personaFisicaCR = personaFisicaCR;
    }


    /**
     * Gets the codiceFiscalePartitaIva value for this CriteriRicercaSoggetto.
     * 
     * @return codiceFiscalePartitaIva
     */
    public CodiceFiscalePartitaIvaCR getCodiceFiscalePartitaIva() {
        return codiceFiscalePartitaIva;
    }


    /**
     * Sets the codiceFiscalePartitaIva value for this CriteriRicercaSoggetto.
     * 
     * @param codiceFiscalePartitaIva
     */
    public void setCodiceFiscalePartitaIva(CodiceFiscalePartitaIvaCR codiceFiscalePartitaIva) {
        this.codiceFiscalePartitaIva = codiceFiscalePartitaIva;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CriteriRicercaSoggetto)) return false;
        CriteriRicercaSoggetto other = (CriteriRicercaSoggetto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipoAnagrafica==null && other.getTipoAnagrafica()==null) || 
             (this.tipoAnagrafica!=null &&
              this.tipoAnagrafica.equals(other.getTipoAnagrafica()))) &&
            ((this.codiceFonteEsterna==null && other.getCodiceFonteEsterna()==null) || 
             (this.codiceFonteEsterna!=null &&
              this.codiceFonteEsterna.equals(other.getCodiceFonteEsterna()))) &&
            ((this.personaGiuridicaCR==null && other.getPersonaGiuridicaCR()==null) || 
             (this.personaGiuridicaCR!=null &&
              this.personaGiuridicaCR.equals(other.getPersonaGiuridicaCR()))) &&
            ((this.personaFisicaCR==null && other.getPersonaFisicaCR()==null) || 
             (this.personaFisicaCR!=null &&
              this.personaFisicaCR.equals(other.getPersonaFisicaCR()))) &&
            ((this.codiceFiscalePartitaIva==null && other.getCodiceFiscalePartitaIva()==null) || 
             (this.codiceFiscalePartitaIva!=null &&
              this.codiceFiscalePartitaIva.equals(other.getCodiceFiscalePartitaIva())));
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
        if (getTipoAnagrafica() != null) {
            _hashCode += getTipoAnagrafica().hashCode();
        }
        if (getCodiceFonteEsterna() != null) {
            _hashCode += getCodiceFonteEsterna().hashCode();
        }
        if (getPersonaGiuridicaCR() != null) {
            _hashCode += getPersonaGiuridicaCR().hashCode();
        }
        if (getPersonaFisicaCR() != null) {
            _hashCode += getPersonaFisicaCR().hashCode();
        }
        if (getCodiceFiscalePartitaIva() != null) {
            _hashCode += getCodiceFiscalePartitaIva().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CriteriRicercaSoggetto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "CriteriRicercaSoggetto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoAnagrafica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoAnagrafica"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFonteEsterna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFonteEsterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personaGiuridicaCR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "personaGiuridicaCR"));
        elemField.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "PersonaGiuridicaCR"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personaFisicaCR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "personaFisicaCR"));
        elemField.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "PersonaFisicaCR"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscalePartitaIva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFiscalePartitaIva"));
        elemField.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "CodiceFiscalePartitaIvaCR"));
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
