package uts.wsd.teamtwo.soap.client;

public class ReviewSOAPProxy implements uts.wsd.teamtwo.soap.client.ReviewSOAP {
  private String _endpoint = null;
  private uts.wsd.teamtwo.soap.client.ReviewSOAP reviewSOAP = null;
  
  public ReviewSOAPProxy() {
    _initReviewSOAPProxy();
  }
  
  public ReviewSOAPProxy(String endpoint) {
    _endpoint = endpoint;
    _initReviewSOAPProxy();
  }
  
  private void _initReviewSOAPProxy() {
    try {
      reviewSOAP = (new uts.wsd.teamtwo.soap.client.ReviewSOAPServiceLocator()).getReviewSOAPPort();
      if (reviewSOAP != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reviewSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reviewSOAP)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reviewSOAP != null)
      ((javax.xml.rpc.Stub)reviewSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uts.wsd.teamtwo.soap.client.ReviewSOAP getReviewSOAP() {
    if (reviewSOAP == null)
      _initReviewSOAPProxy();
    return reviewSOAP;
  }
  
  public uts.wsd.teamtwo.soap.client.ReviewSOAPResult deleteReview(au.edu.uts.www._31284.team2.wsd.ReviewType arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (reviewSOAP == null)
      _initReviewSOAPProxy();
    return reviewSOAP.deleteReview(arg0, arg1, arg2);
  }
  
  public uts.wsd.teamtwo.soap.client.ReviewSOAPResult postReview(au.edu.uts.www._31284.team2.wsd.ReviewType arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (reviewSOAP == null)
      _initReviewSOAPProxy();
    return reviewSOAP.postReview(arg0, arg1, arg2);
  }
  
  public au.edu.uts.www._31284.team2.wsd.ReviewType[] fetchReviews() throws java.rmi.RemoteException{
    if (reviewSOAP == null)
      _initReviewSOAPProxy();
    return reviewSOAP.fetchReviews();
  }
  
  
}