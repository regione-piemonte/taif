/**
 * SMSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.smsservice;

public interface SMSService extends javax.xml.rpc.Service {
    public java.lang.String getSMSServicePortAddress();

    public SMSServicePort getSMSServicePort() throws javax.xml.rpc.ServiceException;

    public SMSServicePort getSMSServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
