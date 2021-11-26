/**
 * PersonaFisicaCR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class PersonaFisicaCR  implements java.io.Serializable {
    private java.lang.String cognome;

    private java.lang.String nome;

    private java.lang.String sesso;

    private java.lang.String dataNascita;

    public PersonaFisicaCR() {
    }

    public PersonaFisicaCR(
           java.lang.String cognome,
           java.lang.String nome,
           java.lang.String sesso,
           java.lang.String dataNascita) {
           this.cognome = cognome;
           this.nome = nome;
           this.sesso = sesso;
           this.dataNascita = dataNascita;
    }


    /**
     * Gets the cognome value for this PersonaFisicaCR.
     * 
     * @return cognome
     */
    public java.lang.String getCognome() {
        return cognome;
    }


    /**
     * Sets the cognome value for this PersonaFisicaCR.
     * 
     * @param cognome
     */
    public void setCognome(java.lang.String cognome) {
        this.cognome = cognome;
    }


    /**
     * Gets the nome value for this PersonaFisicaCR.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this PersonaFisicaCR.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the sesso value for this PersonaFisicaCR.
     * 
     * @return sesso
     */
    public java.lang.String getSesso() {
        return sesso;
    }


    /**
     * Sets the sesso value for this PersonaFisicaCR.
     * 
     * @param sesso
     */
    public void setSesso(java.lang.String sesso) {
        this.sesso = sesso;
    }


    /**
     * Gets the dataNascita value for this PersonaFisicaCR.
     * 
     * @return dataNascita
     */
    public java.lang.String getDataNascita() {
        return dataNascita;
    }


    /**
     * Sets the dataNascita value for this PersonaFisicaCR.
     * 
     * @param dataNascita
     */
    public void setDataNascita(java.lang.String dataNascita) {
        this.dataNascita = dataNascita;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PersonaFisicaCR)) return false;
        PersonaFisicaCR other = (PersonaFisicaCR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cognome==null && other.getCognome()==null) || 
             (this.cognome!=null &&
              this.cognome.equals(other.getCognome()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.sesso==null && other.getSesso()==null) || 
             (this.sesso!=null &&
              this.sesso.equals(other.getSesso()))) &&
            ((this.dataNascita==null && other.getDataNascita()==null) || 
             (this.dataNascita!=null &&
              this.dataNascita.equals(other.getDataNascita())));
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
        if (getCognome() != null) {
            _hashCode += getCognome().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getSesso() != null) {
            _hashCode += getSesso().hashCode();
        }
        if (getDataNascita() != null) {
            _hashCode += getDataNascita().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PersonaFisicaCR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "PersonaFisicaCR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("dataNascita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataNascita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
