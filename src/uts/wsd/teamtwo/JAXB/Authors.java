package uts.wsd.teamtwo.JAXB;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The DTO that describes a collection of Author.
 * Used for database storage, manipulation and XSLT display.
 * 
 * @author Abraham Silva
 * @author Deinyon L Davies
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "authors")
public class Authors implements Serializable
{
	/*
	 * The collection of authors as an ArrayList
	 */
	@XmlElement(name = "author")
	private ArrayList<Author> list = new ArrayList<Author>();

	public Authors() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Initialize an Author collection from a list of Author
	 * @see Author
	 * @param list The list of Authors from which to create the collection
	 */
	public Authors(ArrayList<Author> list)
	{
		this.list = list;
	}
	
	/**
	 * @return The collection of Author as an ArrayList
	 */
	public ArrayList<Author> getList() {
		return list;
	}

	/**
	 * Obtains the Author with the given E-Mail address and password pair
	 * @param email The E-Mail address of the author to locate
	 * @param password The password of the author to locate
	 * @return The author with the given E-Mail and password if found, null otherwise
	 * @see Author
	 */
	public Author login(String email, String password) {
		for (Author author : list) {
			if (author.getEmail().equals(email) && author.getPassword().equals(password))
				return author; 
		}
		return null; 
	}

	/**
	 * Obtains the author with the given E-Mail
	 * @param email The E-Mail address of the author to locate
	 * @return The author with the given E-Mail address, null if not found
	 */
	public Author getAuthor(String email) {
		for (Author author : list) {
			if (author.getEmail().equals(email))
				return author;
		}
		return null;
	}
	
	/**
	 * Obtains the author with the given ID number
	 * @param id The ID number of the author to locate
	 * @return The Author with the given ID number, null otherwise
	 */
	public Author getAuthor(long id) {
		for (Author author : list) {
			if (author.getId() == id)
				return author;
		}
		return null;
	}
	
	/**
	 * Filters the list to a collection of <b>one</b> Author with the given ID.
	 * Used for XSLT transformation where a single Author is required
	 * @param id The ID number of the Author to display
	 * @return A collection of one Author with the given ID number
	 */
	public Authors filterById(long id)
	{
		ArrayList<Author> filteredList = new ArrayList<Author>();
		filteredList.add(getAuthor(id));
		return new Authors(filteredList);
	}
}
