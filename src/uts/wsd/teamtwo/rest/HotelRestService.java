package uts.wsd.teamtwo.rest;

import uts.wsd.teamtwo.*;
import uts.wsd.teamtwo.JAXB.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

@Path("")
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
	
	/**
	 * Generates a set of hotels, filtered by all (may be null) of the parameters.
	 * @param name The partial name of the matching hotel (match will <b>contain</b> 'name' in its name.
	 * @param country The country of the matching hotel.
	 * @return The set of hotels that has been filtered by the parameters.
	 */
	@Path("/search")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Hotels searchHotels(
			@QueryParam("name") String name,
			@QueryParam("country") String country)
	{
		Hotels unfilteredHotels;
		
		// Get unfiltered set of hotels from the hotel application
		try
		{
			unfilteredHotels = getHotelApp().getHotels();
		}
		catch (JAXBException | IOException | SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		// (Working hotel set)
		Hotels filteredHotels = unfilteredHotels;
		
		// Filter by the parameter(s) supplied
		if(name != null && !name.isEmpty())
			filteredHotels = filteredHotels.filterByName(name);
		if(country != null && !country.isEmpty())
			filteredHotels = filteredHotels.filterByCountry(country);
		
		return filteredHotels;
	}
}
