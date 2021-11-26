/**
 * DocumentoFisicoIdMap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;

public class DocumentoFisicoIdMap  extends MappaIdentificazioneDocumento  implements java.io.Serializable {
    private ObjectIdType documentoFisicoId;

    private ObjectIdType documentoArchivisticoId;

    private ContenutoFisicoIdMap[] contenutiFisiciIdMap;

    public DocumentoFisicoIdMap() {
    }

    public DocumentoFisicoIdMap(
           boolean rappresentazioneLimitata,
           ObjectIdType documentoFisicoId,
           ObjectIdType documentoArchivisticoId,
           ContenutoFisicoIdMap[] contenutiFisiciIdMap) {
        super(
            rappresentazioneLimitata);
        this.documentoFisicoId = documentoFisicoId;
        this.documentoArchivisticoId = documentoArchivisticoId;
        this.contenutiFisiciIdMap = contenutiFisiciIdMap;
    }


    /**
     * Gets the documentoFisicoId value for this DocumentoFisicoIdMap.
     * 
     * @return documentoFisicoId
     */
    public ObjectIdType getDocumentoFisicoId() {
        return documentoFisicoId;
    }


    /**
     * Sets the documentoFisicoId value for this DocumentoFisicoIdMap.
     * 
     * @param documentoFisicoId
     */
    public void setDocumentoFisicoId(ObjectIdType documentoFisicoId) {
        this.documentoFisicoId = documentoFisicoId;
    }


    /**
     * Gets the documentoArchivisticoId value for this DocumentoFisicoIdMap.
     * 
     * @return documentoArchivisticoId
     */
    public ObjectIdType getDocumentoArchivisticoId() {
        return documentoArchivisticoId;
    }


    /**
     * Sets the documentoArchivisticoId value for this DocumentoFisicoIdMap.
     * 
     * @param documentoArchivisticoId
     */
    public void setDocumentoArchivisticoId(ObjectIdType documentoArchivisticoId) {
        this.documentoArchivisticoId = documentoArchivisticoId;
    }


    /**
     * Gets the contenutiFisiciIdMap value for this DocumentoFisicoIdMap.
     * 
     * @return contenutiFisiciIdMap
     */
    public ContenutoFisicoIdMap[] getContenutiFisiciIdMap() {
        return contenutiFisiciIdMap;
    }


    /**
     * Sets the contenutiFisiciIdMap value for this DocumentoFisicoIdMap.
     * 
     * @param contenutiFisiciIdMap
     */
    public void setContenutiFisiciIdMap(ContenutoFisicoIdMap[] contenutiFisiciIdMap) {
        this.contenutiFisiciIdMap = contenutiFisiciIdMap;
    }

    public ContenutoFisicoIdMap getContenutiFisiciIdMap(int i) {
        return this.contenutiFisiciIdMap[i];
    }

    public void setContenutiFisiciIdMap(int i, ContenutoFisicoIdMap _value) {
        this.contenutiFisiciIdMap[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoFisicoIdMap)) return false;
        DocumentoFisicoIdMap other = (DocumentoFisicoIdMap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.documentoFisicoId==null && other.getDocumentoFisicoId()==null) || 
             (this.documentoFisicoId!=null &&
              this.documentoFisicoId.equals(other.getDocumentoFisicoId()))) &&
            ((this.documentoArchivisticoId==null && other.getDocumentoArchivisticoId()==null) || 
             (this.documentoArchivisticoId!=null &&
              this.documentoArchivisticoId.equals(other.getDocumentoArchivisticoId()))) &&
            ((this.contenutiFisiciIdMap==null && other.getContenutiFisiciIdMap()==null) || 
             (this.contenutiFisiciIdMap!=null &&
              java.util.Arrays.equals(this.contenutiFisiciIdMap, other.getContenutiFisiciIdMap())));
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
        if (getDocumentoFisicoId() != null) {
            _hashCode += getDocumentoFisicoId().hashCode();
        }
        if (getDocumentoArchivisticoId() != null) {
            _hashCode += getDocumentoArchivisticoId().hashCode();
        }
        if (getContenutiFisiciIdMap() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContenutiFisiciIdMap());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContenutiFisiciIdMap(), i);
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
        new org.apache.axis.description.TypeDesc(DocumentoFisicoIdMap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "DocumentoFisicoIdMap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoFisicoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentoFisicoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoArchivisticoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentoArchivisticoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenutiFisiciIdMap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ContenutiFisiciIdMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "ContenutoFisicoIdMap"));
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
