/**
 * ContenutoFisicoIdMap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;

public class ContenutoFisicoIdMap  extends MappaIdentificazioneDocumento  implements java.io.Serializable {
    private ObjectIdType contenutoFisicoId;

    private ObjectIdType documentoFisicoId;

    private ObjectIdType contentStreamId;

    private java.lang.String tipoContenuto;

    private ObjectIdType[] verifyReportList;

    public ContenutoFisicoIdMap() {
    }

    public ContenutoFisicoIdMap(
           boolean rappresentazioneLimitata,
           ObjectIdType contenutoFisicoId,
           ObjectIdType documentoFisicoId,
           ObjectIdType contentStreamId,
           java.lang.String tipoContenuto,
           ObjectIdType[] verifyReportList) {
        super(
            rappresentazioneLimitata);
        this.contenutoFisicoId = contenutoFisicoId;
        this.documentoFisicoId = documentoFisicoId;
        this.contentStreamId = contentStreamId;
        this.tipoContenuto = tipoContenuto;
        this.verifyReportList = verifyReportList;
    }


    /**
     * Gets the contenutoFisicoId value for this ContenutoFisicoIdMap.
     * 
     * @return contenutoFisicoId
     */
    public ObjectIdType getContenutoFisicoId() {
        return contenutoFisicoId;
    }


    /**
     * Sets the contenutoFisicoId value for this ContenutoFisicoIdMap.
     * 
     * @param contenutoFisicoId
     */
    public void setContenutoFisicoId(ObjectIdType contenutoFisicoId) {
        this.contenutoFisicoId = contenutoFisicoId;
    }


    /**
     * Gets the documentoFisicoId value for this ContenutoFisicoIdMap.
     * 
     * @return documentoFisicoId
     */
    public ObjectIdType getDocumentoFisicoId() {
        return documentoFisicoId;
    }


    /**
     * Sets the documentoFisicoId value for this ContenutoFisicoIdMap.
     * 
     * @param documentoFisicoId
     */
    public void setDocumentoFisicoId(ObjectIdType documentoFisicoId) {
        this.documentoFisicoId = documentoFisicoId;
    }


    /**
     * Gets the contentStreamId value for this ContenutoFisicoIdMap.
     * 
     * @return contentStreamId
     */
    public ObjectIdType getContentStreamId() {
        return contentStreamId;
    }


    /**
     * Sets the contentStreamId value for this ContenutoFisicoIdMap.
     * 
     * @param contentStreamId
     */
    public void setContentStreamId(ObjectIdType contentStreamId) {
        this.contentStreamId = contentStreamId;
    }


    /**
     * Gets the tipoContenuto value for this ContenutoFisicoIdMap.
     * 
     * @return tipoContenuto
     */
    public java.lang.String getTipoContenuto() {
        return tipoContenuto;
    }


    /**
     * Sets the tipoContenuto value for this ContenutoFisicoIdMap.
     * 
     * @param tipoContenuto
     */
    public void setTipoContenuto(java.lang.String tipoContenuto) {
        this.tipoContenuto = tipoContenuto;
    }


    /**
     * Gets the verifyReportList value for this ContenutoFisicoIdMap.
     * 
     * @return verifyReportList
     */
    public ObjectIdType[] getVerifyReportList() {
        return verifyReportList;
    }


    /**
     * Sets the verifyReportList value for this ContenutoFisicoIdMap.
     * 
     * @param verifyReportList
     */
    public void setVerifyReportList(ObjectIdType[] verifyReportList) {
        this.verifyReportList = verifyReportList;
    }

    public ObjectIdType getVerifyReportList(int i) {
        return this.verifyReportList[i];
    }

    public void setVerifyReportList(int i, ObjectIdType _value) {
        this.verifyReportList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContenutoFisicoIdMap)) return false;
        ContenutoFisicoIdMap other = (ContenutoFisicoIdMap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.contenutoFisicoId==null && other.getContenutoFisicoId()==null) || 
             (this.contenutoFisicoId!=null &&
              this.contenutoFisicoId.equals(other.getContenutoFisicoId()))) &&
            ((this.documentoFisicoId==null && other.getDocumentoFisicoId()==null) || 
             (this.documentoFisicoId!=null &&
              this.documentoFisicoId.equals(other.getDocumentoFisicoId()))) &&
            ((this.contentStreamId==null && other.getContentStreamId()==null) || 
             (this.contentStreamId!=null &&
              this.contentStreamId.equals(other.getContentStreamId()))) &&
            ((this.tipoContenuto==null && other.getTipoContenuto()==null) || 
             (this.tipoContenuto!=null &&
              this.tipoContenuto.equals(other.getTipoContenuto()))) &&
            ((this.verifyReportList==null && other.getVerifyReportList()==null) || 
             (this.verifyReportList!=null &&
              java.util.Arrays.equals(this.verifyReportList, other.getVerifyReportList())));
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
        if (getContenutoFisicoId() != null) {
            _hashCode += getContenutoFisicoId().hashCode();
        }
        if (getDocumentoFisicoId() != null) {
            _hashCode += getDocumentoFisicoId().hashCode();
        }
        if (getContentStreamId() != null) {
            _hashCode += getContentStreamId().hashCode();
        }
        if (getTipoContenuto() != null) {
            _hashCode += getTipoContenuto().hashCode();
        }
        if (getVerifyReportList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVerifyReportList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVerifyReportList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContenutoFisicoIdMap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "ContenutoFisicoIdMap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenutoFisicoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contenutoFisicoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoFisicoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentoFisicoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentStreamId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contentStreamId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoContenuto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoContenuto"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verifyReportList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "verifyReportList"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
