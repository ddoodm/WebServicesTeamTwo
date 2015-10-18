package uts.wsd.teamtwo.JAXB;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.*;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.Filter.Chain;

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
	
	private Reviews filterByFunc(FilterFunction filterFunc)
	{
		ArrayList<Review> filteredList = new ArrayList<Review>();
		for(Review review : list)
			if(filterFunc.filter(review))
				filteredList.add(review);
		return new Reviews(filteredList);
	}
	
	public Reviews filterById(int id)
	{
		ArrayList<Review> filteredList = new ArrayList<Review>();
		filteredList.add(getReview(id));
		return new Reviews(filteredList);
	}
	
	public Reviews filterByHotel(Hotel hotel)
	{
		return filterByHotel(hotel.getId());
	}
	
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
	
	public Reviews filterByStartDate(final Date startBound)
	{
		return filterByFunc(new FilterFunction()
		{
			@Override
			public Boolean filter(Review review)
			{
				return review.getDate().after(startBound);
			}
		});
	}
	
	public Reviews filterByEndDate(final Date endBound)
	{
		return filterByFunc(new FilterFunction()
		{
			@Override
			public Boolean filter(Review review)
			{
				return review.getDate().before(endBound);
			}
		});
	}
	
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
	
	private interface FilterFunction
	{
		public Boolean filter(Review review);
	}
}
