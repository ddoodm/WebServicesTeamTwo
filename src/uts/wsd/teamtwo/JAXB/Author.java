package uts.wsd.teamtwo.JAXB;

import java.io.Serializable;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * The DTO that describes an Author.
 * Used for database storage, manipulation and XSLT display.
 * 
 * @author Abraham Silva
 * @see Authors
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Author implements Serializable
{
	/**
	 * The ID number of this author.
	 * The ID is automatically incremented by a custom
	 * JAXB type adapter.
	 * @see IDAutoIncrementAdapter
	 */
	@XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "unsignedInt")
    @XmlJavaTypeAdapter(IDAutoIncrementAdapter.class)
    protected Integer id;
	
	/**
	 * The author's full name
	 */
    @XmlElement(required = true)
	private String name;
    
    /**
     * The author's E-Mail address
     */
    @XmlElement(required = true)
	private String email;
    
    /**
     * The author's password in plain-text
     */
    @XmlElement(required = true)
	private String password;

	public Author() {
		// TODO Auto-generated constructor stub
	}
	public Author(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    public long getId() {
        return id;
    }

}
