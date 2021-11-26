/**
 * ContenutoFisicoIRC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.AcarisContentStreamType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;
import it.csi.taif.taifweb.util.service.integration.acta.common.PropertiesType;

public class ContenutoFisicoIRC  extends InfoRichiestaCreazione  implements java.io.Serializable {
    private ObjectIdType documentoFisico;

    private ChangeTokenType dataUltimoAggiornamentoDocumento;

    private PropertiesType propertiesContenutoFisico;

    private java.lang.String tipo;

    private AcarisContentStreamType stream;

    private StepErrorAction[] azioniVerificaFirma;

    public ContenutoFisicoIRC() {
    }

    public ContenutoFisicoIRC(
           ObjectIdType documentoFisico,
           ChangeTokenType dataUltimoAggiornamentoDocumento,
           PropertiesType propertiesContenutoFisico,
           java.lang.String tipo,
           AcarisContentStreamType stream,
           StepErrorAction[] azioniVerificaFirma) {
        this.documentoFisico = documentoFisico;
        this.dataUltimoAggiornamentoDocumento = dataUltimoAggiornamentoDocumento;
        this.propertiesContenutoFisico = propertiesContenutoFisico;
        this.tipo = tipo;
        this.stream = stream;
        this.azioniVerificaFirma = azioniVerificaFirma;
    }


    /**
     * Gets the documentoFisico value for this ContenutoFisicoIRC.
     * 
     * @return documentoFisico
     */
    public ObjectIdType getDocumentoFisico() {
        return documentoFisico;
    }


    /**
     * Sets the documentoFisico value for this ContenutoFisicoIRC.
     * 
     * @param documentoFisico
     */
    public void setDocumentoFisico(ObjectIdType documentoFisico) {
        this.documentoFisico = documentoFisico;
    }


    /**
     * Gets the dataUltimoAggiornamentoDocumento value for this ContenutoFisicoIRC.
     * 
     * @return dataUltimoAggiornamentoDocumento
     */
    public ChangeTokenType getDataUltimoAggiornamentoDocumento() {
        return dataUltimoAggiornamentoDocumento;
    }


    /**
     * Sets the dataUltimoAggiornamentoDocumento value for this ContenutoFisicoIRC.
     * 
     * @param dataUltimoAggiornamentoDocumento
     */
    public void setDataUltimoAggiornamentoDocumento(ChangeTokenType dataUltimoAggiornamentoDocumento) {
        this.dataUltimoAggiornamentoDocumento = dataUltimoAggiornamentoDocumento;
    }


    /**
     * Gets the propertiesContenutoFisico value for this ContenutoFisicoIRC.
     * 
     * @return propertiesContenutoFisico
     */
    public PropertiesType getPropertiesContenutoFisico() {
        return propertiesContenutoFisico;
    }


    /**
     * Sets the propertiesContenutoFisico value for this ContenutoFisicoIRC.
     * 
     * @param propertiesContenutoFisico
     */
    public void setPropertiesContenutoFisico(PropertiesType propertiesContenutoFisico) {
        this.propertiesContenutoFisico = propertiesContenutoFisico;
    }


    /**
     * Gets the tipo value for this ContenutoFisicoIRC.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this ContenutoFisicoIRC.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the stream value for this ContenutoFisicoIRC.
     * 
     * @return stream
     */
    public AcarisContentStreamType getStream() {
        return stream;
    }


    /**
     * Sets the stream value for this ContenutoFisicoIRC.
     * 
     * @param stream
     */
    public void setStream(AcarisContentStreamType stream) {
        this.stream = stream;
    }


    /**
     * Gets the azioniVerificaFirma value for this ContenutoFisicoIRC.
     * 
     * @return azioniVerificaFirma
     */
    public StepErrorAction[] getAzioniVerificaFirma() {
        return azioniVerificaFirma;
    }


    /**
     * Sets the azioniVerificaFirma value for this ContenutoFisicoIRC.
     * 
     * @param azioniVerificaFirma
     */
    public void setAzioniVerificaFirma(StepErrorAction[] azioniVerificaFirma) {
        this.azioniVerificaFirma = azioniVerificaFirma;
    }

    public StepErrorAction getAzioniVerificaFirma(int i) {
        return this.azioniVerificaFirma[i];
    }

    public void setAzioniVerificaFirma(int i, StepErrorAction _value) {
        this.azioniVerificaFirma[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContenutoFisicoIRC)) return false;
        ContenutoFisicoIRC other = (ContenutoFisicoIRC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.documentoFisico==null && other.getDocumentoFisico()==null) || 
             (this.documentoFisico!=null &&
              this.documentoFisico.equals(other.getDocumentoFisico()))) &&
            ((this.dataUltimoAggiornamentoDocumento==null && other.getDataUltimoAggiornamentoDocumento()==null) || 
             (this.dataUltimoAggiornamentoDocumento!=null &&
              this.dataUltimoAggiornamentoDocumento.equals(other.getDataUltimoAggiornamentoDocumento()))) &&
            ((this.propertiesContenutoFisico==null && other.getPropertiesContenutoFisico()==null) || 
             (this.propertiesContenutoFisico!=null &&
              this.propertiesContenutoFisico.equals(other.getPropertiesContenutoFisico()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.stream==null && other.getStream()==null) || 
             (this.stream!=null &&
              this.stream.equals(other.getStream()))) &&
            ((this.azioniVerificaFirma==null && other.getAzioniVerificaFirma()==null) || 
             (this.azioniVerificaFirma!=null &&
              java.util.Arrays.equals(this.azioniVerificaFirma, other.getAzioniVerificaFirma())));
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
        if (getDocumentoFisico() != null) {
            _hashCode += getDocumentoFisico().hashCode();
        }
        if (getDataUltimoAggiornamentoDocumento() != null) {
            _hashCode += getDataUltimoAggiornamentoDocumento().hashCode();
        }
        if (getPropertiesContenutoFisico() != null) {
            _hashCode += getPropertiesContenutoFisico().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getStream() != null) {
            _hashCode += getStream().hashCode();
        }
        if (getAzioniVerificaFirma() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAzioniVerificaFirma());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAzioniVerificaFirma(), i);
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
        new org.apache.axis.description.TypeDesc(ContenutoFisicoIRC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "ContenutoFisicoIRC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoFisico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentoFisico"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataUltimoAggiornamentoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataUltimoAggiornamentoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ChangeTokenType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertiesContenutoFisico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertiesContenutoFisico"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertiesType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stream");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stream"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisContentStreamType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("azioniVerificaFirma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "azioniVerificaFirma"));
        elemField.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "StepErrorAction"));
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
