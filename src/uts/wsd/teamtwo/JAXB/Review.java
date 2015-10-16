package uts.wsd.teamtwo.JAXB;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
    @XmlSchemaType(name = "date")
	private XMLGregorianCalendar date;
	
	/**
	 * The content of the review (message content)
	 */
	@XmlValue
	private String message;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	public XMLGregorianCalendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(XMLGregorianCalendar date) {
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
