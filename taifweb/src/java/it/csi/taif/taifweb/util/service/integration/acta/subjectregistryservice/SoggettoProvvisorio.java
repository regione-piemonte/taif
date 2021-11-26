/**
 * SoggettoProvvisorio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class SoggettoProvvisorio  extends SoggettoRequest  implements java.io.Serializable {
    private InfoComuniCreazioneSoggetto infoComuniCreazioneSoggetto;

    public SoggettoProvvisorio() {
    }

    public SoggettoProvvisorio(
           InfoComuniCreazioneSoggetto infoComuniCreazioneSoggetto) {
        this.infoComuniCreazioneSoggetto = infoComuniCreazioneSoggetto;
    }


    /**
     * Gets the infoComuniCreazioneSoggetto value for this SoggettoProvvisorio.
     * 
     * @return infoComuniCreazioneSoggetto
     */
    public InfoComuniCreazioneSoggetto getInfoComuniCreazioneSoggetto() {
        return infoComuniCreazioneSoggetto;
    }


    /**
     * Sets the infoComuniCreazioneSoggetto value for this SoggettoProvvisorio.
     * 
     * @param infoComuniCreazioneSoggetto
     */
    public void setInfoComuniCreazioneSoggetto(InfoComuniCreazioneSoggetto infoComuniCreazioneSoggetto) {
        this.infoComuniCreazioneSoggetto = infoComuniCreazioneSoggetto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoggettoProvvisorio)) return false;
        SoggettoProvvisorio other = (SoggettoProvvisorio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.infoComuniCreazioneSoggetto==null && other.getInfoComuniCreazioneSoggetto()==null) || 
             (this.infoComuniCreazioneSoggetto!=null &&
              this.infoComuniCreazioneSoggetto.equals(other.getInfoComuniCreazioneSoggetto())));
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
        if (getInfoComuniCreazioneSoggetto() != null) {
            _hashCode += getInfoComuniCreazioneSoggetto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoggettoProvvisorio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "SoggettoProvvisorio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("infoComuniCreazioneSoggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "infoComuniCreazioneSoggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "InfoComuniCreazioneSoggetto"));
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
