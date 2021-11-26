/**
 * FascicoloStandardType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.archive;

public class FascicoloStandardType  extends FolderPropertiesType  implements java.io.Serializable {
    private IdFascicoloStandardType idFascicoloStandard;

    private java.lang.String codice;

    private java.lang.String descrizione;

    public FascicoloStandardType() {
    }

    public FascicoloStandardType(
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId,
           it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType changeToken,
           java.lang.String objectTypeId,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType parentId,
           java.lang.String[] allowedChildObjectTypeIds,
           IdFascicoloStandardType idFascicoloStandard,
           java.lang.String codice,
           java.lang.String descrizione) {
        super(
            objectId,
            changeToken,
            objectTypeId,
            parentId,
            allowedChildObjectTypeIds);
        this.idFascicoloStandard = idFascicoloStandard;
        this.codice = codice;
        this.descrizione = descrizione;
    }


    /**
     * Gets the idFascicoloStandard value for this FascicoloStandardType.
     * 
     * @return idFascicoloStandard
     */
    public IdFascicoloStandardType getIdFascicoloStandard() {
        return idFascicoloStandard;
    }


    /**
     * Sets the idFascicoloStandard value for this FascicoloStandardType.
     * 
     * @param idFascicoloStandard
     */
    public void setIdFascicoloStandard(IdFascicoloStandardType idFascicoloStandard) {
        this.idFascicoloStandard = idFascicoloStandard;
    }


    /**
     * Gets the codice value for this FascicoloStandardType.
     * 
     * @return codice
     */
    public java.lang.String getCodice() {
        return codice;
    }


    /**
     * Sets the codice value for this FascicoloStandardType.
     * 
     * @param codice
     */
    public void setCodice(java.lang.String codice) {
        this.codice = codice;
    }


    /**
     * Gets the descrizione value for this FascicoloStandardType.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this FascicoloStandardType.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FascicoloStandardType)) return false;
        FascicoloStandardType other = (FascicoloStandardType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.idFascicoloStandard==null && other.getIdFascicoloStandard()==null) || 
             (this.idFascicoloStandard!=null &&
              this.idFascicoloStandard.equals(other.getIdFascicoloStandard()))) &&
            ((this.codice==null && other.getCodice()==null) || 
             (this.codice!=null &&
              this.codice.equals(other.getCodice()))) &&
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione())));
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
        if (getIdFascicoloStandard() != null) {
            _hashCode += getIdFascicoloStandard().hashCode();
        }
        if (getCodice() != null) {
            _hashCode += getCodice().hashCode();
        }
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FascicoloStandardType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "FascicoloStandardType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFascicoloStandard");
        elemField.setXmlName(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "idFascicoloStandard"));
        elemField.setXmlType(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "IdFascicoloStandardType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codice");
        elemField.setXmlName(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "codice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "descrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
