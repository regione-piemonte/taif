/**
 * RepositoryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.repositoryservice;

public class RepositoryServiceLocator extends org.apache.axis.client.Service implements RepositoryService {

    public RepositoryServiceLocator() {
    }


    public RepositoryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RepositoryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RepositoryServicePort
    private java.lang.String RepositoryServicePort_address = "http://tst-applogic.reteunitaria.piemonte.it/actasrv/repositoryWS";

    public java.lang.String getRepositoryServicePortAddress() {
        return RepositoryServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RepositoryServicePortWSDDServiceName = "RepositoryServicePort";

    public java.lang.String getRepositoryServicePortWSDDServiceName() {
        return RepositoryServicePortWSDDServiceName;
    }

    public void setRepositoryServicePortWSDDServiceName(java.lang.String name) {
        RepositoryServicePortWSDDServiceName = name;
    }

    public RepositoryServicePort getRepositoryServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RepositoryServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRepositoryServicePort(endpoint);
    }

    public RepositoryServicePort getRepositoryServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            RepositoryServiceBindingStub _stub = new RepositoryServiceBindingStub(portAddress, this);
            _stub.setPortName(getRepositoryServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRepositoryServicePortEndpointAddress(java.lang.String address) {
        RepositoryServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (RepositoryServicePort.class.isAssignableFrom(serviceEndpointInterface)) {
                RepositoryServiceBindingStub _stub = new RepositoryServiceBindingStub(new java.net.URL(RepositoryServicePort_address), this);
                _stub.setPortName(getRepositoryServicePortWSDDServiceName());
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
        if ("RepositoryServicePort".equals(inputPortName)) {
            return getRepositoryServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("repositoryservice.acaris.acta.doqui.it", "RepositoryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("repositoryservice.acaris.acta.doqui.it", "RepositoryServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RepositoryServicePort".equals(portName)) {
            setRepositoryServicePortEndpointAddress(address);
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
