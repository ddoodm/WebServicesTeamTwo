package uts.wsd.teamtwo.JAXB;

import java.io.Serializable;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Author implements Serializable{
    
	@XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "unsignedInt")
    @XmlJavaTypeAdapter(IDAutoIncrementAdapter.class)
    protected Integer id;
    @XmlElement(required = true)
	private String name;
    @XmlElement(required = true)
	private String email;
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
