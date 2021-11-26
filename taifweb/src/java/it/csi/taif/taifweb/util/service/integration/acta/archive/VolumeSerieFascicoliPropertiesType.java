/**
 * VolumeSerieFascicoliPropertiesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.archive;

public class VolumeSerieFascicoliPropertiesType  extends VolumePropertiesType  implements java.io.Serializable {
    public VolumeSerieFascicoliPropertiesType() {
    }

    public VolumeSerieFascicoliPropertiesType(
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
           java.lang.String intervalloNumericoDa,
           java.lang.String intervalloNumericoA,
           java.lang.String stato) {
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
            intervalloNumericoDa,
            intervalloNumericoA,
            stato);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VolumeSerieFascicoliPropertiesType)) return false;
        VolumeSerieFascicoliPropertiesType other = (VolumeSerieFascicoliPropertiesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VolumeSerieFascicoliPropertiesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("archive.acaris.acta.doqui.it", "VolumeSerieFascicoliPropertiesType"));
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
