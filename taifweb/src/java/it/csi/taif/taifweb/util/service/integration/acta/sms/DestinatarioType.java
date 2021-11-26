/**
 * DestinatarioType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.sms;

public class DestinatarioType  implements java.io.Serializable {
    private it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType utente;

    private it.csi.taif.taifweb.util.service.integration.acta.common.IdNodoType nodoOrganizzativo;

    private IdNodoSmistamentoType nodoSmistamento;

    private boolean perConoscenza;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idFascTempDest;

    public DestinatarioType() {
    }

    public DestinatarioType(
           it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType utente,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdNodoType nodoOrganizzativo,
           IdNodoSmistamentoType nodoSmistamento,
           boolean perConoscenza,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idFascTempDest) {
           this.utente = utente;
           this.nodoOrganizzativo = nodoOrganizzativo;
           this.nodoSmistamento = nodoSmistamento;
           this.perConoscenza = perConoscenza;
           this.idFascTempDest = idFascTempDest;
    }


    /**
     * Gets the utente value for this DestinatarioType.
     * 
     * @return utente
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType getUtente() {
        return utente;
    }


    /**
     * Sets the utente value for this DestinatarioType.
     * 
     * @param utente
     */
    public void setUtente(it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType utente) {
        this.utente = utente;
    }


    /**
     * Gets the nodoOrganizzativo value for this DestinatarioType.
     * 
     * @return nodoOrganizzativo
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.IdNodoType getNodoOrganizzativo() {
        return nodoOrganizzativo;
    }


    /**
     * Sets the nodoOrganizzativo value for this DestinatarioType.
     * 
     * @param nodoOrganizzativo
     */
    public void setNodoOrganizzativo(it.csi.taif.taifweb.util.service.integration.acta.common.IdNodoType nodoOrganizzativo) {
        this.nodoOrganizzativo = nodoOrganizzativo;
    }


    /**
     * Gets the nodoSmistamento value for this DestinatarioType.
     * 
     * @return nodoSmistamento
     */
    public IdNodoSmistamentoType getNodoSmistamento() {
        return nodoSmistamento;
    }


    /**
     * Sets the nodoSmistamento value for this DestinatarioType.
     * 
     * @param nodoSmistamento
     */
    public void setNodoSmistamento(IdNodoSmistamentoType nodoSmistamento) {
        this.nodoSmistamento = nodoSmistamento;
    }


    /**
     * Gets the perConoscenza value for this DestinatarioType.
     * 
     * @return perConoscenza
     */
    public boolean isPerConoscenza() {
        return perConoscenza;
    }


    /**
     * Sets the perConoscenza value for this DestinatarioType.
     * 
     * @param perConoscenza
     */
    public void setPerConoscenza(boolean perConoscenza) {
        this.perConoscenza = perConoscenza;
    }


    /**
     * Gets the idFascTempDest value for this DestinatarioType.
     * 
     * @return idFascTempDest
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdFascTempDest() {
        return idFascTempDest;
    }


    /**
     * Sets the idFascTempDest value for this DestinatarioType.
     * 
     * @param idFascTempDest
     */
    public void setIdFascTempDest(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idFascTempDest) {
        this.idFascTempDest = idFascTempDest;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DestinatarioType)) return false;
        DestinatarioType other = (DestinatarioType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.utente==null && other.getUtente()==null) || 
             (this.utente!=null &&
              this.utente.equals(other.getUtente()))) &&
            ((this.nodoOrganizzativo==null && other.getNodoOrganizzativo()==null) || 
             (this.nodoOrganizzativo!=null &&
              this.nodoOrganizzativo.equals(other.getNodoOrganizzativo()))) &&
            ((this.nodoSmistamento==null && other.getNodoSmistamento()==null) || 
             (this.nodoSmistamento!=null &&
              this.nodoSmistamento.equals(other.getNodoSmistamento()))) &&
            this.perConoscenza == other.isPerConoscenza() &&
            ((this.idFascTempDest==null && other.getIdFascTempDest()==null) || 
             (this.idFascTempDest!=null &&
              this.idFascTempDest.equals(other.getIdFascTempDest())));
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
        if (getUtente() != null) {
            _hashCode += getUtente().hashCode();
        }
        if (getNodoOrganizzativo() != null) {
            _hashCode += getNodoOrganizzativo().hashCode();
        }
        if (getNodoSmistamento() != null) {
            _hashCode += getNodoSmistamento().hashCode();
        }
        _hashCode += (isPerConoscenza() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIdFascTempDest() != null) {
            _hashCode += getIdFascTempDest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DestinatarioType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("sms.acaris.acta.doqui.it", "DestinatarioType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("utente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "utente"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "IdUtenteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nodoOrganizzativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nodoOrganizzativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "IdNodoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nodoSmistamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nodoSmistamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("sms.acaris.acta.doqui.it", "IdNodoSmistamentoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perConoscenza");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perConoscenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFascTempDest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFascTempDest"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
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
