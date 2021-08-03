package Model;

import java.util.ArrayList;

public class Magazine extends LibraryCollection{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5197166823179547802L;

	public Magazine(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return "magazine name: "+this.getName();
	}
	
	public ArrayList<Paper> getPapers() {
		ArrayList<Paper> toReturn = new  ArrayList<Paper>();
		for (LibraryItem li : super.getItems().values()) {
			if (li instanceof Paper) {
				toReturn.add((Paper)li);
			}
		}
		return toReturn;
	}
	
}
