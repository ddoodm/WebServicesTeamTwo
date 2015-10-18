package uts.wsd.teamtwo.soap;

import javax.jws.*;

import uts.wsd.teamtwo.JAXB.Review;
import uts.wsd.teamtwo.JAXB.Reviews;

@WebService
public class ReviewSOAP
{
	@WebMethod
	public Reviews fetchReviews()
	{
		return new Reviews();
	}
	
	@WebMethod
	public ReviewSOAPResult postReview(Review review, UserNamePassPair userLogin)
	{
		return ReviewSOAPResult.SUCCESS;
	}
	
	@WebMethod
	public ReviewSOAPResult deleteReview(Review review, UserNamePassPair userLogin)
	{
		return ReviewSOAPResult.SUCCESS;
	}
}
