/**
 * UserException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.svista;

import java.io.Serializable;

import javax.xml.namespace.QName;

import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.SerializationContext;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class UserException  extends CSIException  implements Serializable {
    public UserException() {
    }

    public UserException(
           String nestedExcClassName,
           String nestedExcMsg,
           String stackTraceMessage) {
        super(
            nestedExcClassName,
            nestedExcMsg,
            stackTraceMessage);
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UserException)) return false;
        UserException other = (UserException) obj;
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
    private static TypeDesc typeDesc =
        new TypeDesc(UserException.class, true);

    static {
        typeDesc.setXmlType(new QName("ente", "UserException"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(QName qname, SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
