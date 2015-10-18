/**
 * ReviewSOAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uts.wsd.teamtwo.soap.client;

public interface ReviewSOAP extends java.rmi.Remote {
    public uts.wsd.teamtwo.soap.client.ReviewSOAPResult postReview(au.edu.uts.www._31284.team2.wsd.ReviewType arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public uts.wsd.teamtwo.soap.client.ReviewSOAPResult deleteReview(au.edu.uts.www._31284.team2.wsd.ReviewType arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public au.edu.uts.www._31284.team2.wsd.ReviewType[] fetchReviews() throws java.rmi.RemoteException;
}
