/**
 * LimammEnteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.topforweb.util.service.integration.svista;

import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;

public class LimammEnteServiceLocator extends Service implements LimammEnteService {

    public LimammEnteServiceLocator() {
    }


    public LimammEnteServiceLocator(EngineConfiguration config) {
        super(config);
    }

    public LimammEnteServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for limammEnte
    private String limammEnte_address = "http://tst-applogic.reteunitaria.piemonte.it/limammApplEnteWsfad2/services/limammEnte";
                                       

    public String getlimammEnteAddress() {
        return limammEnte_address;
    }

    // The WSDD service name defaults to the port name.
    private String limammEnteWSDDServiceName = "limammEnte";

    public String getlimammEnteWSDDServiceName() {
        return limammEnteWSDDServiceName;
    }

    public void setlimammEnteWSDDServiceName(String name) {
        limammEnteWSDDServiceName = name;
    }

    public LimammEnte_PortType getlimammEnte() throws ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(limammEnte_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new ServiceException(e);
        }
        return getlimammEnte(endpoint);
    }

    public LimammEnte_PortType getlimammEnte(java.net.URL portAddress) throws ServiceException {
        try {
            LimammEnteSoapBindingStub _stub = new LimammEnteSoapBindingStub(portAddress, this);
            _stub.setPortName(getlimammEnteWSDDServiceName());
            return _stub;
        }
        catch (AxisFault e) {
            return null;
        }
    }

    public void setlimammEnteEndpointAddress(String address) {
        limammEnte_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
        try {
            if (LimammEnte_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                LimammEnteSoapBindingStub _stub = new LimammEnteSoapBindingStub(new URL(limammEnte_address), this);
                _stub.setPortName(getlimammEnteWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new ServiceException(t);
        }
        throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("limammEnte".equals(inputPortName)) {
            return getlimammEnte();
        }
        else  {
            Remote _stub = getPort(serviceEndpointInterface);
            ((Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public QName getServiceName() {
        return new QName("ente", "limammEnteService");
    }

    private HashSet<QName> ports = null;

    public Iterator<QName> getPorts() {
        if (ports == null) {
            ports = new HashSet<QName>();
            ports.add(new QName("ente", "limammEnte"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws ServiceException {
        
if ("limammEnte".equals(portName)) {
            setlimammEnteEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(QName portName, String address) throws ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
