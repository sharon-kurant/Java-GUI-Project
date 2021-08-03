package Model;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Reader extends LibraryUser{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7101764953520792198L;
	private String id;
	private String password;
	
	public Reader(String fName, String lName) {
		super(fName, lName);
	}
	
	public Reader(String fName, String lName, String id, String password) {
		super(fName, lName);
		this.id = id;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "reader name: " + this.getfName() + " "+ this.getlName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
}
