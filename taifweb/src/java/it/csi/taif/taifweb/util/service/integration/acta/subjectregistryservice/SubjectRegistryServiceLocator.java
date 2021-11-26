/**
 * SubjectRegistryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class SubjectRegistryServiceLocator extends org.apache.axis.client.Service implements SubjectRegistryService {

    public SubjectRegistryServiceLocator() {
    }


    public SubjectRegistryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SubjectRegistryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SubjectRegistryServicePort
    private java.lang.String SubjectRegistryServicePort_address = "http://tst-applogic.reteunitaria.piemonte.it/actasrv/subjectregistryWS";

    public java.lang.String getSubjectRegistryServicePortAddress() {
        return SubjectRegistryServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SubjectRegistryServicePortWSDDServiceName = "SubjectRegistryServicePort";

    public java.lang.String getSubjectRegistryServicePortWSDDServiceName() {
        return SubjectRegistryServicePortWSDDServiceName;
    }

    public void setSubjectRegistryServicePortWSDDServiceName(java.lang.String name) {
        SubjectRegistryServicePortWSDDServiceName = name;
    }

    public SubjectRegistryServicePort getSubjectRegistryServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SubjectRegistryServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSubjectRegistryServicePort(endpoint);
    }

    public SubjectRegistryServicePort getSubjectRegistryServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SubjectRegistryServiceBindingStub _stub = new SubjectRegistryServiceBindingStub(portAddress, this);
            _stub.setPortName(getSubjectRegistryServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSubjectRegistryServicePortEndpointAddress(java.lang.String address) {
        SubjectRegistryServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (SubjectRegistryServicePort.class.isAssignableFrom(serviceEndpointInterface)) {
                SubjectRegistryServiceBindingStub _stub = new SubjectRegistryServiceBindingStub(new java.net.URL(SubjectRegistryServicePort_address), this);
                _stub.setPortName(getSubjectRegistryServicePortWSDDServiceName());
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
        if ("SubjectRegistryServicePort".equals(inputPortName)) {
            return getSubjectRegistryServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "SubjectRegistryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "SubjectRegistryServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SubjectRegistryServicePort".equals(portName)) {
            setSubjectRegistryServicePortEndpointAddress(address);
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
