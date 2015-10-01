package uts.wsd.teamtwo.rest;

import uts.wsd.teamtwo.*;
import uts.wsd.teamtwo.JAXB.*;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

@Path("/hotelService")
public class HotelRestService
{
	@Context
	ServletContext application;
	
	private static final String
		HOTELS_DOCUMENT_PATH = "WEB-INF/hotels.xml",
		HOTELS_SCHEMA_PATH = "WEB-INF/hotels.xsd";
	
	private HotelApplication getHotelApp() throws JAXBException, IOException, SAXException
	{
		/* 
		 * Lock the application object so that threads from other
		 * simultaneous requests do not corrupt it.
		 */
		synchronized (application)
		{
			HotelApplication hotelApp = (HotelApplication) application.getAttribute("hotelApp");
			
			if (hotelApp == null)
			{
				hotelApp = new HotelApplication();
				
				hotelApp.setFilePaths(
						application.getRealPath(HOTELS_DOCUMENT_PATH),
						application.getRealPath(HOTELS_SCHEMA_PATH));
				
				application.setAttribute("hotelApp", hotelApp);
				System.out.println("==== HotelRestService.getHotelApp(): Instantiated a new HotelApp.");
			}
			
			return hotelApp;
		}
	}

	@Path("/hotels")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Hotels getHotels()
	{
		try
		{
			return getHotelApp().getHotels();
		}
		catch(Exception e)
		{
			System.out.println("==== ERROR: HotelRestService.getHotels(): Coult not get hotel app / hotels.");
			e.printStackTrace();
			return null;
		}
	}
}
