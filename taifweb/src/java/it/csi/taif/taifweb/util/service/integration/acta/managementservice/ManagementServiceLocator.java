/**
 * ManagementServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.managementservice;

public class ManagementServiceLocator extends org.apache.axis.client.Service implements ManagementService {

    public ManagementServiceLocator() {
    }


    public ManagementServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ManagementServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ManagementServicePort
    private java.lang.String ManagementServicePort_address = "http://tst-applogic.reteunitaria.piemonte.it/actasrv/managementWS";

    public java.lang.String getManagementServicePortAddress() {
        return ManagementServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ManagementServicePortWSDDServiceName = "ManagementServicePort";

    public java.lang.String getManagementServicePortWSDDServiceName() {
        return ManagementServicePortWSDDServiceName;
    }

    public void setManagementServicePortWSDDServiceName(java.lang.String name) {
        ManagementServicePortWSDDServiceName = name;
    }

    public ManagementServicePort getManagementServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ManagementServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getManagementServicePort(endpoint);
    }

    public ManagementServicePort getManagementServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ManagementServiceBindingStub _stub = new ManagementServiceBindingStub(portAddress, this);
            _stub.setPortName(getManagementServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setManagementServicePortEndpointAddress(java.lang.String address) {
        ManagementServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ManagementServicePort.class.isAssignableFrom(serviceEndpointInterface)) {
                ManagementServiceBindingStub _stub = new ManagementServiceBindingStub(new java.net.URL(ManagementServicePort_address), this);
                _stub.setPortName(getManagementServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ManagementServicePort".equals(inputPortName)) {
            return getManagementServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("managementservice.acaris.acta.doqui.it", "ManagementService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("managementservice.acaris.acta.doqui.it", "ManagementServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ManagementServicePort".equals(portName)) {
            setManagementServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
