package uts.wsd.teamtwo.soap;

import java.util.Date;

import javax.annotation.Resource;
import javax.jws.*;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import uts.wsd.teamtwo.AuthorApplicaion;
import uts.wsd.teamtwo.ReviewsApplication;
import uts.wsd.teamtwo.JAXB.Author;
import uts.wsd.teamtwo.JAXB.Review;
import uts.wsd.teamtwo.JAXB.Reviews;

/**
 * The SOAP Service which exposes functionality for
 * retrieving and manipulating Reviews on the database.
 * @author Deinyon L Davies
 */
@WebService
public class ReviewSOAP
{
	/**
	 * The server context that is used to obtain a ServletContext
	 */
	@Resource
	private WebServiceContext context;
	
	/**
	 * A servlet application context for attribute persistence
	 */
	@Context
	private ServletContext application;
	
    /**
     * Obtains the Review Data Access Object while disallowing other threads to access the database
     * @return the Review Data Access Object
     */
	private ReviewsApplication getReviewApp ()
	{
		application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);

		synchronized (application)
		{
			ReviewsApplication reviewApp = (ReviewsApplication) application.getAttribute("reviewApp");
			if (reviewApp == null)
			{
				reviewApp = new ReviewsApplication();
				reviewApp.setFilePath(application.getRealPath(ReviewsApplication.REVIEWS_DOCUMENT_PATH));
				application.setAttribute("reviewApp", reviewApp);
			}
			return reviewApp;
		}
	}
	
    /**
     * Obtains the Author Data Access Object while disallowing other threads to access the database
     * @return the Author Data Access Object
     */
	private AuthorApplicaion getAuthorApp ()
	{
		application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);

		synchronized (application)
		{
			AuthorApplicaion authorApp = (AuthorApplicaion) application.getAttribute("authorApp");
			if (authorApp == null)
			{
				authorApp = new AuthorApplicaion();
				authorApp.setFilePath(application.getRealPath(AuthorApplicaion.AUTHORS_DOCUMENT_PATH));
				application.setAttribute("authorApp", authorApp);
			}
			return authorApp;
		}
	}
	
	/**
	 * @return The entire (unfiltered) collection of reviews from the database
	 */
	@WebMethod
	public Reviews fetchReviews()
	{
		return getReviewApp().getReviews();
	}
	
	/**
	 * Appends a given review to the database.
	 * The review does not need to specify an
	 * ID number, author ID number or date,
	 * for they will be overwritten.
	 * @param review The review to append to the database
	 * @param username The username of the author who is posting the review
	 * @param password THe password of the author who is posting the review
	 * @return The result of the review addition.
	 * @see uts.wsd.teamtwo.soap.client.ReviewSOAPResult
	 * @see Review
	 */
	@WebMethod
	public ReviewSOAPResult postReview(Review review, String username, String password)
	{		
		// Attempt to log the reviewer in
		Author author = getAuthorApp().login(username, password);
		if(author == null)
			return ReviewSOAPResult.AUTH_FAILURE;
		
		// The ID is not assigned by the client
		// Set the ID to the next ID available
		review.setId(getReviewApp().getReviews().getReviews().size());
		
		// Set the author ID
		review.setAuthorId((int)author.getId());
		
		// Set the date to now
		review.setDate(new Date());
		
		// Add the review to the application
		getReviewApp().postReview(review);
		
		return ReviewSOAPResult.SUCCESS;
	}
	
	/**
	 * Removes a given review from the database
	 * @param review The review to remove from the database
	 * @param username The username of the author who is deleting the review
	 * @param password THe password of the author who is deleting the review
	 * @return The result of the review deletion.
	 * @see uts.wsd.teamtwo.soap.client.ReviewSOAPResult
	 * @see Review
	 */
	@WebMethod
	public ReviewSOAPResult deleteReview(Review review, String username, String password)
	{
		Author author = getAuthorApp().login(username, password);
		if(author == null)
			return ReviewSOAPResult.AUTH_FAILURE;
		
		// Check that the review exists
		Review reviewOnDb = getReviewApp().getReview(review.getId());
		if(reviewOnDb == null)
			return ReviewSOAPResult.BAD_REVIEW_ID;
		
		// Check whether this author actually owns this review
		if(reviewOnDb.getAuthorId() != author.getId())
			return ReviewSOAPResult.AUTH_FAILURE;
		
		// Perform the deletion
		getReviewApp().deleteReview(reviewOnDb);
		
		return ReviewSOAPResult.SUCCESS;
	}
}
