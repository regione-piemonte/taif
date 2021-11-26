/**
 * Comune.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.topforweb.util.service.integration.svista;

import java.lang.reflect.Array;

import javax.xml.namespace.QName;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanSerializer;

import it.csi.taif.topforweb.util.builder.ToStringBuilder;

public class Comune  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7203369810941757814L;

	private Asl[] aslDiRiferimento;

    private String cap;

    private String codCatasto;

    private String codIstat;

    private long id;

    private long idProvincia;

    private String nome;

    public Comune() {
    }

    public Comune(
    	   Asl[] aslDiRiferimento,
           String cap,
           String codCatasto,
           String codIstat,
           long id,
           long idProvincia,
           String nome) {
           this.aslDiRiferimento = aslDiRiferimento;
           this.cap = cap;
           this.codCatasto = codCatasto;
           this.codIstat = codIstat;
           this.id = id;
           this.idProvincia = idProvincia;
           this.nome = nome;
    }


    /**
     * Gets the aslDiRiferimento value for this Comune.
     * 
     * @return aslDiRiferimento
     */
    public Asl[] getAslDiRiferimento() {
        return aslDiRiferimento;
    }


    /**
     * Sets the aslDiRiferimento value for this Comune.
     * 
     * @param aslDiRiferimento
     */
    public void setAslDiRiferimento(Asl[] aslDiRiferimento) {
        this.aslDiRiferimento = aslDiRiferimento;
    }


    /**
     * Gets the cap value for this Comune.
     * 
     * @return cap
     */
    public String getCap() {
        return cap;
    }


    /**
     * Sets the cap value for this Comune.
     * 
     * @param cap
     */
    public void setCap(String cap) {
        this.cap = cap;
    }


    /**
     * Gets the codCatasto value for this Comune.
     * 
     * @return codCatasto
     */
    public String getCodCatasto() {
        return codCatasto;
    }


    /**
     * Sets the codCatasto value for this Comune.
     * 
     * @param codCatasto
     */
    public void setCodCatasto(String codCatasto) {
        this.codCatasto = codCatasto;
    }


    /**
     * Gets the codIstat value for this Comune.
     * 
     * @return codIstat
     */
    public String getCodIstat() {
        return codIstat;
    }


    /**
     * Sets the codIstat value for this Comune.
     * 
     * @param codIstat
     */
    public void setCodIstat(String codIstat) {
        this.codIstat = codIstat;
    }


    /**
     * Gets the id value for this Comune.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Comune.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the idProvincia value for this Comune.
     * 
     * @return idProvincia
     */
    public long getIdProvincia() {
        return idProvincia;
    }


    /**
     * Sets the idProvincia value for this Comune.
     * 
     * @param idProvincia
     */
    public void setIdProvincia(long idProvincia) {
        this.idProvincia = idProvincia;
    }


    /**
     * Gets the nome value for this Comune.
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Comune.
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Comune)) return false;
        Comune other = (Comune) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aslDiRiferimento==null && other.getAslDiRiferimento()==null) || 
             (this.aslDiRiferimento!=null &&
              java.util.Arrays.equals(this.aslDiRiferimento, other.getAslDiRiferimento()))) &&
            ((this.cap==null && other.getCap()==null) || 
             (this.cap!=null &&
              this.cap.equals(other.getCap()))) &&
            ((this.codCatasto==null && other.getCodCatasto()==null) || 
             (this.codCatasto!=null &&
              this.codCatasto.equals(other.getCodCatasto()))) &&
            ((this.codIstat==null && other.getCodIstat()==null) || 
             (this.codIstat!=null &&
              this.codIstat.equals(other.getCodIstat()))) &&
            this.id == other.getId() &&
            this.idProvincia == other.getIdProvincia() &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome())));
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
        if (getAslDiRiferimento() != null) {
            for (int i=0;
                 i<Array.getLength(getAslDiRiferimento());
                 i++) {
                Object obj = Array.get(getAslDiRiferimento(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCap() != null) {
            _hashCode += getCap().hashCode();
        }
        if (getCodCatasto() != null) {
            _hashCode += getCodCatasto().hashCode();
        }
        if (getCodIstat() != null) {
            _hashCode += getCodIstat().hashCode();
        }
        _hashCode += new Long(getId()).hashCode();
        _hashCode += new Long(getIdProvincia()).hashCode();
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc TYPE_DESC = new TypeDesc(Comune.class, true);

    static {
        TYPE_DESC.setXmlType(new QName("ente", "Comune"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("aslDiRiferimento");
        elemField.setXmlName(new QName("ente", "aslDiRiferimento"));
        elemField.setXmlType(new QName("ente", "Asl"));
        elemField.setNillable(true);
        elemField.setItemQName(new QName("ente", "item"));
        TYPE_DESC.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("cap");
        elemField.setXmlName(new QName("ente", "cap"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        TYPE_DESC.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("codCatasto");
        elemField.setXmlName(new QName("ente", "codCatasto"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        TYPE_DESC.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("codIstat");
        elemField.setXmlName(new QName("ente", "codIstat"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        TYPE_DESC.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new QName("ente", "id"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        TYPE_DESC.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("idProvincia");
        elemField.setXmlName(new QName("ente", "idProvincia"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        TYPE_DESC.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new QName("ente", "nome"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        TYPE_DESC.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static TypeDesc getTypeDesc() {
        return TYPE_DESC;
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
            _javaType, _xmlType, TYPE_DESC);
    }

    /**
     * Get Custom Deserializer
     */
    public static Deserializer getDeserializer(
           String mechType, 
           Class _javaType,  
           QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, TYPE_DESC);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.objectToString(this);
    }

}
