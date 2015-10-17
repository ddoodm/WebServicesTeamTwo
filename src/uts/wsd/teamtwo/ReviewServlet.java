package uts.wsd.teamtwo;

import java.io.IOException;
import java.util.Date;

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
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.xml.sax.SAXException;

import uts.wsd.teamtwo.JAXB.Author;
import uts.wsd.teamtwo.JAXB.Hotel;
import uts.wsd.teamtwo.JAXB.Review;

/**
 * Servlet implementation class PostReview
 */
@WebServlet("/reviewServlet")
public class ReviewServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
    }
    
    /**
     * Obtains the review Data Access Object
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
			ReviewsApplication reviewApp = (ReviewsApplication) application.getAttribute("reviewApp");
			
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
		String operation = request.getParameter("operation");
		
		switch(operation)
		{
		case "postReview":		postReview(request, response);		break;
		case "deleteReview":	deleteReview(request, response);	break;
		}
	}
	
	private void postReview(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		Author author = (Author) request.getSession().getAttribute("author");
		if(author == null)
			return;
		
		String
			reviewTitle = request.getParameter("title"),
			reviewMessage = request.getParameter("message");
		
		int
			hotelId = Integer.parseInt(request.getParameter("hotelId")),
			reviewRating = Integer.parseInt(request.getParameter("rating"));
		
		Date postDate = new Date();
		
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
	 * Redirect the client to the hotel detail page with the specified ID
	 * @param hotelId The ID of the hotel page to display
	 */
	private void redirectToHotelPage(int hotelId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String redirectUrl = "hotel.jsp?id=" + hotelId;
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);
		dispatcher.forward(request, response);
	}
}
