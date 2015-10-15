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

	/**
	 * @return A reference to the ArrayList of reviews
	 */
	public ArrayList<Review> getReviews()
	{
		return list;
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
