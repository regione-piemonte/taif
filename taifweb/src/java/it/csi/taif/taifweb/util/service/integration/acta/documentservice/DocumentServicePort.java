/**
 * DocumentServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.documentservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.AcarisContentStreamType;
import it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType;
import it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType;
import it.csi.taif.taifweb.util.service.integration.acta.common.PropertiesType;
import it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType;

public interface DocumentServicePort extends java.rmi.Remote {
    public IdentificatoreDocumento creaDocumento(ObjectIdType repositoryId, PrincipalIdType principalId, java.lang.String tipoOperazione, InfoRichiestaCreazione datiCreazione) throws java.rmi.RemoteException, AcarisFaultType;
    public MappaIdentificazioneDocumento getRappresentazioneDocumento(ObjectIdType repositoryId, PrincipalIdType principalId, IdentificatoreDocumento puntoDiPartenza, boolean recuperaAscendenza) throws java.rmi.RemoteException, AcarisFaultType;
    public ObjectResponseType[] getPropertiesMassive(ObjectIdType repositoryId, PrincipalIdType principalId, ObjectIdType[] identifiers, PropertyFilterType filter) throws java.rmi.RemoteException, AcarisFaultType;
    public IdentificazioneTrasformazione[] trasformaDocumentoPlaceholderInDocumentoElettronico(ObjectIdType repositoryId, PrincipalIdType principalId, ObjectIdType classificazioneId, ObjectIdType registrazioneId, InfoRichiestaTrasformazione infoRichiesta, DocumentoFisicoIRC[] documentoFisico) throws java.rmi.RemoteException, AcarisFaultType;
    public ObjectIdType creaDocumentoFisicoInDocumentRoot(ObjectIdType repositoryId, java.lang.String typeId, java.lang.String associativeObjectTypeId, PrincipalIdType principalId, PropertiesType properties, PropertiesType associativeObjectProperties, ObjectIdType folderId, AcarisContentStreamType contentStream) throws java.rmi.RemoteException, AcarisFaultType;
    public ObjectIdType uploadContenutoFisico(ObjectIdType repositoryId, PrincipalIdType principalId, AcarisContentStreamType contFisico) throws java.rmi.RemoteException, AcarisFaultType;
}
