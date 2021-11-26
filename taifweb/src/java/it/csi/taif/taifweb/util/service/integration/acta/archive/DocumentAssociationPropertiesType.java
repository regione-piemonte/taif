/**
 * DocumentAssociationPropertiesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.archive;

public class DocumentAssociationPropertiesType  extends RelationshipPropertiesType  implements java.io.Serializable {
    public DocumentAssociationPropertiesType() {
    }

    public DocumentAssociationPropertiesType(
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId,
           it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType changeToken,
           java.lang.String relationType,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType sourceId,
           java.lang.String sourceType,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType targetId,
           java.lang.String targetType) {
        super(
            objectId,
            changeToken,
            relationType,
            sourceId,
            sourceType,
            targetId,
            targetType);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentAssociationPropertiesType)) return false;
        DocumentAssociationPropertiesType other = (DocumentAssociationPropertiesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentAssociationPropertiesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "DocumentAssociationPropertiesType"));
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
