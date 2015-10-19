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
 * The DAO which exposes functionality for manipulating and accessing the Authors database
 * @author Deinyon L Davies
 * @author Abraham Silva
 * @see Authors
 * @see Author
 */
public class AuthorApplicaion extends GenericApplication<Authors>
{
	/**
	 * The server-relative path to the Authors XML database
	 */
	public static final String
		AUTHORS_DOCUMENT_PATH = "WEB-INF/authors.xml",
		AUTHORS_SCHEMA_PATH = "WEB-INF/authors.xsd";

	public AuthorApplicaion()
	{
		// TODO Auto-generated constructor stub
		jaxbClass = Authors.class;
	}
	
	/**
	 * Obtains a user from a username / password pair
	 * @param email The E-Mail address of the user that should be returned
	 * @param password The password of the user that should be returned
	 * @return The author with the given username and password
	 */
	public Author login(String email, String password)
	{
		return resource.login(email, password);
	}
	
	/**
	 * @return All authors in the database
	 */
	public Authors getAuthors()
	{
		return this.resource;
	}
	
	/**
	 * @param id The ID number of the author to return
	 * @return The author with the given ID
	 */
	public Author getAuthor(long id)
	{
		return resource.getAuthor(id);
	}
	
	/**
	 * Filters the list of authors by an ID number.
	 * One author will remain.
	 * @param id The ID of the author to find
	 * @return A list containing only the author with the given ID
	 */
	public Authors filterById(long id)
	{
		return resource.filterById(id);
	}
}
