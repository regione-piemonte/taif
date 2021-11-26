/**
 * CSIException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.topforweb.util.service.integration.svista;

import javax.xml.namespace.QName;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.SerializationContext;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class CSIException  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private String nestedExcClassName;

    private String nestedExcMsg;

    private String stackTraceMessage;

    public CSIException() {
    }

    public CSIException(
           String nestedExcClassName,
           String nestedExcMsg,
           String stackTraceMessage) {
        this.nestedExcClassName = nestedExcClassName;
        this.nestedExcMsg = nestedExcMsg;
        this.stackTraceMessage = stackTraceMessage;
    }


    /**
     * Gets the nestedExcClassName value for this CSIException.
     * 
     * @return nestedExcClassName
     */
    public String getNestedExcClassName() {
        return nestedExcClassName;
    }


    /**
     * Sets the nestedExcClassName value for this CSIException.
     * 
     * @param nestedExcClassName
     */
    public void setNestedExcClassName(String nestedExcClassName) {
        this.nestedExcClassName = nestedExcClassName;
    }


    /**
     * Gets the nestedExcMsg value for this CSIException.
     * 
     * @return nestedExcMsg
     */
    public String getNestedExcMsg() {
        return nestedExcMsg;
    }


    /**
     * Sets the nestedExcMsg value for this CSIException.
     * 
     * @param nestedExcMsg
     */
    public void setNestedExcMsg(String nestedExcMsg) {
        this.nestedExcMsg = nestedExcMsg;
    }


    /**
     * Gets the stackTraceMessage value for this CSIException.
     * 
     * @return stackTraceMessage
     */
    public String getStackTraceMessage() {
        return stackTraceMessage;
    }


    /**
     * Sets the stackTraceMessage value for this CSIException.
     * 
     * @param stackTraceMessage
     */
    public void setStackTraceMessage(String stackTraceMessage) {
        this.stackTraceMessage = stackTraceMessage;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CSIException)) return false;
        CSIException other = (CSIException) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nestedExcClassName==null && other.getNestedExcClassName()==null) || 
             (this.nestedExcClassName!=null &&
              this.nestedExcClassName.equals(other.getNestedExcClassName()))) &&
            ((this.nestedExcMsg==null && other.getNestedExcMsg()==null) || 
             (this.nestedExcMsg!=null &&
              this.nestedExcMsg.equals(other.getNestedExcMsg()))) &&
            ((this.stackTraceMessage==null && other.getStackTraceMessage()==null) || 
             (this.stackTraceMessage!=null &&
              this.stackTraceMessage.equals(other.getStackTraceMessage())));
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
        if (getNestedExcClassName() != null) {
            _hashCode += getNestedExcClassName().hashCode();
        }
        if (getNestedExcMsg() != null) {
            _hashCode += getNestedExcMsg().hashCode();
        }
        if (getStackTraceMessage() != null) {
            _hashCode += getStackTraceMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(CSIException.class, true);

    static {
        typeDesc.setXmlType(new QName("ente", "CSIException"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("nestedExcClassName");
        elemField.setXmlName(new QName("ente", "nestedExcClassName"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("nestedExcMsg");
        elemField.setXmlName(new QName("ente", "nestedExcMsg"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("stackTraceMessage");
        elemField.setXmlName(new QName("ente", "stackTraceMessage"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
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
