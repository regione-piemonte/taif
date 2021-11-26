/**
 * MultifilingServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.multifilingservice;

public class MultifilingServiceLocator extends org.apache.axis.client.Service implements MultifilingService {

    public MultifilingServiceLocator() {
    }


    public MultifilingServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MultifilingServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MultifilingServicePort
    private java.lang.String MultifilingServicePort_address = "http://tst-applogic.reteunitaria.piemonte.it/actasrv/multifillingWS";

    public java.lang.String getMultifilingServicePortAddress() {
        return MultifilingServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MultifilingServicePortWSDDServiceName = "MultifilingServicePort";

    public java.lang.String getMultifilingServicePortWSDDServiceName() {
        return MultifilingServicePortWSDDServiceName;
    }

    public void setMultifilingServicePortWSDDServiceName(java.lang.String name) {
        MultifilingServicePortWSDDServiceName = name;
    }

    public MultifilingServicePort getMultifilingServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MultifilingServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMultifilingServicePort(endpoint);
    }

    public MultifilingServicePort getMultifilingServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            MultifilingServiceBindingStub _stub = new MultifilingServiceBindingStub(portAddress, this);
            _stub.setPortName(getMultifilingServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMultifilingServicePortEndpointAddress(java.lang.String address) {
        MultifilingServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (MultifilingServicePort.class.isAssignableFrom(serviceEndpointInterface)) {
                MultifilingServiceBindingStub _stub = new MultifilingServiceBindingStub(new java.net.URL(MultifilingServicePort_address), this);
                _stub.setPortName(getMultifilingServicePortWSDDServiceName());
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
        if ("MultifilingServicePort".equals(inputPortName)) {
            return getMultifilingServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("multifilingservice.acaris.acta.doqui.it", "MultifilingService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("multifilingservice.acaris.acta.doqui.it", "MultifilingServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MultifilingServicePort".equals(portName)) {
            setMultifilingServicePortEndpointAddress(address);
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
