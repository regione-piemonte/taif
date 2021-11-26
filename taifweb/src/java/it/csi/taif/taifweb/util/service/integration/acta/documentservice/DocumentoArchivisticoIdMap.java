/**
 * DocumentoArchivisticoIdMap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;

public class DocumentoArchivisticoIdMap  extends MappaIdentificazioneDocumento  implements java.io.Serializable {
    private ObjectIdType documentoArchivisticoId;

    private CollocazioneDocumento[] collocazioni;

    private DocumentoFisicoIdMap[] documentiFisiciIdMap;

    public DocumentoArchivisticoIdMap() {
    }

    public DocumentoArchivisticoIdMap(
           boolean rappresentazioneLimitata,
           ObjectIdType documentoArchivisticoId,
           CollocazioneDocumento[] collocazioni,
           DocumentoFisicoIdMap[] documentiFisiciIdMap) {
        super(
            rappresentazioneLimitata);
        this.documentoArchivisticoId = documentoArchivisticoId;
        this.collocazioni = collocazioni;
        this.documentiFisiciIdMap = documentiFisiciIdMap;
    }


    /**
     * Gets the documentoArchivisticoId value for this DocumentoArchivisticoIdMap.
     * 
     * @return documentoArchivisticoId
     */
    public ObjectIdType getDocumentoArchivisticoId() {
        return documentoArchivisticoId;
    }


    /**
     * Sets the documentoArchivisticoId value for this DocumentoArchivisticoIdMap.
     * 
     * @param documentoArchivisticoId
     */
    public void setDocumentoArchivisticoId(ObjectIdType documentoArchivisticoId) {
        this.documentoArchivisticoId = documentoArchivisticoId;
    }


    /**
     * Gets the collocazioni value for this DocumentoArchivisticoIdMap.
     * 
     * @return collocazioni
     */
    public CollocazioneDocumento[] getCollocazioni() {
        return collocazioni;
    }


    /**
     * Sets the collocazioni value for this DocumentoArchivisticoIdMap.
     * 
     * @param collocazioni
     */
    public void setCollocazioni(CollocazioneDocumento[] collocazioni) {
        this.collocazioni = collocazioni;
    }

    public CollocazioneDocumento getCollocazioni(int i) {
        return this.collocazioni[i];
    }

    public void setCollocazioni(int i, CollocazioneDocumento _value) {
        this.collocazioni[i] = _value;
    }


    /**
     * Gets the documentiFisiciIdMap value for this DocumentoArchivisticoIdMap.
     * 
     * @return documentiFisiciIdMap
     */
    public DocumentoFisicoIdMap[] getDocumentiFisiciIdMap() {
        return documentiFisiciIdMap;
    }


    /**
     * Sets the documentiFisiciIdMap value for this DocumentoArchivisticoIdMap.
     * 
     * @param documentiFisiciIdMap
     */
    public void setDocumentiFisiciIdMap(DocumentoFisicoIdMap[] documentiFisiciIdMap) {
        this.documentiFisiciIdMap = documentiFisiciIdMap;
    }

    public DocumentoFisicoIdMap getDocumentiFisiciIdMap(int i) {
        return this.documentiFisiciIdMap[i];
    }

    public void setDocumentiFisiciIdMap(int i, DocumentoFisicoIdMap _value) {
        this.documentiFisiciIdMap[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoArchivisticoIdMap)) return false;
        DocumentoArchivisticoIdMap other = (DocumentoArchivisticoIdMap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.documentoArchivisticoId==null && other.getDocumentoArchivisticoId()==null) || 
             (this.documentoArchivisticoId!=null &&
              this.documentoArchivisticoId.equals(other.getDocumentoArchivisticoId()))) &&
            ((this.collocazioni==null && other.getCollocazioni()==null) || 
             (this.collocazioni!=null &&
              java.util.Arrays.equals(this.collocazioni, other.getCollocazioni()))) &&
            ((this.documentiFisiciIdMap==null && other.getDocumentiFisiciIdMap()==null) || 
             (this.documentiFisiciIdMap!=null &&
              java.util.Arrays.equals(this.documentiFisiciIdMap, other.getDocumentiFisiciIdMap())));
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
        if (getDocumentoArchivisticoId() != null) {
            _hashCode += getDocumentoArchivisticoId().hashCode();
        }
        if (getCollocazioni() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCollocazioni());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCollocazioni(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocumentiFisiciIdMap() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentiFisiciIdMap());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentiFisiciIdMap(), i);
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
        new org.apache.axis.description.TypeDesc(DocumentoArchivisticoIdMap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "DocumentoArchivisticoIdMap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoArchivisticoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentoArchivisticoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collocazioni");
        elemField.setXmlName(new javax.xml.namespace.QName("", "collocazioni"));
        elemField.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "CollocazioneDocumento"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentiFisiciIdMap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentiFisiciIdMap"));
        elemField.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "DocumentoFisicoIdMap"));
        elemField.setMinOccurs(0);
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
