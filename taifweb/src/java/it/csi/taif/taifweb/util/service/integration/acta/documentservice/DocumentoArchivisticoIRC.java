/**
 * DocumentoArchivisticoIRC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.archive.GruppoAllegatiPropertiesType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;
import it.csi.taif.taifweb.util.service.integration.acta.common.PropertiesType;


public class DocumentoArchivisticoIRC  extends InfoRichiestaCreazione  implements java.io.Serializable {
    private ObjectIdType parentFolderId;

    private java.lang.String tipoDocumento;

    private boolean allegato;

    private GruppoAllegatiPropertiesType gruppoAllegati;

    private ObjectIdType classificazionePrincipale;

    private PropertiesType propertiesDocumento;

    private PropertiesType propertiesClassificazione;

    private DocumentoFisicoIRC[] documentiFisici;

    public DocumentoArchivisticoIRC() {
    }

    public DocumentoArchivisticoIRC(
           ObjectIdType parentFolderId,
           java.lang.String tipoDocumento,
           boolean allegato,
           GruppoAllegatiPropertiesType gruppoAllegati,
           ObjectIdType classificazionePrincipale,
           PropertiesType propertiesDocumento,
           PropertiesType propertiesClassificazione,
           DocumentoFisicoIRC[] documentiFisici) {
        this.parentFolderId = parentFolderId;
        this.tipoDocumento = tipoDocumento;
        this.allegato = allegato;
        this.gruppoAllegati = gruppoAllegati;
        this.classificazionePrincipale = classificazionePrincipale;
        this.propertiesDocumento = propertiesDocumento;
        this.propertiesClassificazione = propertiesClassificazione;
        this.documentiFisici = documentiFisici;
    }


    /**
     * Gets the parentFolderId value for this DocumentoArchivisticoIRC.
     * 
     * @return parentFolderId
     */
    public ObjectIdType getParentFolderId() {
        return parentFolderId;
    }


    /**
     * Sets the parentFolderId value for this DocumentoArchivisticoIRC.
     * 
     * @param parentFolderId
     */
    public void setParentFolderId(ObjectIdType parentFolderId) {
        this.parentFolderId = parentFolderId;
    }


    /**
     * Gets the tipoDocumento value for this DocumentoArchivisticoIRC.
     * 
     * @return tipoDocumento
     */
    public java.lang.String getTipoDocumento() {
        return tipoDocumento;
    }


    /**
     * Sets the tipoDocumento value for this DocumentoArchivisticoIRC.
     * 
     * @param tipoDocumento
     */
    public void setTipoDocumento(java.lang.String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    /**
     * Gets the allegato value for this DocumentoArchivisticoIRC.
     * 
     * @return allegato
     */
    public boolean isAllegato() {
        return allegato;
    }


    /**
     * Sets the allegato value for this DocumentoArchivisticoIRC.
     * 
     * @param allegato
     */
    public void setAllegato(boolean allegato) {
        this.allegato = allegato;
    }


    /**
     * Gets the gruppoAllegati value for this DocumentoArchivisticoIRC.
     * 
     * @return gruppoAllegati
     */
    public GruppoAllegatiPropertiesType getGruppoAllegati() {
        return gruppoAllegati;
    }


    /**
     * Sets the gruppoAllegati value for this DocumentoArchivisticoIRC.
     * 
     * @param gruppoAllegati
     */
    public void setGruppoAllegati(GruppoAllegatiPropertiesType gruppoAllegati) {
        this.gruppoAllegati = gruppoAllegati;
    }


    /**
     * Gets the classificazionePrincipale value for this DocumentoArchivisticoIRC.
     * 
     * @return classificazionePrincipale
     */
    public ObjectIdType getClassificazionePrincipale() {
        return classificazionePrincipale;
    }


    /**
     * Sets the classificazionePrincipale value for this DocumentoArchivisticoIRC.
     * 
     * @param classificazionePrincipale
     */
    public void setClassificazionePrincipale(ObjectIdType classificazionePrincipale) {
        this.classificazionePrincipale = classificazionePrincipale;
    }


    /**
     * Gets the propertiesDocumento value for this DocumentoArchivisticoIRC.
     * 
     * @return propertiesDocumento
     */
    public PropertiesType getPropertiesDocumento() {
        return propertiesDocumento;
    }


    /**
     * Sets the propertiesDocumento value for this DocumentoArchivisticoIRC.
     * 
     * @param propertiesDocumento
     */
    public void setPropertiesDocumento(PropertiesType propertiesDocumento) {
        this.propertiesDocumento = propertiesDocumento;
    }


    /**
     * Gets the propertiesClassificazione value for this DocumentoArchivisticoIRC.
     * 
     * @return propertiesClassificazione
     */
    public PropertiesType getPropertiesClassificazione() {
        return propertiesClassificazione;
    }


    /**
     * Sets the propertiesClassificazione value for this DocumentoArchivisticoIRC.
     * 
     * @param propertiesClassificazione
     */
    public void setPropertiesClassificazione(PropertiesType propertiesClassificazione) {
        this.propertiesClassificazione = propertiesClassificazione;
    }


    /**
     * Gets the documentiFisici value for this DocumentoArchivisticoIRC.
     * 
     * @return documentiFisici
     */
    public DocumentoFisicoIRC[] getDocumentiFisici() {
        return documentiFisici;
    }


    /**
     * Sets the documentiFisici value for this DocumentoArchivisticoIRC.
     * 
     * @param documentiFisici
     */
    public void setDocumentiFisici(DocumentoFisicoIRC[] documentiFisici) {
        this.documentiFisici = documentiFisici;
    }

    public DocumentoFisicoIRC getDocumentiFisici(int i) {
        return this.documentiFisici[i];
    }

    public void setDocumentiFisici(int i, DocumentoFisicoIRC _value) {
        this.documentiFisici[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoArchivisticoIRC)) return false;
        DocumentoArchivisticoIRC other = (DocumentoArchivisticoIRC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.parentFolderId==null && other.getParentFolderId()==null) || 
             (this.parentFolderId!=null &&
              this.parentFolderId.equals(other.getParentFolderId()))) &&
            ((this.tipoDocumento==null && other.getTipoDocumento()==null) || 
             (this.tipoDocumento!=null &&
              this.tipoDocumento.equals(other.getTipoDocumento()))) &&
            this.allegato == other.isAllegato() &&
            ((this.gruppoAllegati==null && other.getGruppoAllegati()==null) || 
             (this.gruppoAllegati!=null &&
              this.gruppoAllegati.equals(other.getGruppoAllegati()))) &&
            ((this.classificazionePrincipale==null && other.getClassificazionePrincipale()==null) || 
             (this.classificazionePrincipale!=null &&
              this.classificazionePrincipale.equals(other.getClassificazionePrincipale()))) &&
            ((this.propertiesDocumento==null && other.getPropertiesDocumento()==null) || 
             (this.propertiesDocumento!=null &&
              this.propertiesDocumento.equals(other.getPropertiesDocumento()))) &&
            ((this.propertiesClassificazione==null && other.getPropertiesClassificazione()==null) || 
             (this.propertiesClassificazione!=null &&
              this.propertiesClassificazione.equals(other.getPropertiesClassificazione()))) &&
            ((this.documentiFisici==null && other.getDocumentiFisici()==null) || 
             (this.documentiFisici!=null &&
              java.util.Arrays.equals(this.documentiFisici, other.getDocumentiFisici())));
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
        if (getParentFolderId() != null) {
            _hashCode += getParentFolderId().hashCode();
        }
        if (getTipoDocumento() != null) {
            _hashCode += getTipoDocumento().hashCode();
        }
        _hashCode += (isAllegato() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getGruppoAllegati() != null) {
            _hashCode += getGruppoAllegati().hashCode();
        }
        if (getClassificazionePrincipale() != null) {
            _hashCode += getClassificazionePrincipale().hashCode();
        }
        if (getPropertiesDocumento() != null) {
            _hashCode += getPropertiesDocumento().hashCode();
        }
        if (getPropertiesClassificazione() != null) {
            _hashCode += getPropertiesClassificazione().hashCode();
        }
        if (getDocumentiFisici() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentiFisici());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentiFisici(), i);
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
        new org.apache.axis.description.TypeDesc(DocumentoArchivisticoIRC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "DocumentoArchivisticoIRC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentFolderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parentFolderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allegato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allegato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gruppoAllegati");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gruppoAllegati"));
        elemField.setXmlType(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "GruppoAllegatiPropertiesType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classificazionePrincipale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classificazionePrincipale"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertiesDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertiesDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertiesType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertiesClassificazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertiesClassificazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertiesType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentiFisici");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documentiFisici"));
        elemField.setXmlType(new javax.xml.namespace.QName("documentservice.acaris.acta.doqui.it", "DocumentoFisicoIRC"));
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
