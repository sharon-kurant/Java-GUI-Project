package Model;

public class Librarian extends LibraryUser{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5758876110691353891L;
	private String id;
	private String password;
	
	public Librarian(String fName, String lName, String id, String password) {
		super(fName, lName);
		this.id = id;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "librarian name: " + this.getfName() + " "+ this.getlName();
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
