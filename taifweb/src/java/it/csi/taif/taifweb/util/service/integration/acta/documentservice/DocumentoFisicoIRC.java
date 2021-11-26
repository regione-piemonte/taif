/**
 * DocumentoFisicoIRC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;
import it.csi.taif.taifweb.util.service.integration.acta.common.PropertiesType;

public class DocumentoFisicoIRC  extends InfoRichiestaCreazione  implements java.io.Serializable {
    private ObjectIdType documentoArchivistico;

    private ObjectIdType documentRootFolderId;

    private PropertiesType propertiesDocumentoFisico;

    private ContenutoFisicoIRC[] contenutiFisici;

    private StepErrorAction[] azioniVerificaFirma;

    public DocumentoFisicoIRC() {
    }

    public DocumentoFisicoIRC(
           ObjectIdType documentoArchivistico,
           ObjectIdType documentRootFolderId,
           PropertiesType propertiesDocumentoFisico,
           ContenutoFisicoIRC[] contenutiFisici,
           StepErrorAction[] azioniVerificaFirma) {
        this.documentoArchivistico = documentoArchivistico;
        this.documentRootFolderId = documentRootFolderId;
        this.propertiesDocumentoFisico = propertiesDocumentoFisico;
        this.contenutiFisici = contenutiFisici;
        this.azioniVerificaFirma = azioniVerificaFirma;
    }


    /**
     * Gets the documentoArchivistico value for this DocumentoFisicoIRC.
     * 
     * @return documentoArchivistico
     */
    public ObjectIdType getDocumentoArchivistico() {
        return documentoArchivistico;
    }


    /**
     * Sets the documentoArchivistico value for this DocumentoFisicoIRC.
     * 
     * @param documentoArchivistico
     */
    public void setDocumentoArchivistico(ObjectIdType documentoArchivistico) {
        this.documentoArchivistico = documentoArchivistico;
    }


    /**
     * Gets the documentRootFolderId value for this DocumentoFisicoIRC.
     * 
     * @return documentRootFolderId
     */
    public ObjectIdType getDocumentRootFolderId() {
        return documentRootFolderId;
    }


    /**
     * Sets the documentRootFolderId value for this DocumentoFisicoIRC.
     * 
     * @param documentRootFolderId
     */
    public void setDocumentRootFolderId(ObjectIdType documentRootFolderId) {
        this.documentRootFolderId = documentRootFolderId;
    }


    /**
     * Gets the propertiesDocumentoFisico value for this DocumentoFisicoIRC.
     * 
     * @return propertiesDocumentoFisico
     */
    public PropertiesType getPropertiesDocumentoFisico() {
        return propertiesDocumentoFisico;
    }


    /**
     * Sets the propertiesDocumentoFisico value for this DocumentoFisicoIRC.
     * 
     * @param propertiesDocumentoFisico
     */
    public void setPropertiesDocumentoFisico(PropertiesType propertiesDocumentoFisico) {
        this.propertiesDocumentoFisico = propertiesDocumentoFisico;
    }


    /**
     * Gets the contenutiFisici value for this DocumentoFisicoIRC.
     * 
     * @return contenutiFisici
     */
    public ContenutoFisicoIRC[] getContenutiFisici() {
        return contenutiFisici;
    }


    /**
     * Sets the contenutiFisici value for this DocumentoFisicoIRC.
     * 
     * @param contenutiFisici
     */
    public void setContenutiFisici(ContenutoFisicoIRC[] contenutiFisici) {
        this.contenutiFisici = contenutiFisici;
    }

    public ContenutoFisicoIRC getContenutiFisici(int i) {
        return this.contenutiFisici[i];
    }

    public void setContenutiFisici(int i, ContenutoFisicoIRC _value) {
        this.contenutiFisici[i] = _value;
    }


    /**
     * Gets the azioniVerificaFirma value for this DocumentoFisicoIRC.
     * 
     * @return azioniVerificaFirma
     */
    public StepErrorAction[] getAzioniVerificaFirma() {
        return azioniVerificaFirma;
    }


    /**
     * Sets the azioniVerificaFirma value for this DocumentoFisicoIRC.
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
        if (!(obj instanceof DocumentoFisicoIRC)) return false;
        DocumentoFisicoIRC other = (DocumentoFisicoIRC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.documentoArchivistico==null && other.getDocumentoArchivistico()==null) || 
             (this.documentoArchivistico!=null &&
              this.documentoArchivistico.equals(other.getDocumentoArchivistico()))) &&
            ((this.documentRootFolderId==null && other.getDocumentRootFolderId()==null) || 
             (this.documentRootFolderId!=null &&
              this.documentRootFolderId.equals(other.getDocumentRootFolderId()))) &&
            ((this.propertiesDocumentoFisico==null && other.getPropertiesDocumentoFisico()==null) || 
             (this.propertiesDocumentoFisico!=null &&
              this.propertiesDocumentoFisico.equals(other.getPropertiesDocumentoFisico()))) &&
            ((this.contenutiFisici==null && other.getContenutiFisici()==null) || 
             (this.contenutiFisici!=null &&
              java.util.Arrays.equals(this.contenutiFisici, other.getContenutiFisici()))) &&
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
        if (getDocumentoArchivistico() != null) {
            _hashCode += getDocumentoArchivistico().hashCode();
        }
        if (getDocumentRootFolderId() != null) {
            _hashCode += getDocumentRootFolderId().hashCode();
        }
        if (getPropertiesDocumentoFisico() != null) {
            _hashCode += getPropertiesDocumentoFisico().hashCode();
        }
        if (getContenutiFisici() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContenutiFisici());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContenutiFisici(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(DocumentoFisicoIRC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "DocumentoFisicoIRC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoArchivistico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentoArchivistico"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentRootFolderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentRootFolderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertiesDocumentoFisico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertiesDocumentoFisico"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertiesType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenutiFisici");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contenutiFisici"));
        elemField.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "ContenutoFisicoIRC"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("azioniVerificaFirma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "azioniVerificaFirma"));
        elemField.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "StepErrorAction"));
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
