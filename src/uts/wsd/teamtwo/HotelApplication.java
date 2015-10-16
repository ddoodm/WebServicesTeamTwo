package uts.wsd.teamtwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import uts.wsd.teamtwo.JAXB.*;

public class HotelApplication extends GenericApplication<Hotels>
{
	public static final String
		HOTELS_DOCUMENT_PATH = "WEB-INF/hotels.xml",
		HOTELS_SCHEMA_PATH = "WEB-INF/hotels.xsd";

	public HotelApplication()
	{
		// TODO Auto-generated constructor stub
		jaxbClass = Hotels.class;
	}
	
	public Hotels getHotels()
	{
		return resource;
	}
	
	public Hotel getHotel(int hotelId)
	{
		return resource.getHotel(hotelId);
	}
}
