package uts.wsd.teamtwo.soap;

import java.io.Serializable;

public class UserNamePassPair implements Serializable
{
	private String username, password;
	
	public UserNamePassPair(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}
