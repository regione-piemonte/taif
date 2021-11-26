/**
 * ManagementServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.managementservice;

import it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType;
import it.csi.taif.taifweb.util.service.integration.acta.common.AnnotazioniPropertiesType;
import it.csi.taif.taifweb.util.service.integration.acta.common.IdAnnotazioniType;
import it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType;
import it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType;
import it.csi.taif.taifweb.util.service.integration.acta.management.VitalRecordCodeType;

public interface ManagementServicePort extends java.rmi.Remote {
    public VitalRecordCodeType[] getVitalRecordCode(ObjectIdType repositoryId) throws java.rmi.RemoteException, AcarisFaultType;
    public IdAnnotazioniType addAnnotazioni(ObjectIdType repositoryId, ObjectIdType objectId, PrincipalIdType principalId, AnnotazioniPropertiesType annotazioni) throws java.rmi.RemoteException, AcarisFaultType;
}
