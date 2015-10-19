package uts.wsd.teamtwo.rest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import uts.wsd.teamtwo.ReviewsApplication;
import uts.wsd.teamtwo.JAXB.Reviews;

/**
 * The REST service which provides access to the collection of Reviews
 * stored by the server. Responses are provided in XML format.
 * 
 * @author Deinyon L Davies
 */
@Path("")
public class ReviewRestService
{
	/**
	 * A servlet application context for attribute persistence
	 */
	@Context
	ServletContext application;
	
    /**
     * Obtains the review Data Access Object while disallowing other threads to access the database
     * @return the review Data Access Object
     */
	private ReviewsApplication getReviewApp() throws JAXBException, IOException, SAXException
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
				
				reviewApp.setFilePath(application.getRealPath(ReviewsApplication.REVIEWS_DOCUMENT_PATH));
				
				application.setAttribute("reviewApp", reviewApp);
				System.out.println("==== ReviewRestService.getReviewApp(): Instantiated a new ReviewApp.");
			}
			
			return reviewApp;
		}
	}
	
	/**
	 * An exception-safe function for retrieving the collection of data (DTO)
	 * @return The DTO obtained through the DAO
	 */
	private Reviews getReviews()
	{
		try
		{
			return getReviewApp().getReviews();
		}
		catch(Exception e)
		{
			System.out.println("==== ERROR: ReviewRestService.getReviews(): Could not get review app / reviews.");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Generates a set of reviews, filtered by all (may be null) of the parameters.
	 * @param name The partial name of the matching hotel (match will <b>contain</b> 'name' in its name.
	 * @param country The country of the matching hotel.
	 * @return The set of hotels that has been filtered by the parameters.
	 */
	@Path("/reviews")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Reviews searchReviews(
			@QueryParam("hotelId") int hotelId,
			@QueryParam("startDate") String startDateStr,
			@QueryParam("endDate") String endDateStr,
			@QueryParam("starRating") String ratingStr)
	{
		// (Working review set)
		Reviews filteredReviews = getReviews();
		
		// Hotel ID is required. Filter reviews by hotel
		filteredReviews = filteredReviews.filterByHotel(hotelId);
		
		// Try to parse and filter by the start date parameter
		try
		{
			if(startDateStr != null)
			{
				Date startDate = parseDate(startDateStr);
				filteredReviews = filteredReviews.filterByStartDate(startDate);
			}
		} catch (ParseException e) { }
		
		// Try to parse and filter by the end date parameter
		try
		{
			if(endDateStr != null)
			{
				Date endDate = parseDate(endDateStr);
				filteredReviews = filteredReviews.filterByEndDate(endDate);
			}
		} catch (ParseException e) { }
		
		// Try to parse and filter by the rating parameter
		try
		{
			if(ratingStr != null)
				filteredReviews =
					filteredReviews.filterByRating(Integer.parseInt(ratingStr));
		} catch (NumberFormatException e) { }
		
		return filteredReviews;
	}
	
	/**
	 * Used to parse a valid date-string to a Java Date.
	 * Date strings should be formatted as JAXB dates:
	 * <i>yyyy-MM-dd</i>
	 * @param strDate The date as a valid (formatted) string
	 * @return The string date as a Java date
	 * @throws ParseException If the string was not a valid JAXB date
	 */
	private Date parseDate(String strDate) throws ParseException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.parse(strDate);
	}
}

