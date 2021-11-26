/**
 * LimammEnteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.topforweb.util.service.integration.svista;

import java.net.URL;

import javax.xml.rpc.Service;

public interface LimammEnteService extends Service {
    public String getlimammEnteAddress();

    public LimammEnte_PortType getlimammEnte() throws javax.xml.rpc.ServiceException;

    public LimammEnte_PortType getlimammEnte(URL portAddress) throws javax.xml.rpc.ServiceException;
}
