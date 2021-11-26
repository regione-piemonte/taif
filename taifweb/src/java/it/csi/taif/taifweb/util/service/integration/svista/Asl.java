/**
 * Asl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.svista;

import javax.xml.namespace.QName;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class Asl  implements java.io.Serializable {
	
    private String codAsl;

    private String nome;

    private String nomeBreve;

    public Asl() {}

    public Asl(String codAsl, String nome, String nomeBreve) {
           this.codAsl = codAsl;
           this.nome = nome;
           this.nomeBreve = nomeBreve;
    }


    /**
     * Gets the codAsl value for this Asl.
     * 
     * @return codAsl
     */
    public String getCodAsl() {
        return codAsl;
    }


    /**
     * Sets the codAsl value for this Asl.
     * 
     * @param codAsl
     */
    public void setCodAsl(String codAsl) {
        this.codAsl = codAsl;
    }


    /**
     * Gets the nome value for this Asl.
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Asl.
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Gets the nomeBreve value for this Asl.
     * 
     * @return nomeBreve
     */
    public String getNomeBreve() {
        return nomeBreve;
    }


    /**
     * Sets the nomeBreve value for this Asl.
     * 
     * @param nomeBreve
     */
    public void setNomeBreve(String nomeBreve) {
        this.nomeBreve = nomeBreve;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Asl)) return false;
        Asl other = (Asl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codAsl==null && other.getCodAsl()==null) || 
             (this.codAsl!=null &&
              this.codAsl.equals(other.getCodAsl()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.nomeBreve==null && other.getNomeBreve()==null) || 
             (this.nomeBreve!=null &&
              this.nomeBreve.equals(other.getNomeBreve())));
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
        if (getCodAsl() != null) {
            _hashCode += getCodAsl().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getNomeBreve() != null) {
            _hashCode += getNomeBreve().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(Asl.class, true);

    static {
        typeDesc.setXmlType(new QName("ente", "Asl"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("codAsl");
        elemField.setXmlName(new QName("ente", "codAsl"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new QName("ente", "nome"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nomeBreve");
        elemField.setXmlName(new QName("ente", "nomeBreve"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static Serializer getSerializer(
           String mechType, 
           Class _javaType,  
           QName _xmlType) {
        return 
          new  BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static Deserializer getDeserializer(
           String mechType, 
           Class _javaType,  
           QName _xmlType) {
        return 
          new  BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
