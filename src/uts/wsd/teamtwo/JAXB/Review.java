package uts.wsd.teamtwo.JAXB;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for reviewType complex type.</p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reviewType")
public class Review implements Serializable
{
	/**
	 * The unique auto-incremented ID of this review
	 */
	@XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "unsignedInt")
    @XmlJavaTypeAdapter(IDAutoIncrementAdapter.class)
	private Integer id;
	
	/**
	 * The unique ID of the hotel that is associated with this review
	 */
	@XmlAttribute(name = "hotel", required = true)
    @XmlSchemaType(name = "unsignedInt")
	private Integer hotelId;
	
	/**
	 * The unique ID of the author that composed the review
	 */
	@XmlAttribute(name = "author", required = true)
    @XmlSchemaType(name = "unsignedInt")
	private Integer authorId;
	
	/**
	 * The title of the review (heading)
	 */
	@XmlAttribute(name = "title", required = true)
	private String title;
	
	/**
	 * The review of this rating. Constrained from 1 - 10 inclusive.
	 */
	@XmlAttribute(name = "rating", required = true)
    @XmlSchemaType(name = "unsignedInt")
	private Integer rating;
	
	/**
	 * The date on which the review was published.
	 */
	@XmlAttribute(name = "date", required = true)
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;
	
	/**
	 * The content of the review (message content)
	 */
	@XmlValue
	private String message;
	
	/**
	 * Empty constructor for JAXB initialization
	 */
	public Review () {  }
	
	/**
	 * Complete constructor for servlet initialization
	 */
	public Review (Integer hotelId, long authorId, String title, Integer rating, Date date, String message)
	{
		this.hotelId = hotelId;
		this.authorId = (int)authorId;
		this.title = title;
		this.rating = rating;
		this.message = message;
		this.date = date;
	}
	
	/**
	 * Parse Date date to an XMLGregorianCalendar date.
	 * @param stdDate The Date type date.
	 * @return The date as an XMLGregorianCalendar.
	 */
	/*
	private XMLGregorianCalendar parseStringDate(Date stdDate)
	{
		try
		{
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(stdDate);
			
			XMLGregorianCalendar xmlDate =
					DatatypeFactory.newInstance()
					.newXMLGregorianCalendarDate(
							calendar.get(Calendar.YEAR),
							calendar.get(Calendar.MONTH)+1,
							calendar.get(Calendar.DAY_OF_MONTH),
							DatatypeConstants.FIELD_UNDEFINED);
			
			return xmlDate;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	*/

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @param the review's ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the hotel's ID
	 */
	public Integer getHotelId() {
		return hotelId;
	}
	
	/**
	 * @return the author's ID
	 */
	public Integer getAuthorId() {
		return authorId;
	}
	
	/**
	 * @param the author's ID
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
