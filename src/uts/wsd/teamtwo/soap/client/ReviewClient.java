package uts.wsd.teamtwo.soap.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import au.edu.uts.www._31284.team2.wsd.ReviewType;

public class ReviewClient
{
	/**
	 * The Review SOAP service interface
	 */
	private ReviewSOAP reviews;
	
	public static void main (String[] args)
	{
		try
		{
			ReviewClient thicClient = new ReviewClient();
		}
		catch (Exception e)
		{
			System.out.println("==== Exception at main():");
			e.printStackTrace();
		}
	}
	
	public ReviewClient() throws ServiceException, RemoteException
	{
		// Initialize SOAP client interface
		ReviewSOAPServiceLocator locator = new ReviewSOAPServiceLocator();
		reviews = locator.getReviewSOAPPort();
		
		ReviewSOAPResult result = reviews.postReview(new ReviewType(), new UserNamePassPair());
		
		System.out.println(result);
	}
}
