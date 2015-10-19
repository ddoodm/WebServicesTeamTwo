package com.microsofttranslator.api.V2;

public class LanguageServiceProxy implements com.microsofttranslator.api.V2.LanguageService {
  private String _endpoint = null;
  private com.microsofttranslator.api.V2.LanguageService languageService = null;
  
  public LanguageServiceProxy() {
    _initLanguageServiceProxy();
  }
  
  public LanguageServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initLanguageServiceProxy();
  }
  
  private void _initLanguageServiceProxy() {
    try {
      languageService = (new org.tempuri.SoapServiceLocator()).getBasicHttpBinding_LanguageService();
      if (languageService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)languageService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)languageService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (languageService != null)
      ((javax.xml.rpc.Stub)languageService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.microsofttranslator.api.V2.LanguageService getLanguageService() {
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService;
  }
  
  public void addTranslation(java.lang.String appId, java.lang.String originalText, java.lang.String translatedText, java.lang.String from, java.lang.String to, java.lang.Integer rating, java.lang.String contentType, java.lang.String category, java.lang.String user, java.lang.String uri) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    languageService.addTranslation(appId, originalText, translatedText, from, to, rating, contentType, category, user, uri);
  }
  
  public int[] breakSentences(java.lang.String appId, java.lang.String text, java.lang.String language) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.breakSentences(appId, text, language);
  }
  
  public java.lang.String detect(java.lang.String appId, java.lang.String text) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.detect(appId, text);
  }
  
  public java.lang.String[] detectArray(java.lang.String appId, java.lang.String[] texts) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.detectArray(appId, texts);
  }
  
  public java.lang.String getAppIdToken(java.lang.String appId, java.lang.Integer minRatingRead, java.lang.Integer maxRatingWrite, java.lang.Integer expireSeconds) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.getAppIdToken(appId, minRatingRead, maxRatingWrite, expireSeconds);
  }
  
  public java.lang.String[] getLanguageNames(java.lang.String appId, java.lang.String locale, java.lang.String[] languageCodes, java.lang.Boolean useSpokenVariant) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.getLanguageNames(appId, locale, languageCodes, useSpokenVariant);
  }
  
  public java.lang.String[] getLanguagesForSpeak(java.lang.String appId) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.getLanguagesForSpeak(appId);
  }
  
  public java.lang.String[] getLanguagesForTranslate(java.lang.String appId) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.getLanguagesForTranslate(appId);
  }
  
  public org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.GetTranslationsResponse getTranslations(java.lang.String appId, java.lang.String text, java.lang.String from, java.lang.String to, java.lang.Integer maxTranslations, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.getTranslations(appId, text, from, to, maxTranslations, options);
  }
  
  public java.lang.String translate(java.lang.String appId, java.lang.String text, java.lang.String from, java.lang.String to, java.lang.String contentType, java.lang.String category, java.lang.String reservedFlags) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.translate(appId, text, from, to, contentType, category, reservedFlags);
  }
  
  public void addTranslationArray(java.lang.String appId, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.Translation[] translations, java.lang.String from, java.lang.String to, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    languageService.addTranslationArray(appId, translations, from, to, options);
  }
  
  public org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.GetTranslationsResponse[] getTranslationsArray(java.lang.String appId, java.lang.String[] texts, java.lang.String from, java.lang.String to, java.lang.Integer maxTranslations, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.getTranslationsArray(appId, texts, from, to, maxTranslations, options);
  }
  
  public java.lang.String speak(java.lang.String appId, java.lang.String text, java.lang.String language, java.lang.String format, java.lang.String options) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.speak(appId, text, language, format, options);
  }
  
  public org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateArrayResponse[] translateArray(java.lang.String appId, java.lang.String[] texts, java.lang.String from, java.lang.String to, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.translateArray(appId, texts, from, to, options);
  }
  
  public org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateArray2Response[] translateArray2(java.lang.String appId, java.lang.String[] texts, java.lang.String from, java.lang.String to, org.datacontract.schemas._2004._07.Microsoft_MT_Web_Service_V2.TranslateOptions options) throws java.rmi.RemoteException{
    if (languageService == null)
      _initLanguageServiceProxy();
    return languageService.translateArray2(appId, texts, from, to, options);
  }
  
  
}