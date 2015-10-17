package uts.wsd.teamtwo;

import uts.wsd.teamtwo.JAXB.Hotel;
import uts.wsd.teamtwo.JAXB.Hotels;
import uts.wsd.teamtwo.JAXB.Review;
import uts.wsd.teamtwo.JAXB.Reviews;

public class ReviewsApplication extends GenericApplication<Reviews> {

	public static final String
		REVIEWS_DOCUMENT_PATH = "WEB-INF/reviews.xml",
		REVIEWS_SCHEMA_PATH = "WEB-INF/reviews.xsd";
	
	public ReviewsApplication() {
		// TODO Auto-generated constructor stub
		jaxbClass = Reviews.class;
	}
	
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
	
	public Reviews filterById(int id)
	{
		return resource.filterById(id);
	}
	
	public Reviews getReviewsForHotel(Hotel hotel)
	{
		return resource.filterByHotel(hotel);
	}
	
	public Review getReview(int id)
	{
		return resource.getReview(id);
	}
}
