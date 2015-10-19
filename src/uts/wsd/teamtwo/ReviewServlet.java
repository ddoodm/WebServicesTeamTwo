package uts.wsd.teamtwo;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.xml.bind.JAXBException;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.xml.sax.SAXException;

import uts.wsd.teamtwo.JAXB.Author;
import uts.wsd.teamtwo.JAXB.Hotel;
import uts.wsd.teamtwo.JAXB.Review;

/**
 * The servlet that is responsible for posting and deleting reviews
 * in response to requests from the web server.
 * 
 * @author Deinyon L Davies
 */
@WebServlet("/reviewServlet")
public class ReviewServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet()
    {
        super();
    }
    
    /**
     * Obtains the review Data Access Object while disallowing other threads to access the database
     * @return the review Data Access Object
     */
	private ReviewsApplication getReviewsApp(ServletContext application) throws JAXBException, IOException, SAXException
	{
		/* 
		 * Lock the application object so that threads from other
		 * simultaneous requests do not corrupt it.
		 */
		synchronized (application)
		{
			// Attempt to locate an existing instance of the ReviewApp
			ReviewsApplication reviewApp = (ReviewsApplication) application.getAttribute("reviewApp");
			
			// If one has not already been created, create one
			if (reviewApp == null)
			{
				reviewApp = new ReviewsApplication();
				
				reviewApp.setFilePath(
						application.getRealPath(ReviewsApplication.REVIEWS_DOCUMENT_PATH));
				
				application.setAttribute("reviewApp", reviewApp);
				System.out.println("==== PostReview.getReviewsApp(): Instantiated a new ReviewsApp.");
			}
			
			return reviewApp;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Get the operation request from the request parameter (post or delete)
		String operation = request.getParameter("operation");
		
		switch(operation)
		{
		case "postReview":		postReview(request, response);		break;
		case "deleteReview":	deleteReview(request, response);	break;
		}
	}
	
	/**
	 * Create and post a review from a given HTTP request
	 */
	private void postReview(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		// Double-check that the author is logged in
		Author author = (Author) request.getSession().getAttribute("author");
		if(author == null)
			return;
		
		// Obtain POST parameters
		String
			hotelIdString = request.getParameter("hotelId"),
			ratingString = request.getParameter("rating"),
			reviewTitle = request.getParameter("title"),
			reviewMessage = request.getParameter("message");
		
		// Obtain the hotel ID now
		int hotelId = Integer.parseInt(hotelIdString);
		
		// Verify that the data exists and is valid
		ComposeReviewErrorFields errors = 
				verifyPostReviewData(reviewTitle, ratingString, reviewMessage);
		if(errors != ComposeReviewErrorFields.NONE)
		{
			returnToPageWithError(hotelId, errors, request, response);
			return;
		}
		
		// Parse integer variables
		int reviewRating = Integer.parseInt(ratingString);
		
		// Obtain the current date
		Date postDate = new Date();
		
		// Create and post the new review
		Review review = new Review(hotelId, author.getId(), reviewTitle, reviewRating, postDate, reviewMessage);
		try {
			getReviewsApp(request.getServletContext()).postReview(review);
		} catch (JAXBException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Redirect to the hotel page
		redirectToHotelPage(hotelId, request, response);
	}
	
	/**
	 * Delete a review from a given HTTP request
	 */
	private void deleteReview(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		ReviewsApplication reviewApp;
		try {
			reviewApp = getReviewsApp(request.getServletContext());
		} catch (SAXException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		// Double-check that the author is logged in
		Author author = (Author) request.getSession().getAttribute("author");
		if(author == null)
			return;
		
		// Obtain the review
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		Review review = reviewApp.getReview(reviewId);
		int hotelId = review.getHotelId();
		
		// Double-check that the author owns the review
		if(review.getAuthorId() != author.getId())
			return;
		
		// Request to delete the review
		reviewApp.deleteReview(review);
		
		// Redirect to the hotel page for this review
		redirectToHotelPage(hotelId, request, response);
	}
	
	/**
	 * Validate the data supplied via the HTTP request to
	 * determine whether the data is well formed and complies
	 * with the database schema (is valid).
	 * @param title The title supplied by the user
	 * @param ratingString The rating supplied by the user
	 * @param message The message supplied by the user
	 * @return Returns the result code. The result will identify any field that is not valid.
	 * @see ComposeReviewErrorFields
	 */
	private ComposeReviewErrorFields verifyPostReviewData(String title, String ratingString, String message)
	{
		ComposeReviewErrorFields error;
		
		error = validateTitleParam(title);
		if(error != ComposeReviewErrorFields.NONE)
			return error;
		
		error = validateRatingParam(ratingString);
		if(error != ComposeReviewErrorFields.NONE)
			return error;
		
		error = validateMessageParam(message);
		if(error != ComposeReviewErrorFields.NONE)
			return error;
		
		return ComposeReviewErrorFields.NONE;
	}
	
	/**
	 * Verifies that the title parameter is valid
	 * @param title The title supplied by the user
	 * @return The result for this parameter
	 */
	private ComposeReviewErrorFields validateTitleParam (String title)
	{
		// Check for empty parameters
		if(title == null || title.isEmpty())
			return ComposeReviewErrorFields.TITLE_MISSING;
		
		// Check title format
		Pattern titleRegex = Pattern.compile("([A-Z]\\w*\\s?)+");
		Boolean patternMatches = titleRegex.matcher(title).matches();
		if(!patternMatches)
			return ComposeReviewErrorFields.TITLE_FORMAT;
		
		return ComposeReviewErrorFields.NONE;
	}
	
	/**
	 * Verifies that the rating parameter is valid
	 * @param rating The rating supplied by the user
	 * @return The result for this parameter
	 */
	private ComposeReviewErrorFields validateRatingParam (String rating)
	{
		// Check for empty parameters
		if(rating == null || rating.isEmpty())
			return ComposeReviewErrorFields.RATING_MISSING;
		
		// Check rating format
		int ratingInteger;
		try { ratingInteger = Integer.parseInt(rating); }
		catch (Exception e) { return ComposeReviewErrorFields.RATING_FORMAT; }
		if(ratingInteger < 1 || ratingInteger > 10)
			return ComposeReviewErrorFields.RATING_FORMAT;
		
		return ComposeReviewErrorFields.NONE;
	}
	
	/**
	 * Verifies that the message parameter is valid
	 * @param message The message supplied by the user
	 * @return The result for this parameter
	 */
	private ComposeReviewErrorFields validateMessageParam (String message)
	{
		// Check for empty message
		if(message == null || message.isEmpty())
			return ComposeReviewErrorFields.MESSAGE_MISSING;
		
		return ComposeReviewErrorFields.NONE;
	}
	
	/**
	 * Redirect the client to the hotel detail page with the specified ID
	 * @param hotelId The ID of the hotel page to display
	 */
	private void redirectToHotelPage(int hotelId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Set GET parameter
		String redirectUrl = "hotel.jsp?id=" + hotelId;
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);

		// Forward the incoming request back to the hotel page
		dispatcher.forward(request, response);
	}
	
	/**
	 * Redirects the client to the review composition page,
	 * and supplies the set of errors that occurred.
	 * @param hotelId The ID of the hotel that this review was composed for
	 * @param errorFields The error that was encountered when attempting to validate the review
	 */
	private void returnToPageWithError(int hotelId, ComposeReviewErrorFields errorFields, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Set GET parameter
		String redirectUrl = "hotel.jsp?id=" + hotelId;
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);
		
		// Append the error to the request
		request.setAttribute("composeReviewError", errorFields);

		// Forward the incoming request back to the hotel page
		dispatcher.forward(request, response);
	}
}
