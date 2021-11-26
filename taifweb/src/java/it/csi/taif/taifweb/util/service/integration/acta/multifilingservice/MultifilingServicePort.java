/**
 * MultifilingServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.multifilingservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ItemType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;
import it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType;
import it.csi.taif.taifweb.util.service.integration.acta.common.PropertiesType;

public interface MultifilingServicePort extends java.rmi.Remote {
    public void addAssociativeObjectToFolder(ObjectIdType repositoryId, ObjectIdType objectId, PrincipalIdType principalId, ObjectIdType folderId, java.lang.String associativeObjectTypeId, PropertiesType associativeObjectProperties) throws java.rmi.RemoteException, AcarisFaultType;
    public ObjectIdType aggiungiClassificazione(ObjectIdType repositoryId, PrincipalIdType principalId, ObjectIdType classificazioneDiPartenzaId, ObjectIdType folderId, ItemType[] params) throws java.rmi.RemoteException, AcarisFaultType;
}
