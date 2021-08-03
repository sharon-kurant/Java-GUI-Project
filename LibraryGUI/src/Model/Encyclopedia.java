package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Encyclopedia extends LibraryCollection{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2477751248790424885L;
	public Encyclopedia(String name) {
		super(name);
	}
	@Override
	public String toString() {
		return "encyclopedia name: "+this.getName();
	}
	
	public ArrayList<Book> getBooks() {
		ArrayList<Book> toReturn = new  ArrayList<Book>();
		for (LibraryItem li : super.getItems().values()) {
			if (li instanceof Book) {
				toReturn.add((Book)li);
			}
		}
		return toReturn;
	}
}
