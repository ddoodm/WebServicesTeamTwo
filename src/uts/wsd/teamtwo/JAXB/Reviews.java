package uts.wsd.teamtwo.JAXB;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.*;
import javax.xml.rpc.ServiceException;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.Filter.Chain;

import uts.wsd.teamtwo.ReviewsApplication;
import uts.wsd.teamtwo.translator.TranslatorClient;

/**
 * The DTO that describes a collection of Review.
 * Used for database storage, manipulation and XSLT display.
 * @see Review
 * 
 * @author Deinyon L Davies
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "list"
})
@XmlRootElement(name = "reviews")
public class Reviews implements Serializable
{
	@XmlElement(name="review")
    private ArrayList<Review> list = new ArrayList<Review>();
	
	/**
	 * Empty constructor for JAXB binding
	 */
	public Reviews() { }
	
	/**
	 * Create a Review collection from an ArrayList of Review
	 * @param list The ArrayList of Review from which to create the collection
	 */
	public Reviews (ArrayList<Review> list)
	{
		this.list = list;
	}
	
	/**
	 * @return True if there are no reviews in this collection
	 */
	public Boolean isEmpty()
	{
		return list.size() == 0;
	}
	
	/**
	 * Add a review to the list of reviews in memory.
	 * Does not update the database.
	 * @param review The review to add
	 * @see ReviewsApplication
	 */
	public void postReview(Review review)
	{
		// The new review ID is the last review ID + 1
		review.setId(list.get(list.size()-1).getId() + 1);
		
		// Add the review to the list
		list.add(review);
	}
	
	/**
	 * Removes a review from the list of reviews in memory.
	 * @param review The review to delete
	 */
	public void deleteReview(Review review)
	{
		list.remove(review);
	}

	/**
	 * @return A reference to the ArrayList of reviews
	 */
	public ArrayList<Review> getReviews()
	{
		return list;
	}
	
	/**
	 * Locates and returns the Review with the specified ID
	 * @param id The ID number of the review to return
	 * @return The review with the given ID number
	 */
	public Review getReview(int id)
	{
		for(Review r : list)
			if(r.getId() == id)
				return r;
		return null;
	}
	
	/**
	 * Implements the Microsoft Language Services SOAP client to translate
	 * this collection of reviews to the language specified by 'language'.
	 * @param language The language to which the review will be translated. Can be any Language Code defined by Microsoft
	 * @return This collection of Review where the message is translated to the given language
	 */
	public Reviews translateTo(String language)
	{
		ArrayList<Review> translatedReviews = new ArrayList<Review>();
		for(Review review : list)
		{
			Review tempReview = new Review(review);
			try {
				tempReview.setMessage(TranslatorClient.translate(review.getMessage(), language));
			} catch (RemoteException | ServiceException e) {
				e.printStackTrace();
			}
			translatedReviews.add(tempReview);
		}
		return new Reviews(translatedReviews);
	}
	
	/**
	 * Filters the collection of Review given a FilterFunction.
	 * Allows complex definition of filtering types with minimal
	 * duplicated code.
	 * @param filterFunc The FilterFunction that defines the filter to apply
	 * @return The filtered collection of Reviews
	 * @see FilterFunction
	 */
	private Reviews filterByFunc(FilterFunction filterFunc)
	{
		ArrayList<Review> filteredList = new ArrayList<Review>();
		for(Review review : list)
			if(filterFunc.filter(review))
				filteredList.add(review);
		return new Reviews(filteredList);
	}
	
	/**
	 * Filters the list to a collection of <b>one</b> Review with the given ID.
	 * Used for XSLT transformation where a single Review is required
	 * @param id The ID number of the Review to display
	 * @return A collection of one Review with the given ID number
	 */
	public Reviews filterById(int id)
	{
		ArrayList<Review> filteredList = new ArrayList<Review>();
		filteredList.add(getReview(id));
		return new Reviews(filteredList);
	}
	
	/**
	 * Filters this collection of Review in a way that results in reviews for a given Hotel only.
	 * @param hotel The hotel for which the reviews were written
	 * @return The collection of Review that were written for the specified Hotel
	 */
	public Reviews filterByHotel(Hotel hotel)
	{
		return filterByHotel(hotel.getId());
	}
	
	/**
	 * Filters this collection of Review in a way that results in reviews for a given Hotel only.
	 * @param hotelId The hotel for which the reviews were written
	 * @return The collection of Review that were written for the specified Hotel
	 */
	public Reviews filterByHotel(final long hotelId)
	{
		return filterByFunc(new FilterFunction()
		{
			@Override
			public Boolean filter(Review review)
			{
				return review.getHotelId() == hotelId;
			}
		});
	}
	
	/**
	 * Filters the collection of Review by a starting date boundary.
	 * Reviews that were posted on or after the startBound will be returned
	 * @param startBound The earliest date on which the review could be posted
	 * @return A collection of Review filtered by a starting date
	 */
	public Reviews filterByStartDate(final Date startBound)
	{
		return filterByFunc(new FilterFunction()
		{
			@Override
			public Boolean filter(Review review)
			{
				// Inclusive date comparison
				return
					review.getDate().compareTo(startBound) >= 0;
			}
		});
	}
	
	/**
	 * Filters the collection of Review by a ending date boundary.
	 * Reviews that were posted on or before the endBound will be returned
	 * @param endBound The latest date on which the review could be posted
	 * @return A collection of Review filtered by an ending date
	 */
	public Reviews filterByEndDate(final Date endBound)
	{
		return filterByFunc(new FilterFunction()
		{
			@Override
			public Boolean filter(Review review)
			{
				// Inclusive date comparison
				return
					review.getDate().compareTo(endBound) <= 0;
			}
		});
	}
	
	/**
	 * Filters the collection of Review by rating
	 * Reviews that match the specified rating exactly will be returned
	 * @param rating The reviews to find with the given rating
	 * @return A collection of Review filtered by a rating
	 */
	public Reviews filterByRating(final int rating)
	{
		return filterByFunc(new FilterFunction()
		{
			@Override
			public Boolean filter(Review review)
			{
				return review.getRating() == rating;
			}
		});
	}
	
    /**
     * An interface for writing custom review filtering functions.
     * FilterFuncion.filter() is implemented to define the filtering functionality.
     * 
     * @author Deinyon L Davies
     * TODO: Should be a generic interface
     */
	private interface FilterFunction
	{
		public Boolean filter(Review review);
	}
}
