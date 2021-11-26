/**
 * ProtocollazioneDaSmistamento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.officialbookservice;

public class ProtocollazioneDaSmistamento  extends RegistrazioneRequest  implements java.io.Serializable {
    private long smistamentoId;

    private RegistrazioneAPI registrazioneAPI;

    public ProtocollazioneDaSmistamento() {
    }

    public ProtocollazioneDaSmistamento(
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType registroId,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType aooProtocollanteId,
           boolean senzaCreazioneSoggettiEsterni,
           long smistamentoId,
           RegistrazioneAPI registrazioneAPI) {
        super(
            registroId,
            aooProtocollanteId,
            senzaCreazioneSoggettiEsterni);
        this.smistamentoId = smistamentoId;
        this.registrazioneAPI = registrazioneAPI;
    }


    /**
     * Gets the smistamentoId value for this ProtocollazioneDaSmistamento.
     * 
     * @return smistamentoId
     */
    public long getSmistamentoId() {
        return smistamentoId;
    }


    /**
     * Sets the smistamentoId value for this ProtocollazioneDaSmistamento.
     * 
     * @param smistamentoId
     */
    public void setSmistamentoId(long smistamentoId) {
        this.smistamentoId = smistamentoId;
    }


    /**
     * Gets the registrazioneAPI value for this ProtocollazioneDaSmistamento.
     * 
     * @return registrazioneAPI
     */
    public RegistrazioneAPI getRegistrazioneAPI() {
        return registrazioneAPI;
    }


    /**
     * Sets the registrazioneAPI value for this ProtocollazioneDaSmistamento.
     * 
     * @param registrazioneAPI
     */
    public void setRegistrazioneAPI(RegistrazioneAPI registrazioneAPI) {
        this.registrazioneAPI = registrazioneAPI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProtocollazioneDaSmistamento)) return false;
        ProtocollazioneDaSmistamento other = (ProtocollazioneDaSmistamento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.smistamentoId == other.getSmistamentoId() &&
            ((this.registrazioneAPI==null && other.getRegistrazioneAPI()==null) || 
             (this.registrazioneAPI!=null &&
              this.registrazioneAPI.equals(other.getRegistrazioneAPI())));
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
        _hashCode += new Long(getSmistamentoId()).hashCode();
        if (getRegistrazioneAPI() != null) {
            _hashCode += getRegistrazioneAPI().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProtocollazioneDaSmistamento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "ProtocollazioneDaSmistamento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smistamentoId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "smistamentoId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrazioneAPI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registrazioneAPI"));
        elemField.setXmlType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistrazioneAPI"));
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
