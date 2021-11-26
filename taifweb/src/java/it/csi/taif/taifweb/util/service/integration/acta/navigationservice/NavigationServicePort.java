/**
 * NavigationServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.navigationservice;

public interface NavigationServicePort extends java.rmi.Remote {
    public it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType getDescendants(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType folderId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, java.lang.Integer depth, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter, java.lang.Integer maxItems, java.lang.Integer skipCount) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
    public it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType getChildren(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType folderId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter, java.lang.Integer maxItems, java.lang.Integer skipCount) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType getFolderParent(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType folderId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType[] getObjectParents(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
}
