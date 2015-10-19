package uts.wsd.teamtwo;

import uts.wsd.teamtwo.JAXB.Hotel;
import uts.wsd.teamtwo.JAXB.Hotels;
import uts.wsd.teamtwo.JAXB.Review;
import uts.wsd.teamtwo.JAXB.Reviews;

/**
 * The DAO which exposes functionality for manipulating and accessing the Reviews database
 * @author Deinyon L Davies
 */
public class ReviewsApplication extends GenericApplication<Reviews>
{
	/**
	 * The server-relative path to the Reviews XML database
	 */
	public static final String
		REVIEWS_DOCUMENT_PATH = "WEB-INF/reviews.xml",
		REVIEWS_SCHEMA_PATH = "WEB-INF/reviews.xsd";
	
	public ReviewsApplication()
	{
		// TODO Auto-generated constructor stub
		jaxbClass = Reviews.class;
	}
	
	/**
	 * Add a new review to the underlying database
	 * and update the database to include the new review.
	 * @param review The new review to add to the database
	 */
	public void postReview(Review review)
	{
		resource.postReview(review);
		try {
			updateDatabase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes a review from the underlying database
	 * and updates the database.
	 * @param review The review to delete from the database
	 */
	public void deleteReview(Review review)
	{
		resource.deleteReview(review);
		try {
			updateDatabase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Filters the set of reviews by an ID.
	 * One review will remain in the collection.
	 * @param id The ID of the review to find
	 * @return A collection of reviews containing only the review with the given ID
	 */
	public Reviews filterById(int id)
	{
		return resource.filterById(id);
	}
	
	/**
	 * Obtains the collection of reviews that were published
	 * for the given hotel.
	 * @param hotel The hotel whose reviews to find
	 * @return The reviews that were published for the given hotel
	 * @see Hotel
	 */
	public Reviews getReviewsForHotel(Hotel hotel)
	{
		return resource.filterByHotel(hotel);
	}
	
	/**
	 * Obtains the collection of reviews that were published
	 * for the hotel with the given ID.
	 * @param hotelId The ID of the hotel whose reviews to find
	 * @return The reviews that were published for the given hotel
	 * @see Hotel
	 */
	public Reviews getReviewsForHotel(int hotelId)
	{
		return resource.filterByHotel(hotelId);
	}
	
	/**
	 * @param id The ID of the review to find
	 * @return The review with the given ID
	 */
	public Review getReview(int id)
	{
		return resource.getReview(id);
	}
	
	/**
	 * @return The complete collection of reviews
	 */
	public Reviews getReviews()
	{
		return resource;
	}
}
