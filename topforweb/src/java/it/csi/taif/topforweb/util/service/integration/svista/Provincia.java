/**
 * Provincia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.topforweb.util.service.integration.svista;

import java.io.Serializable;

import javax.xml.namespace.QName;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class Provincia  implements Serializable {
    private String codIstat;

    private long id;

    private Long idRegione;

    private String nome;

    private String sigla;

    public Provincia() {
    }

    public Provincia(
           String codIstat,
           long id,
           Long idRegione,
           String nome,
           String sigla) {
           this.codIstat = codIstat;
           this.id = id;
           this.idRegione = idRegione;
           this.nome = nome;
           this.sigla = sigla;
    }


    /**
     * Gets the codIstat value for this Provincia.
     * 
     * @return codIstat
     */
    public String getCodIstat() {
        return codIstat;
    }


    /**
     * Sets the codIstat value for this Provincia.
     * 
     * @param codIstat
     */
    public void setCodIstat(String codIstat) {
        this.codIstat = codIstat;
    }


    /**
     * Gets the id value for this Provincia.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Provincia.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the idRegione value for this Provincia.
     * 
     * @return idRegione
     */
    public Long getIdRegione() {
        return idRegione;
    }


    /**
     * Sets the idRegione value for this Provincia.
     * 
     * @param idRegione
     */
    public void setIdRegione(Long idRegione) {
        this.idRegione = idRegione;
    }


    /**
     * Gets the nome value for this Provincia.
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Provincia.
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Gets the sigla value for this Provincia.
     * 
     * @return sigla
     */
    public String getSigla() {
        return sigla;
    }


    /**
     * Sets the sigla value for this Provincia.
     * 
     * @param sigla
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Provincia)) return false;
        Provincia other = (Provincia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codIstat==null && other.getCodIstat()==null) || 
             (this.codIstat!=null &&
              this.codIstat.equals(other.getCodIstat()))) &&
            this.id == other.getId() &&
            ((this.idRegione==null && other.getIdRegione()==null) || 
             (this.idRegione!=null &&
              this.idRegione.equals(other.getIdRegione()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.sigla==null && other.getSigla()==null) || 
             (this.sigla!=null &&
              this.sigla.equals(other.getSigla())));
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
        if (getCodIstat() != null) {
            _hashCode += getCodIstat().hashCode();
        }
        _hashCode += new Long(getId()).hashCode();
        if (getIdRegione() != null) {
            _hashCode += getIdRegione().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getSigla() != null) {
            _hashCode += getSigla().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(Provincia.class, true);

    static {
        typeDesc.setXmlType(new QName("ente", "Provincia"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("codIstat");
        elemField.setXmlName(new QName("ente", "codIstat"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new QName("ente", "id"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("idRegione");
        elemField.setXmlName(new QName("ente", "idRegione"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new QName("ente", "nome"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("sigla");
        elemField.setXmlName(new QName("ente", "sigla"));
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
