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

public class HotelApplication
{
	public static final String
		HOTELS_DOCUMENT_PATH = "WEB-INF/hotels.xml",
		HOTELS_SCHEMA_PATH = "WEB-INF/hotels.xsd";
	
	private String documentPath;
	private Hotels hotels;
	
	private JAXBContext jc;

	public HotelApplication()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Hotels getHotels()
	{
		return hotels;
	}
	
	/**
	 * Marshal the current database to formatted XML,
	 * and save (update) the database file.
	 */
	public void updateDatabase() throws Exception
	{
		// Obtain the database as a formatted XML document
		String xml = this.produceXML();
		
		// Write the document using a file stream
		FileOutputStream fout = new FileOutputStream(documentPath);
		fout.write(xml.getBytes());
		fout.close();
	}
	
	public String getFilePath()
	{
		return documentPath;
	}

	public void setFilePath(String documentPath) throws JAXBException, IOException, SAXException
	{
		this.documentPath = documentPath;
		
		// Create the unmarshaller
		jc = JAXBContext.newInstance(Hotels.class);
		Unmarshaller u = jc.createUnmarshaller();
		
		// Provide the "Hotels" schema to the unmarshaller
		/*
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        Schema schema = sf.newSchema(new File(schemaPath)); 
        u.setSchema(schema);
        */
		 
		// Now unmarshal the object from the file
		FileInputStream documentFin = new FileInputStream(documentPath);
		hotels = (Hotels)u.unmarshal(documentFin);
		documentFin.close();
	}
	
	/**
	 * Produces (marshalls) XML from the HotelApplication's existing set of hotels.
	 * @return The list of hotels, formatted as XML.
	 */
	public String produceXML() throws Exception
	{
		if(jc == null)
			throw new Exception("The JAXBContext has not been initialized (no database path set)");
		
		// Initialize a marshaller to produce formatted XML from the Hotels List JAXB class
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
		// XML is output to a String stream
		StringWriter xmlString = new StringWriter();
		marshaller.marshal(hotels, xmlString);
			
		return xmlString.toString();
	}
}
