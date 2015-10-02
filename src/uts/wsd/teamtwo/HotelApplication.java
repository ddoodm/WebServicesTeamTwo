package uts.wsd.teamtwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import uts.wsd.teamtwo.JAXB.*;

public class HotelApplication
{
	private String documentPath;
	private Hotels hotels;
	
	private JAXBContext jc;

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
	
	public String getFilePath() {
		return documentPath;
	}

	public void setFilePaths(String documentPath, String schemaPath) throws JAXBException, IOException, SAXException
	{
		this.documentPath = documentPath;
		
		// Create the unmarshaller
		jc = JAXBContext.newInstance(Hotels.class);
		Unmarshaller u = jc.createUnmarshaller();
		
		// Provide the "Hotels" schema to the unmarshaller
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        Schema schema = sf.newSchema(new File(schemaPath)); 
        u.setSchema(schema);
		 
		// Now unmarshal the object from the file
		FileInputStream documentFin = new FileInputStream(documentPath);
		hotels = (Hotels)u.unmarshal(documentFin);
		documentFin.close();
	}

	public Hotels getHotels() {
		return hotels;
	}

	public void setUsers(Hotels hotels) {
		this.hotels = hotels;
	}
}