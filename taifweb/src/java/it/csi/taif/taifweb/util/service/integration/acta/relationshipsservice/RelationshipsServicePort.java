/**
 * RelationshipsServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.relationshipsservice;

import it.csi.taif.taifweb.util.service.integration.acta.archive.RelationshipPropertiesType;

public interface RelationshipsServicePort extends java.rmi.Remote {
    public RelationshipPropertiesType[] getObjectRelationships(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId, java.lang.String typeId, java.lang.String direction, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
}
