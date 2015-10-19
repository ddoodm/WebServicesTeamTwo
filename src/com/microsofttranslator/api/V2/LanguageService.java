/**
 * LanguageService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsofttranslator.api.V2;

public interface LanguageService extends java.rmi.Remote {
    public void addTranslation(java.lang.String appId, java.lang.String originalText, java.lang.String translatedText, java.lang.String from, java.lang.String to, java.lang.Integer rating, java.lang.String contentType, java.lang.String category, java.lang.String user, java.lang.String uri) throws java.rmi.RemoteException;
    public int[] breakSentences(java.lang.String appId, java.lang.String text, java.lang.String language) throws java.rmi.RemoteException;
    public java.lang.String detect(java.lang.String appId, java.lang.String text) throws java.rmi.RemoteException;
    public java.lang.String[] detectArray(java.lang.String appId, java.lang.String[] texts) throws java.rmi.RemoteException;
    public java.lang.String getAppIdToken(java.lang.String appId, java.lang.Integer minRatingRead, java.lang.Integer maxRatingWrite, java.lang.Integer expireSeconds) throws java.rmi.RemoteException;
    public java.lang.String[] getLanguageNames(java.lang.String appId, java.lang.String locale, java.lang.String[] languageCodes, java.lang.Boolean useSpokenVariant) throws java.rmi.RemoteException;
    public java.lang.String[] getLanguagesForSpeak(java.lang.String appId) throws java.rmi.RemoteException;
    public java.lang.String[] getLanguagesForTranslate(java.lang.String appId) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.GetTranslationsResponse getTranslations(java.lang.String appId, java.lang.String text, java.lang.String from, java.lang.String to, java.lang.Integer maxTranslations, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException;
    public java.lang.String translate(java.lang.String appId, java.lang.String text, java.lang.String from, java.lang.String to, java.lang.String contentType, java.lang.String category, java.lang.String reservedFlags) throws java.rmi.RemoteException;
    public void addTranslationArray(java.lang.String appId, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.Translation[] translations, java.lang.String from, java.lang.String to, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.GetTranslationsResponse[] getTranslationsArray(java.lang.String appId, java.lang.String[] texts, java.lang.String from, java.lang.String to, java.lang.Integer maxTranslations, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException;
    public java.lang.String speak(java.lang.String appId, java.lang.String text, java.lang.String language, java.lang.String format, java.lang.String options) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateArrayResponse[] translateArray(java.lang.String appId, java.lang.String[] texts, java.lang.String from, java.lang.String to, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateArray2Response[] translateArray2(java.lang.String appId, java.lang.String[] texts, java.lang.String from, java.lang.String to, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException;
}
