/**
 * SMSServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.smsservice;

import it.csi.taif.taifweb.util.service.integration.acta.documentservice.DocumentoFisicoIRC;
import it.csi.taif.taifweb.util.service.integration.acta.sms.DestinatarioConNoteType;
import it.csi.taif.taifweb.util.service.integration.acta.sms.DestinatarioType;
import it.csi.taif.taifweb.util.service.integration.acta.sms.InfoCreazioneType;
import it.csi.taif.taifweb.util.service.integration.acta.sms.MittenteType;
import it.csi.taif.taifweb.util.service.integration.acta.sms.OggettoSmistamentoType;

public interface SMSServicePort extends java.rmi.Remote {
    public it.csi.taif.taifweb.util.service.integration.acta.common.IdSmistamentoType creaSmistamento(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, MittenteType mittente, DestinatarioType[] destinatari, OggettoSmistamentoType[] oggettiSmistati, InfoCreazioneType infoCreazione) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
    public it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType query(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.QueryableObjectType target, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter, it.csi.taif.taifweb.util.service.integration.acta.common.QueryConditionType[] criteria, it.csi.taif.taifweb.util.service.integration.acta.common.NavigationConditionInfoType navigationLimits, java.lang.Integer maxItems, java.lang.Integer skipCount) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
    public void completaSmistamentoFirmaDwd(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, long idSmistamentoMittente, long idAoo, java.util.Calendar dataUltimoFirmatario, long idUtenteUltimoFirmatario, long idNodoUltimoDestinatario, DocumentoFisicoIRC docFisicoPrincipale, DocumentoFisicoIRC[] docFisiciAllegati, DestinatarioConNoteType[] destinatari, boolean firmaAncheAllegati) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
    public void annullaSmistamentoFirmaDwd(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, long idSmistamentoMittente, java.util.Calendar dataRifiuto, long idUtenteRifiuto, DestinatarioConNoteType[] destinatariCompletati, DestinatarioConNoteType destinatarioRifiuta) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
}
