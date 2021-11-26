/**
 * InfoRichiestaTrasformazione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

public class InfoRichiestaTrasformazione  implements java.io.Serializable {
    private int tipoDocFisicoId;

    private int composizioneId;

    private boolean multiplo;

    private boolean diventaElettronico;

    private int statoDiEfficaciaId;

    private boolean rimandareOperazioneSbustamento;

    public InfoRichiestaTrasformazione() {
    }

    public InfoRichiestaTrasformazione(
           int tipoDocFisicoId,
           int composizioneId,
           boolean multiplo,
           boolean diventaElettronico,
           int statoDiEfficaciaId,
           boolean rimandareOperazioneSbustamento) {
           this.tipoDocFisicoId = tipoDocFisicoId;
           this.composizioneId = composizioneId;
           this.multiplo = multiplo;
           this.diventaElettronico = diventaElettronico;
           this.statoDiEfficaciaId = statoDiEfficaciaId;
           this.rimandareOperazioneSbustamento = rimandareOperazioneSbustamento;
    }


    /**
     * Gets the tipoDocFisicoId value for this InfoRichiestaTrasformazione.
     * 
     * @return tipoDocFisicoId
     */
    public int getTipoDocFisicoId() {
        return tipoDocFisicoId;
    }


    /**
     * Sets the tipoDocFisicoId value for this InfoRichiestaTrasformazione.
     * 
     * @param tipoDocFisicoId
     */
    public void setTipoDocFisicoId(int tipoDocFisicoId) {
        this.tipoDocFisicoId = tipoDocFisicoId;
    }


    /**
     * Gets the composizioneId value for this InfoRichiestaTrasformazione.
     * 
     * @return composizioneId
     */
    public int getComposizioneId() {
        return composizioneId;
    }


    /**
     * Sets the composizioneId value for this InfoRichiestaTrasformazione.
     * 
     * @param composizioneId
     */
    public void setComposizioneId(int composizioneId) {
        this.composizioneId = composizioneId;
    }


    /**
     * Gets the multiplo value for this InfoRichiestaTrasformazione.
     * 
     * @return multiplo
     */
    public boolean isMultiplo() {
        return multiplo;
    }


    /**
     * Sets the multiplo value for this InfoRichiestaTrasformazione.
     * 
     * @param multiplo
     */
    public void setMultiplo(boolean multiplo) {
        this.multiplo = multiplo;
    }


    /**
     * Gets the diventaElettronico value for this InfoRichiestaTrasformazione.
     * 
     * @return diventaElettronico
     */
    public boolean isDiventaElettronico() {
        return diventaElettronico;
    }


    /**
     * Sets the diventaElettronico value for this InfoRichiestaTrasformazione.
     * 
     * @param diventaElettronico
     */
    public void setDiventaElettronico(boolean diventaElettronico) {
        this.diventaElettronico = diventaElettronico;
    }


    /**
     * Gets the statoDiEfficaciaId value for this InfoRichiestaTrasformazione.
     * 
     * @return statoDiEfficaciaId
     */
    public int getStatoDiEfficaciaId() {
        return statoDiEfficaciaId;
    }


    /**
     * Sets the statoDiEfficaciaId value for this InfoRichiestaTrasformazione.
     * 
     * @param statoDiEfficaciaId
     */
    public void setStatoDiEfficaciaId(int statoDiEfficaciaId) {
        this.statoDiEfficaciaId = statoDiEfficaciaId;
    }


    /**
     * Gets the rimandareOperazioneSbustamento value for this InfoRichiestaTrasformazione.
     * 
     * @return rimandareOperazioneSbustamento
     */
    public boolean isRimandareOperazioneSbustamento() {
        return rimandareOperazioneSbustamento;
    }


    /**
     * Sets the rimandareOperazioneSbustamento value for this InfoRichiestaTrasformazione.
     * 
     * @param rimandareOperazioneSbustamento
     */
    public void setRimandareOperazioneSbustamento(boolean rimandareOperazioneSbustamento) {
        this.rimandareOperazioneSbustamento = rimandareOperazioneSbustamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InfoRichiestaTrasformazione)) return false;
        InfoRichiestaTrasformazione other = (InfoRichiestaTrasformazione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.tipoDocFisicoId == other.getTipoDocFisicoId() &&
            this.composizioneId == other.getComposizioneId() &&
            this.multiplo == other.isMultiplo() &&
            this.diventaElettronico == other.isDiventaElettronico() &&
            this.statoDiEfficaciaId == other.getStatoDiEfficaciaId() &&
            this.rimandareOperazioneSbustamento == other.isRimandareOperazioneSbustamento();
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
        _hashCode += getTipoDocFisicoId();
        _hashCode += getComposizioneId();
        _hashCode += (isMultiplo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDiventaElettronico() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getStatoDiEfficaciaId();
        _hashCode += (isRimandareOperazioneSbustamento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InfoRichiestaTrasformazione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "InfoRichiestaTrasformazione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDocFisicoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoDocFisicoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("composizioneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "composizioneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("multiplo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "multiplo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diventaElettronico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diventaElettronico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoDiEfficaciaId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statoDiEfficaciaId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rimandareOperazioneSbustamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rimandareOperazioneSbustamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
