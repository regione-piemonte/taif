/**
 * AnagraficaGenerica.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class AnagraficaGenerica  implements java.io.Serializable {
    private java.lang.String tipoAnagrafica;

    private java.lang.String codiceFonte;

    private java.lang.String descrizioneFonte;

    private java.lang.String chiaveEsterna;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId;

    private java.lang.Long dbKey;

    private java.lang.String codiceFiscale;

    private java.lang.String nome;

    private java.lang.String cognome;

    private java.lang.String partitaIva;

    private java.lang.String denominazione;

    private java.lang.Long idStatoSoggetto;

    private java.lang.String descStatoSoggetto;

    public AnagraficaGenerica() {
    }

    public AnagraficaGenerica(
           java.lang.String tipoAnagrafica,
           java.lang.String codiceFonte,
           java.lang.String descrizioneFonte,
           java.lang.String chiaveEsterna,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId,
           java.lang.Long dbKey,
           java.lang.String codiceFiscale,
           java.lang.String nome,
           java.lang.String cognome,
           java.lang.String partitaIva,
           java.lang.String denominazione,
           java.lang.Long idStatoSoggetto,
           java.lang.String descStatoSoggetto) {
           this.tipoAnagrafica = tipoAnagrafica;
           this.codiceFonte = codiceFonte;
           this.descrizioneFonte = descrizioneFonte;
           this.chiaveEsterna = chiaveEsterna;
           this.objectId = objectId;
           this.dbKey = dbKey;
           this.codiceFiscale = codiceFiscale;
           this.nome = nome;
           this.cognome = cognome;
           this.partitaIva = partitaIva;
           this.denominazione = denominazione;
           this.idStatoSoggetto = idStatoSoggetto;
           this.descStatoSoggetto = descStatoSoggetto;
    }


    /**
     * Gets the tipoAnagrafica value for this AnagraficaGenerica.
     * 
     * @return tipoAnagrafica
     */
    public java.lang.String getTipoAnagrafica() {
        return tipoAnagrafica;
    }


    /**
     * Sets the tipoAnagrafica value for this AnagraficaGenerica.
     * 
     * @param tipoAnagrafica
     */
    public void setTipoAnagrafica(java.lang.String tipoAnagrafica) {
        this.tipoAnagrafica = tipoAnagrafica;
    }


    /**
     * Gets the codiceFonte value for this AnagraficaGenerica.
     * 
     * @return codiceFonte
     */
    public java.lang.String getCodiceFonte() {
        return codiceFonte;
    }


    /**
     * Sets the codiceFonte value for this AnagraficaGenerica.
     * 
     * @param codiceFonte
     */
    public void setCodiceFonte(java.lang.String codiceFonte) {
        this.codiceFonte = codiceFonte;
    }


    /**
     * Gets the descrizioneFonte value for this AnagraficaGenerica.
     * 
     * @return descrizioneFonte
     */
    public java.lang.String getDescrizioneFonte() {
        return descrizioneFonte;
    }


    /**
     * Sets the descrizioneFonte value for this AnagraficaGenerica.
     * 
     * @param descrizioneFonte
     */
    public void setDescrizioneFonte(java.lang.String descrizioneFonte) {
        this.descrizioneFonte = descrizioneFonte;
    }


    /**
     * Gets the chiaveEsterna value for this AnagraficaGenerica.
     * 
     * @return chiaveEsterna
     */
    public java.lang.String getChiaveEsterna() {
        return chiaveEsterna;
    }


    /**
     * Sets the chiaveEsterna value for this AnagraficaGenerica.
     * 
     * @param chiaveEsterna
     */
    public void setChiaveEsterna(java.lang.String chiaveEsterna) {
        this.chiaveEsterna = chiaveEsterna;
    }


    /**
     * Gets the objectId value for this AnagraficaGenerica.
     * 
     * @return objectId
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getObjectId() {
        return objectId;
    }


    /**
     * Sets the objectId value for this AnagraficaGenerica.
     * 
     * @param objectId
     */
    public void setObjectId(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId) {
        this.objectId = objectId;
    }


    /**
     * Gets the dbKey value for this AnagraficaGenerica.
     * 
     * @return dbKey
     */
    public java.lang.Long getDbKey() {
        return dbKey;
    }


    /**
     * Sets the dbKey value for this AnagraficaGenerica.
     * 
     * @param dbKey
     */
    public void setDbKey(java.lang.Long dbKey) {
        this.dbKey = dbKey;
    }


    /**
     * Gets the codiceFiscale value for this AnagraficaGenerica.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this AnagraficaGenerica.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the nome value for this AnagraficaGenerica.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this AnagraficaGenerica.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the cognome value for this AnagraficaGenerica.
     * 
     * @return cognome
     */
    public java.lang.String getCognome() {
        return cognome;
    }


    /**
     * Sets the cognome value for this AnagraficaGenerica.
     * 
     * @param cognome
     */
    public void setCognome(java.lang.String cognome) {
        this.cognome = cognome;
    }


    /**
     * Gets the partitaIva value for this AnagraficaGenerica.
     * 
     * @return partitaIva
     */
    public java.lang.String getPartitaIva() {
        return partitaIva;
    }


    /**
     * Sets the partitaIva value for this AnagraficaGenerica.
     * 
     * @param partitaIva
     */
    public void setPartitaIva(java.lang.String partitaIva) {
        this.partitaIva = partitaIva;
    }


    /**
     * Gets the denominazione value for this AnagraficaGenerica.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this AnagraficaGenerica.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the idStatoSoggetto value for this AnagraficaGenerica.
     * 
     * @return idStatoSoggetto
     */
    public java.lang.Long getIdStatoSoggetto() {
        return idStatoSoggetto;
    }


    /**
     * Sets the idStatoSoggetto value for this AnagraficaGenerica.
     * 
     * @param idStatoSoggetto
     */
    public void setIdStatoSoggetto(java.lang.Long idStatoSoggetto) {
        this.idStatoSoggetto = idStatoSoggetto;
    }


    /**
     * Gets the descStatoSoggetto value for this AnagraficaGenerica.
     * 
     * @return descStatoSoggetto
     */
    public java.lang.String getDescStatoSoggetto() {
        return descStatoSoggetto;
    }


    /**
     * Sets the descStatoSoggetto value for this AnagraficaGenerica.
     * 
     * @param descStatoSoggetto
     */
    public void setDescStatoSoggetto(java.lang.String descStatoSoggetto) {
        this.descStatoSoggetto = descStatoSoggetto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnagraficaGenerica)) return false;
        AnagraficaGenerica other = (AnagraficaGenerica) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipoAnagrafica==null && other.getTipoAnagrafica()==null) || 
             (this.tipoAnagrafica!=null &&
              this.tipoAnagrafica.equals(other.getTipoAnagrafica()))) &&
            ((this.codiceFonte==null && other.getCodiceFonte()==null) || 
             (this.codiceFonte!=null &&
              this.codiceFonte.equals(other.getCodiceFonte()))) &&
            ((this.descrizioneFonte==null && other.getDescrizioneFonte()==null) || 
             (this.descrizioneFonte!=null &&
              this.descrizioneFonte.equals(other.getDescrizioneFonte()))) &&
            ((this.chiaveEsterna==null && other.getChiaveEsterna()==null) || 
             (this.chiaveEsterna!=null &&
              this.chiaveEsterna.equals(other.getChiaveEsterna()))) &&
            ((this.objectId==null && other.getObjectId()==null) || 
             (this.objectId!=null &&
              this.objectId.equals(other.getObjectId()))) &&
            ((this.dbKey==null && other.getDbKey()==null) || 
             (this.dbKey!=null &&
              this.dbKey.equals(other.getDbKey()))) &&
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) || 
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.cognome==null && other.getCognome()==null) || 
             (this.cognome!=null &&
              this.cognome.equals(other.getCognome()))) &&
            ((this.partitaIva==null && other.getPartitaIva()==null) || 
             (this.partitaIva!=null &&
              this.partitaIva.equals(other.getPartitaIva()))) &&
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione()))) &&
            ((this.idStatoSoggetto==null && other.getIdStatoSoggetto()==null) || 
             (this.idStatoSoggetto!=null &&
              this.idStatoSoggetto.equals(other.getIdStatoSoggetto()))) &&
            ((this.descStatoSoggetto==null && other.getDescStatoSoggetto()==null) || 
             (this.descStatoSoggetto!=null &&
              this.descStatoSoggetto.equals(other.getDescStatoSoggetto())));
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
        if (getTipoAnagrafica() != null) {
            _hashCode += getTipoAnagrafica().hashCode();
        }
        if (getCodiceFonte() != null) {
            _hashCode += getCodiceFonte().hashCode();
        }
        if (getDescrizioneFonte() != null) {
            _hashCode += getDescrizioneFonte().hashCode();
        }
        if (getChiaveEsterna() != null) {
            _hashCode += getChiaveEsterna().hashCode();
        }
        if (getObjectId() != null) {
            _hashCode += getObjectId().hashCode();
        }
        if (getDbKey() != null) {
            _hashCode += getDbKey().hashCode();
        }
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getCognome() != null) {
            _hashCode += getCognome().hashCode();
        }
        if (getPartitaIva() != null) {
            _hashCode += getPartitaIva().hashCode();
        }
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        if (getIdStatoSoggetto() != null) {
            _hashCode += getIdStatoSoggetto().hashCode();
        }
        if (getDescStatoSoggetto() != null) {
            _hashCode += getDescStatoSoggetto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AnagraficaGenerica.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "AnagraficaGenerica"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoAnagrafica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoAnagrafica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFonte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFonte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneFonte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descrizioneFonte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chiaveEsterna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chiaveEsterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dbKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cognome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cognome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partitaIva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partitaIva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idStatoSoggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idStatoSoggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descStatoSoggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descStatoSoggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
