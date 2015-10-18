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

public class AuthorApplicaion extends GenericApplication<Authors>
{
	public static final String
		AUTHORS_DOCUMENT_PATH = "WEB-INF/authors.xml",
		AUTHORS_SCHEMA_PATH = "WEB-INF/authors.xsd";

	public AuthorApplicaion()
	{
		// TODO Auto-generated constructor stub
		jaxbClass = Authors.class;
	}
	
	public Author login(String email, String password)
	{
		return resource.login(email, password);
	}
	
	public Authors getAuthors()
	{
		return this.resource;
	}
	
	public Author getAuthor(long id)
	{
		return resource.getAuthor(id);
	}
	
	public Authors filterById(long id)
	{
		if(resource == null)
			System.out.println("==== Resource null in filterById of AuthorApp");
		
		return resource.filterById(id);
	}
}
