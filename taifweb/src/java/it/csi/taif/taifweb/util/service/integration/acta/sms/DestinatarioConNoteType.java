/**
 * DestinatarioConNoteType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.sms;

public class DestinatarioConNoteType  extends DestinatarioType  implements java.io.Serializable {
    private java.lang.String note;

    private java.util.Date dataAggiornamento;

    public DestinatarioConNoteType() {
    }

    public DestinatarioConNoteType(
           it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType utente,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdNodoType nodoOrganizzativo,
           IdNodoSmistamentoType nodoSmistamento,
           boolean perConoscenza,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idFascTempDest,
           java.lang.String note,
           java.util.Date dataAggiornamento) {
        super(
            utente,
            nodoOrganizzativo,
            nodoSmistamento,
            perConoscenza,
            idFascTempDest);
        this.note = note;
        this.dataAggiornamento = dataAggiornamento;
    }


    /**
     * Gets the note value for this DestinatarioConNoteType.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this DestinatarioConNoteType.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the dataAggiornamento value for this DestinatarioConNoteType.
     * 
     * @return dataAggiornamento
     */
    public java.util.Date getDataAggiornamento() {
        return dataAggiornamento;
    }


    /**
     * Sets the dataAggiornamento value for this DestinatarioConNoteType.
     * 
     * @param dataAggiornamento
     */
    public void setDataAggiornamento(java.util.Date dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DestinatarioConNoteType)) return false;
        DestinatarioConNoteType other = (DestinatarioConNoteType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.dataAggiornamento==null && other.getDataAggiornamento()==null) || 
             (this.dataAggiornamento!=null &&
              this.dataAggiornamento.equals(other.getDataAggiornamento())));
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
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getDataAggiornamento() != null) {
            _hashCode += getDataAggiornamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DestinatarioConNoteType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("sms.acaris.acta.doqui.it", "DestinatarioConNoteType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("", "note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAggiornamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataAggiornamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "date"));
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
