package uts.wsd.teamtwo.JAXB;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "list"
})
@XmlRootElement(name = "reviews")
public class Reviews implements Serializable
{
	@XmlElement(name="review")
    private ArrayList<Review> list = new ArrayList<Review>();
	
	public Reviews() { }
	
	public Reviews (ArrayList<Review> list)
	{
		this.list = list;
	}
	
	public Boolean isEmpty()
	{
		return list.size() == 0;
	}
	
	/**
	 * Add a review to the list of reviews in memory
	 * @param review The review to add
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
	
	public Review getReview(int id)
	{
		for(Review r : list)
			if(r.getId() == id)
				return r;
		return null;
	}
	
	public Reviews filterById(int id)
	{
		ArrayList<Review> filteredList = new ArrayList<Review>();
		filteredList.add(getReview(id));
		return new Reviews(filteredList);
	}
	
	public Reviews filterByHotel(Hotel hotel)
	{
		ArrayList<Review> filteredList = new ArrayList<Review>();
		for(Review review : list)
			if(review.getHotelId() == hotel.getId())
				filteredList.add(review);
		return new Reviews(filteredList);
	}
}
