/**
 * SoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface SoapService extends javax.xml.rpc.Service {
    public java.lang.String getBasicHttpBinding_LanguageServiceAddress();

    public com.microsofttranslator.api.V2.LanguageService getBasicHttpBinding_LanguageService() throws javax.xml.rpc.ServiceException;

    public com.microsofttranslator.api.V2.LanguageService getBasicHttpBinding_LanguageService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
