package uts.wsd.teamtwo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.xml.sax.SAXException;

public abstract class GenericApplication <DTO>
{
	private String documentPath;
	private JAXBContext jc;
	protected DTO resource;
	
	protected Class<DTO> jaxbClass;

	public GenericApplication()
	{
		// TODO Auto-generated constructor stub
	}
	
	public String getFilePath() {
		return documentPath;
	}

	/**
	 * Marshal the current database to formatted XML, and save (update) the
	 * database file.
	 */
	public void updateDatabase() throws Exception {
		// Obtain the database as a formatted XML document
		String xml = this.produceXML();

		// Write the document using a file stream
		FileOutputStream fout = new FileOutputStream(documentPath);
		fout.write(xml.getBytes());
		fout.close();
	}
	
	public void setFilePath(String documentPath) {
		this.documentPath = documentPath;
		
		try
		{
			// Create the unmarshaller
			jc = JAXBContext.newInstance(jaxbClass);
			Unmarshaller u = jc.createUnmarshaller();

			// Now unmarshal the object from the file
			FileInputStream documentFin = new FileInputStream(documentPath);
			resource = (DTO)u.unmarshal(documentFin);
			documentFin.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Produces (marshalls) XML from the application's existing set of data.
	 * 
	 * @return The application's data, formatted as XML.
	 */
	public String produceXML() throws Exception
	{
		return produceXMLFor(this.resource);
	}
	
	/**
	 * Produces (marshalls) XML from a set of data.
	 * @param data The data to format to XML
	 * @return The data formatted as XML
	 */
	public String produceXMLFor(DTO data) throws Exception
	{
		if (jc == null)
			throw new Exception("The JAXBContext has not been initialized (no database path set)");

		// Initialize a marshaller to produce formatted XML from the Hotels List
		// JAXB class
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// XML is output to a String stream
		StringWriter xmlString = new StringWriter();
		marshaller.marshal(data, xmlString);

		return xmlString.toString();
	}
}
