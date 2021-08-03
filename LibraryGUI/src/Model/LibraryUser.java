package Model;

import java.io.Serializable;
import java.util.HashMap;

public class LibraryUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8869440864951081985L;
	protected String fName;
	protected String lName;
	protected HashMap<String, LibraryItem> items;
	
	public LibraryUser(String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.items = new HashMap<String, LibraryItem>();
	}
	//        GETTERS&SETTERS
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public HashMap<String, LibraryItem> getItems() {
		return items;
	}
	public void setItems(HashMap<String, LibraryItem> items) {
		this.items = items;
	}
	
	
	// 		AddItemMethod
	
	public boolean addItem(LibraryItem toAdd) {
		String name = toAdd.getName();
		if (items.containsKey(name))
			return false;
		return items.put(name, toAdd)==null;
	}
	
	public boolean removeItem(LibraryItem toRemove) {
		String name = toRemove.getName();
		if (!items.containsKey(name)) {
			return false;
		}
		this.items.remove(name);
		return true;
	}
	
	public boolean equals(LibraryUser lu) {
		if (this.getfName().equals(lu.getfName()) && 
				this.getlName().equals(lu.getlName()))
			return true;
		return false;
	}
	
}
