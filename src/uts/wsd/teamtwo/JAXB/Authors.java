package uts.wsd.teamtwo.JAXB;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "authors")
public class Authors implements Serializable {
	@XmlElement(name = "author")
	private ArrayList<Author> list = new ArrayList<Author>();

	public Authors() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Author> getList() {
		return list;
	}

	public void setList(ArrayList<Author> list) {
		this.list = list;
	}

	public Author login(String email, String password) {
		for (Author author : list) {
			if (author.getEmail().equals(email) && author.getPassword().equals(password))
				return author; 
		}
		return null; 
	}

	public Author getAuthor(String email) {
		for (Author author : list) {
			if (author.getEmail().equals(email))
				return author;
		}
		return null;
	}
}
