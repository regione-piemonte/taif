/**
 * InfoCreazioneType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.sms;

public class InfoCreazioneType  implements java.io.Serializable {
    private IdTipoSmistamentoType tipoSmistamento;

    private boolean visibileATutti;

    private java.lang.String note;

    private boolean modificaDoc;

    private boolean modificaConVersionamento;

    private it.csi.taif.taifweb.util.service.integration.acta.common.IdSmistamentoType smistamentoPadre;

    public InfoCreazioneType() {
    }

    public InfoCreazioneType(
           IdTipoSmistamentoType tipoSmistamento,
           boolean visibileATutti,
           java.lang.String note,
           boolean modificaDoc,
           boolean modificaConVersionamento,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdSmistamentoType smistamentoPadre) {
           this.tipoSmistamento = tipoSmistamento;
           this.visibileATutti = visibileATutti;
           this.note = note;
           this.modificaDoc = modificaDoc;
           this.modificaConVersionamento = modificaConVersionamento;
           this.smistamentoPadre = smistamentoPadre;
    }


    /**
     * Gets the tipoSmistamento value for this InfoCreazioneType.
     * 
     * @return tipoSmistamento
     */
    public IdTipoSmistamentoType getTipoSmistamento() {
        return tipoSmistamento;
    }


    /**
     * Sets the tipoSmistamento value for this InfoCreazioneType.
     * 
     * @param tipoSmistamento
     */
    public void setTipoSmistamento(IdTipoSmistamentoType tipoSmistamento) {
        this.tipoSmistamento = tipoSmistamento;
    }


    /**
     * Gets the visibileATutti value for this InfoCreazioneType.
     * 
     * @return visibileATutti
     */
    public boolean isVisibileATutti() {
        return visibileATutti;
    }


    /**
     * Sets the visibileATutti value for this InfoCreazioneType.
     * 
     * @param visibileATutti
     */
    public void setVisibileATutti(boolean visibileATutti) {
        this.visibileATutti = visibileATutti;
    }


    /**
     * Gets the note value for this InfoCreazioneType.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this InfoCreazioneType.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the modificaDoc value for this InfoCreazioneType.
     * 
     * @return modificaDoc
     */
    public boolean isModificaDoc() {
        return modificaDoc;
    }


    /**
     * Sets the modificaDoc value for this InfoCreazioneType.
     * 
     * @param modificaDoc
     */
    public void setModificaDoc(boolean modificaDoc) {
        this.modificaDoc = modificaDoc;
    }


    /**
     * Gets the modificaConVersionamento value for this InfoCreazioneType.
     * 
     * @return modificaConVersionamento
     */
    public boolean isModificaConVersionamento() {
        return modificaConVersionamento;
    }


    /**
     * Sets the modificaConVersionamento value for this InfoCreazioneType.
     * 
     * @param modificaConVersionamento
     */
    public void setModificaConVersionamento(boolean modificaConVersionamento) {
        this.modificaConVersionamento = modificaConVersionamento;
    }


    /**
     * Gets the smistamentoPadre value for this InfoCreazioneType.
     * 
     * @return smistamentoPadre
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.IdSmistamentoType getSmistamentoPadre() {
        return smistamentoPadre;
    }


    /**
     * Sets the smistamentoPadre value for this InfoCreazioneType.
     * 
     * @param smistamentoPadre
     */
    public void setSmistamentoPadre(it.csi.taif.taifweb.util.service.integration.acta.common.IdSmistamentoType smistamentoPadre) {
        this.smistamentoPadre = smistamentoPadre;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InfoCreazioneType)) return false;
        InfoCreazioneType other = (InfoCreazioneType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipoSmistamento==null && other.getTipoSmistamento()==null) || 
             (this.tipoSmistamento!=null &&
              this.tipoSmistamento.equals(other.getTipoSmistamento()))) &&
            this.visibileATutti == other.isVisibileATutti() &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            this.modificaDoc == other.isModificaDoc() &&
            this.modificaConVersionamento == other.isModificaConVersionamento() &&
            ((this.smistamentoPadre==null && other.getSmistamentoPadre()==null) || 
             (this.smistamentoPadre!=null &&
              this.smistamentoPadre.equals(other.getSmistamentoPadre())));
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
        if (getTipoSmistamento() != null) {
            _hashCode += getTipoSmistamento().hashCode();
        }
        _hashCode += (isVisibileATutti() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        _hashCode += (isModificaDoc() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isModificaConVersionamento() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSmistamentoPadre() != null) {
            _hashCode += getSmistamentoPadre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InfoCreazioneType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("sms.acaris.acta.doqui.it", "InfoCreazioneType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoSmistamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoSmistamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("sms.acaris.acta.doqui.it", "IdTipoSmistamentoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visibileATutti");
        elemField.setXmlName(new javax.xml.namespace.QName("", "visibileATutti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("", "note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modificaDoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modificaDoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modificaConVersionamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modificaConVersionamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smistamentoPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smistamentoPadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "IdSmistamentoType"));
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
