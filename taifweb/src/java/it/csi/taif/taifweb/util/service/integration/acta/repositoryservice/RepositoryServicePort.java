/**
 * RepositoryServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.repositoryservice;

import it.csi.taif.taifweb.util.service.integration.acta.archive.AcarisRepositoryEntryType;
import it.csi.taif.taifweb.util.service.integration.acta.archive.AcarisRepositoryInfoType;

public interface RepositoryServicePort extends java.rmi.Remote {
    public AcarisRepositoryEntryType[] getRepositories() throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
    public AcarisRepositoryInfoType getRepositoryInfo(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
}
