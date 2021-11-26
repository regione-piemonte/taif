/**
 * FailedStepsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

public class FailedStepsInfo  implements java.io.Serializable {
    private java.lang.String fileName;

    private int[] failedSteps;

    public FailedStepsInfo() {
    }

    public FailedStepsInfo(
           java.lang.String fileName,
           int[] failedSteps) {
           this.fileName = fileName;
           this.failedSteps = failedSteps;
    }


    /**
     * Gets the fileName value for this FailedStepsInfo.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this FailedStepsInfo.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the failedSteps value for this FailedStepsInfo.
     * 
     * @return failedSteps
     */
    public int[] getFailedSteps() {
        return failedSteps;
    }


    /**
     * Sets the failedSteps value for this FailedStepsInfo.
     * 
     * @param failedSteps
     */
    public void setFailedSteps(int[] failedSteps) {
        this.failedSteps = failedSteps;
    }

    public int getFailedSteps(int i) {
        return this.failedSteps[i];
    }

    public void setFailedSteps(int i, int _value) {
        this.failedSteps[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FailedStepsInfo)) return false;
        FailedStepsInfo other = (FailedStepsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.failedSteps==null && other.getFailedSteps()==null) || 
             (this.failedSteps!=null &&
              java.util.Arrays.equals(this.failedSteps, other.getFailedSteps())));
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
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getFailedSteps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFailedSteps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFailedSteps(), i);
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
        new org.apache.axis.description.TypeDesc(FailedStepsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "FailedStepsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("failedSteps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "failedSteps"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "integer"));
        elemField.setMinOccurs(0);
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
