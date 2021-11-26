/**
 * FascicoloRealeLegislaturaPropertiesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.archive;

public class FascicoloRealeLegislaturaPropertiesType  extends FascicoloRealePropertiesType  implements java.io.Serializable {
    private java.lang.String legislatura;

    public FascicoloRealeLegislaturaPropertiesType() {
    }

    public FascicoloRealeLegislaturaPropertiesType(
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId,
           it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType changeToken,
           java.lang.String objectTypeId,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType parentId,
           java.lang.String[] allowedChildObjectTypeIds,
           java.lang.String codice,
           java.lang.String descrizione,
           java.lang.String indiceDiClassificazioneEsteso,
           java.util.Date dataCreazione,
           java.util.Date dataInizio,
           java.util.Date dataFine,
           int conservazioneCorrente,
           int conservazioneGenerale,
           java.util.Date dataPassaggioInDeposito,
           java.util.Date dataBloccoPassaggioInDeposito,
           java.util.Date dataSbloccoPassaggioInDeposito,
           java.util.Date dataScarto,
           boolean archivioCorrente,
           boolean datiPersonali,
           boolean datiSensibili,
           boolean datiRiservati,
           java.lang.String collocazioneCartaceo,
           java.lang.String paroleChiave,
           java.util.Date dataUltimaModifica,
           java.util.Date dataCancellazione,
           java.util.Date dataEsportazione,
           java.lang.String estremiProvvedimentoDiScarto,
           it.csi.taif.taifweb.util.service.integration.acta.common.CodiceFiscaleType utenteCreazione,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idDeposito,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdMovimentazioneType[] idMovimentazioneList,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdAnnotazioniType[] idAnnotazioniList,
           int idTipoClasse,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdAOOType idAOORespMat,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdAOOType idAOORespCons,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdStrutturaType idStrutturaRespMat,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdStrutturaType idStrutturaRespCons,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdNodoType idNodoRespMat,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdNodoType idNodoRespCons,
           int anno,
           java.lang.String numero,
           java.lang.String oggetto,
           java.lang.String soggetto,
           boolean creatoFascStd,
           boolean modificatoFascStd,
           int numeroInterno,
           it.csi.taif.taifweb.util.service.integration.acta.common.IdVitalRecordCodeType idVitalRecordCode,
           IdFascicoloStandardType idFascicoloStdRiferimento,
           java.lang.String stato,
           java.lang.String legislatura) {
        super(
            objectId,
            changeToken,
            objectTypeId,
            parentId,
            allowedChildObjectTypeIds,
            codice,
            descrizione,
            indiceDiClassificazioneEsteso,
            dataCreazione,
            dataInizio,
            dataFine,
            conservazioneCorrente,
            conservazioneGenerale,
            dataPassaggioInDeposito,
            dataBloccoPassaggioInDeposito,
            dataSbloccoPassaggioInDeposito,
            dataScarto,
            archivioCorrente,
            datiPersonali,
            datiSensibili,
            datiRiservati,
            collocazioneCartaceo,
            paroleChiave,
            dataUltimaModifica,
            dataCancellazione,
            dataEsportazione,
            estremiProvvedimentoDiScarto,
            utenteCreazione,
            idDeposito,
            idMovimentazioneList,
            idAnnotazioniList,
            idTipoClasse,
            idAOORespMat,
            idAOORespCons,
            idStrutturaRespMat,
            idStrutturaRespCons,
            idNodoRespMat,
            idNodoRespCons,
            anno,
            numero,
            oggetto,
            soggetto,
            creatoFascStd,
            modificatoFascStd,
            numeroInterno,
            idVitalRecordCode,
            idFascicoloStdRiferimento,
            stato);
        this.legislatura = legislatura;
    }


    /**
     * Gets the legislatura value for this FascicoloRealeLegislaturaPropertiesType.
     * 
     * @return legislatura
     */
    public java.lang.String getLegislatura() {
        return legislatura;
    }


    /**
     * Sets the legislatura value for this FascicoloRealeLegislaturaPropertiesType.
     * 
     * @param legislatura
     */
    public void setLegislatura(java.lang.String legislatura) {
        this.legislatura = legislatura;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FascicoloRealeLegislaturaPropertiesType)) return false;
        FascicoloRealeLegislaturaPropertiesType other = (FascicoloRealeLegislaturaPropertiesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.legislatura==null && other.getLegislatura()==null) || 
             (this.legislatura!=null &&
              this.legislatura.equals(other.getLegislatura())));
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
        if (getLegislatura() != null) {
            _hashCode += getLegislatura().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FascicoloRealeLegislaturaPropertiesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "FascicoloRealeLegislaturaPropertiesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("legislatura");
        elemField.setXmlName(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "legislatura"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
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
