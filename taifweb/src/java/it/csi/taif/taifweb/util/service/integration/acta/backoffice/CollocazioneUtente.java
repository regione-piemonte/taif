/**
 * CollocazioneUtente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.backoffice;

public class CollocazioneUtente  implements java.io.Serializable {
    private it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType aoo;

    private it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType struttura;

    private it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType nodo;

    public CollocazioneUtente() {
    }

    public CollocazioneUtente(
           it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType aoo,
           it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType struttura,
           it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType nodo) {
           this.aoo = aoo;
           this.struttura = struttura;
           this.nodo = nodo;
    }


    /**
     * Gets the aoo value for this CollocazioneUtente.
     * 
     * @return aoo
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType getAoo() {
        return aoo;
    }


    /**
     * Sets the aoo value for this CollocazioneUtente.
     * 
     * @param aoo
     */
    public void setAoo(it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType aoo) {
        this.aoo = aoo;
    }


    /**
     * Gets the struttura value for this CollocazioneUtente.
     * 
     * @return struttura
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType getStruttura() {
        return struttura;
    }


    /**
     * Sets the struttura value for this CollocazioneUtente.
     * 
     * @param struttura
     */
    public void setStruttura(it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType struttura) {
        this.struttura = struttura;
    }


    /**
     * Gets the nodo value for this CollocazioneUtente.
     * 
     * @return nodo
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType getNodo() {
        return nodo;
    }


    /**
     * Sets the nodo value for this CollocazioneUtente.
     * 
     * @param nodo
     */
    public void setNodo(it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType nodo) {
        this.nodo = nodo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CollocazioneUtente)) return false;
        CollocazioneUtente other = (CollocazioneUtente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aoo==null && other.getAoo()==null) || 
             (this.aoo!=null &&
              this.aoo.equals(other.getAoo()))) &&
            ((this.struttura==null && other.getStruttura()==null) || 
             (this.struttura!=null &&
              this.struttura.equals(other.getStruttura()))) &&
            ((this.nodo==null && other.getNodo()==null) || 
             (this.nodo!=null &&
              this.nodo.equals(other.getNodo())));
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
        if (getAoo() != null) {
            _hashCode += getAoo().hashCode();
        }
        if (getStruttura() != null) {
            _hashCode += getStruttura().hashCode();
        }
        if (getNodo() != null) {
            _hashCode += getNodo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CollocazioneUtente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("backoffice.acaris.acta.doqui.it", "CollocazioneUtente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aoo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aoo"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaExtType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("struttura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "struttura"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaExtType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nodo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaExtType"));
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
