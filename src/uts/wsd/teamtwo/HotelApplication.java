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

public class HotelApplication
{
	public static final String
	HOTELS_DOCUMENT_PATH = "WEB-INF/hotels.xml",
	HOTELS_SCHEMA_PATH = "WEB-INF/hotels.xsd",
	AUTHORS_DOCUMENT_PATH = "WEB-INF/authors.xml";

	private String documentPath/*, schemaPath*/,filePath;
	private Hotels hotels;
	private Authors authors;

	private JAXBContext jc;
	private JAXBContext jc2;

	public HotelApplication()
	{
		// TODO Auto-generated constructor stub
	}

	public void updateDatabase() throws Exception
	{
		if(jc == null)
			throw new Exception("The JAXBContext has not been initialized (no database path set)");

		Marshaller m = jc.createMarshaller();

		FileOutputStream fout = new FileOutputStream(documentPath);
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(hotels, fout);
	}

	public String getDocumentPath()
	{
		return documentPath;
	}

	/*
	public String getSchemaPath()
	{
		return schemaPath;
	}
	 */
	/*public void setAuthorFilePath(String filePath) throws JAXBException, IOException {
		this.filePath = filePath;
		// This is the file path given to us.
		// We should use it

		// Load the users from the XML file...
		JAXBContext jc = JAXBContext.newInstance(Authors.class);
		Unmarshaller u = jc.createUnmarshaller();
		FileInputStream fin = new FileInputStream(filePath); // use the given file path
		authors = (Authors)u.unmarshal(fin); // This loads the "users" object
		fin.close();
	}*/

	public void setFilePath(String documentPath/*, String schemaPath*/) throws JAXBException, IOException, SAXException
	{
		this.documentPath = documentPath;

		/*this.schemaPath = schemaPath;*/

		// Create the unmarshaller
		if (documentPath.contains("hotels")){
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
		} else if (documentPath.contains("authors")){
			jc2 = JAXBContext.newInstance(Authors.class);
			Unmarshaller u = jc2.createUnmarshaller();
			FileInputStream fin = new FileInputStream(documentPath); // use the given file path
			authors = (Authors)u.unmarshal(fin); // This loads the "users" object
			fin.close();
		}
	}

	public Hotels getHotels()
	{
		return hotels;
	}

	public Authors getAuthors()
	{
		return authors;
	}
	/**
	 * Produces (marshalls) XML from the HotelApplication's existing set of hotels.
	 * @return The list of hotels, formatted as XML.
	 */
	public String produceXML()
	{
		try
		{
			// Initialize a marshaller to produce formatted XML from the Hotels List JAXB class
			JAXBContext jc = JAXBContext.newInstance(Hotels.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// XML is output to a String stream
			StringWriter xmlString = new StringWriter();
			marshaller.marshal(hotels, xmlString);

			return xmlString.toString();
		}
		catch (JAXBException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
