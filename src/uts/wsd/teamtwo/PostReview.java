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
import uts.wsd.teamtwo.JAXB.Review;

/**
 * Servlet implementation class PostReview
 */
@WebServlet("/PostReview")
public class PostReview extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostReview() {
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
		String redirectUrl = "hotel.jsp?id=" + hotelId;
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);
		dispatcher.forward(request, response);
	}

}
