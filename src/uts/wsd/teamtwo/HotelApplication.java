package uts.wsd.teamtwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletContext;
import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import uts.wsd.teamtwo.JAXB.*;

/**
 * The DAO which exposes functionality for manipulating and accessing the Hotels database
 * @author Deinyon L Davies
 */
public class HotelApplication extends GenericApplication<Hotels>
{
	/**
	 * The server-relative path to the Hotels XML database
	 */
	public static final String
		HOTELS_DOCUMENT_PATH = "WEB-INF/hotels.xml",
		HOTELS_SCHEMA_PATH = "WEB-INF/hotels.xsd";

	public HotelApplication()
	{
		// TODO Auto-generated constructor stub
		jaxbClass = Hotels.class;
	}

	/**
	 * @return The entire collection of hotels
	 */
	public Hotels getHotels()
	{
		return resource;
	}
	
	/**
	 * @param hotelId The ID of the hotel to locate
	 * @return The hotel with the specified ID
	 */
	public Hotel getHotel(int hotelId)
	{
		return resource.getHotel(hotelId);
	}
}
