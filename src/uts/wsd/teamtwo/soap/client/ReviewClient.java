package uts.wsd.teamtwo.soap.client;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

import org.apache.axis.types.UnsignedInt;

import au.edu.uts.www._31284.team2.wsd.ReviewType;

/**
 * The standalone application that communicates with the
 * Reviews SOAP server. The class provides a program entry point (main());
 * it should be executed alone.
 * @see ReviewSOAP
 * @author Deinyon L Davies
 */
public class ReviewClient
{
	/**
	 * The Review SOAP service interface (client)
	 */
	private ReviewSOAP reviewServ;
	
	/**
	 * The program entry point
	 * @param args Not used
	 */
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
	
	/**
	 * Begins the command-line interface for the Review Client
	 */
	public ReviewClient() throws ServiceException, RemoteException
	{
		// Initialize SOAP client interface
		ReviewSOAPServiceLocator locator = new ReviewSOAPServiceLocator();
		reviewServ = locator.getReviewSOAPPort();
		
		System.out.println("==== Hotel Service 33 Review SOAP Client ====");
		
		// Get an operation from the user
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do
		{
			System.out.print(
					"Select an operation:\n"
					+ "\t1) List Reviews\n"
					+ "\t2) Post Review\n"
					+ "\t3) Delete Review\n"
					+ "\t0) Exit\n"
					+ ")> ");
			
			try { option = Integer.parseInt(sc.nextLine()); }
			catch (Exception e) { option = -1; }
			
			switch(option)
			{
			case 1:	listReviews(); break;
			case 2: postReview(); break;
			case 3: deleteReview(sc); break;
			}
		}
		while (option != 0);
		
		return;
	}

	/**
	 * Provides the command-line interface for making a deletion request to the SOAP server
	 * @param sc The standard input stream scanner
	 */
	private void deleteReview(Scanner sc) throws RemoteException
	{
		System.out.println("...");
		ReviewType[] reviews = reviewServ.fetchReviews();
		
		int reviewId = -1;
		for(;;)
		{
			try
			{
				String reviewIdString = scanString("Please supply the ID of the review to delete (1-n)");
				
				reviewId = Integer.parseInt(reviewIdString);
				if(reviewId > reviews.length || reviewId <= 0)
				{
					System.out.println("The review with ID " + reviewId + " does not exist.");
					continue;
				}
				
				break;
			}
			catch (Exception e) { }
		}
		
		// Subtract one from review ID - review IDs are 1-indexed as per the specification.
		ReviewType reviewToDelete = reviews[reviewId - 1];
		System.out.println("\n==== WARNING: You are about to delete the following review...");
		System.out.print(reviewToString(reviewToDelete));
		String confirmation = scanString("Are you sure? (y/n");
		
		if(!confirmation.toLowerCase().equals("y"))
		{
			System.out.println("Review was not deleted.");
			return;
		}
		
		String[] emailAndPass = promptUserAndPass();
		
		ReviewSOAPResult result =
				reviewServ.deleteReview(reviewToDelete, emailAndPass[0], emailAndPass[1]);
		
		if(result.equals(ReviewSOAPResult.SUCCESS))
			System.out.println("Review was deleted with success!");
		else if(result.equals(ReviewSOAPResult.AUTH_FAILURE))
			System.out.println("You are not authorized to delete this review.\nReview was not deleted.");
		else
			System.out.println("An unknown error occurred. Sorry.\nReview was not deleted.");
	}

	/**
	 * Provides the command-line interface for making a review composition request to the SOAP server
	 */
	private void postReview() throws RemoteException
	{
		String hotelId = scanString("Please enter a HOTEL ID");
		String title = scanString("Please enter a TITLE");
		String rating = scanString("Please enter a RATING");
		String message = scanString("Write your review:\n");
		
		ReviewType review = new ReviewType();
		review.setHotel(new UnsignedInt(hotelId));
		review.setTitle(title);
		review.setRating(new UnsignedInt(rating));
		review.set_value(message);
		
		String[] emailAndPass = promptUserAndPass();
		
		ReviewSOAPResult result =
				reviewServ.postReview(review, emailAndPass[0], emailAndPass[1]);
		
		if(result.equals(ReviewSOAPResult.SUCCESS))
			System.out.println("\nYour review was posted with success!\n");
		else if(result.equals(ReviewSOAPResult.AUTH_FAILURE))
			System.out.println("\nYou are not authorized to post a review. You must be an author.");
		else
			System.out.println("\nAn unknown error occurred. Sorry.\nReview was not posted.");
	}

	/**
	 * Provides the command-line interface for making a review listing request to the SOAP server
	 */
	private void listReviews() throws RemoteException
	{
		ReviewType[] reviewsList = reviewServ.fetchReviews();

		for(ReviewType review : reviewsList)
			System.out.print(reviewToString(review));
	}
	
	/**
	 * Converts a ReviewType (SOAP client) Review to a formatted string
	 * @see ReviewType
	 * @see Review
	 */
	private String reviewToString (ReviewType review)
	{
		// Define the review display format
		String format =
				  "====================\n"
				+ "ID: %d) %s\n"
				+ "For Hotel: %d\n"
				+ "By Author: %d\n"
				+ "Date Posted: %s\n"
				+ "Rating: %d\n"
				+ "--------------------\n"
				+ "%s\n\n";
		
		// Substitute the review details into the format
		String reviewString = String.format(
				format,
				review.getId().intValue(),
				review.getTitle(),
				review.getHotel().intValue(),
				review.getAuthor().intValue(),
				review.getDate().toString(),
				review.getRating().intValue(),
				review.get_value());
		
		return reviewString;
	}
	
	/**
	 * Prompts the user to enter a username and password
	 * @return The E-Mail in element [0], the password in element [1]
	 */
	private String[] promptUserAndPass()
	{
		String[] result = new String[2];
		result[0] = scanString("Enter your E-Mail:");
		result[1] = scanString("Enter your password:");
		return result;
	}
	
	/**
	 * Provides a prompt and waits for user input
	 * @param prompt The prompt message to display
	 * @return The user's input
	 */
	private String scanString(String prompt)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print(prompt + " )> ");
		return sc.nextLine();
	}
}
