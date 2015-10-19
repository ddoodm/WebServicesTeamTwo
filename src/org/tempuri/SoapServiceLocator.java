/**
 * SoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class SoapServiceLocator extends org.apache.axis.client.Service implements org.tempuri.SoapService {

    public SoapServiceLocator() {
    }


    public SoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_LanguageService
    private java.lang.String BasicHttpBinding_LanguageService_address = "http://api.microsofttranslator.com/V2/soap.svc";

    public java.lang.String getBasicHttpBinding_LanguageServiceAddress() {
        return BasicHttpBinding_LanguageService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_LanguageServiceWSDDServiceName = "BasicHttpBinding_LanguageService";

    public java.lang.String getBasicHttpBinding_LanguageServiceWSDDServiceName() {
        return BasicHttpBinding_LanguageServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_LanguageServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_LanguageServiceWSDDServiceName = name;
    }

    public com.microsofttranslator.api.V2.LanguageService getBasicHttpBinding_LanguageService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_LanguageService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_LanguageService(endpoint);
    }

    public com.microsofttranslator.api.V2.LanguageService getBasicHttpBinding_LanguageService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.BasicHttpBinding_LanguageServiceStub _stub = new org.tempuri.BasicHttpBinding_LanguageServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_LanguageServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_LanguageServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_LanguageService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.microsofttranslator.api.V2.LanguageService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.BasicHttpBinding_LanguageServiceStub _stub = new org.tempuri.BasicHttpBinding_LanguageServiceStub(new java.net.URL(BasicHttpBinding_LanguageService_address), this);
                _stub.setPortName(getBasicHttpBinding_LanguageServiceWSDDServiceName());
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
        if ("BasicHttpBinding_LanguageService".equals(inputPortName)) {
            return getBasicHttpBinding_LanguageService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "SoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_LanguageService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_LanguageService".equals(portName)) {
            setBasicHttpBinding_LanguageServiceEndpointAddress(address);
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
