/**
 * ReviewSOAPServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uts.wsd.teamtwo.soap.client;

public class ReviewSOAPServiceLocator extends org.apache.axis.client.Service implements uts.wsd.teamtwo.soap.client.ReviewSOAPService {

    public ReviewSOAPServiceLocator() {
    }


    public ReviewSOAPServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ReviewSOAPServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ReviewSOAPPort
    private java.lang.String ReviewSOAPPort_address = "http://localhost:8080/WebServicesTeamTwo/soap/reviews";

    public java.lang.String getReviewSOAPPortAddress() {
        return ReviewSOAPPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ReviewSOAPPortWSDDServiceName = "ReviewSOAPPort";

    public java.lang.String getReviewSOAPPortWSDDServiceName() {
        return ReviewSOAPPortWSDDServiceName;
    }

    public void setReviewSOAPPortWSDDServiceName(java.lang.String name) {
        ReviewSOAPPortWSDDServiceName = name;
    }

    public uts.wsd.teamtwo.soap.client.ReviewSOAP getReviewSOAPPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ReviewSOAPPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getReviewSOAPPort(endpoint);
    }

    public uts.wsd.teamtwo.soap.client.ReviewSOAP getReviewSOAPPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uts.wsd.teamtwo.soap.client.ReviewSOAPPortBindingStub _stub = new uts.wsd.teamtwo.soap.client.ReviewSOAPPortBindingStub(portAddress, this);
            _stub.setPortName(getReviewSOAPPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setReviewSOAPPortEndpointAddress(java.lang.String address) {
        ReviewSOAPPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uts.wsd.teamtwo.soap.client.ReviewSOAP.class.isAssignableFrom(serviceEndpointInterface)) {
                uts.wsd.teamtwo.soap.client.ReviewSOAPPortBindingStub _stub = new uts.wsd.teamtwo.soap.client.ReviewSOAPPortBindingStub(new java.net.URL(ReviewSOAPPort_address), this);
                _stub.setPortName(getReviewSOAPPortWSDDServiceName());
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
        if ("ReviewSOAPPort".equals(inputPortName)) {
            return getReviewSOAPPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.teamtwo.wsd.uts/", "ReviewSOAPService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.teamtwo.wsd.uts/", "ReviewSOAPPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ReviewSOAPPort".equals(portName)) {
            setReviewSOAPPortEndpointAddress(address);
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
