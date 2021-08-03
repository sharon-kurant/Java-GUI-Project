package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import Utils.Topic;

public class LibraryCollection implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2229186591449921355L;
	protected String name;
	private static int idPlusPlus;
	protected int id;
	protected HashMap<String, LibraryItem> items;
	
	public LibraryCollection(String name) {
		this.name = name;
		this.id = ++idPlusPlus;
		this.items = new HashMap<String, LibraryItem>();
	}
	// ----------------------------------------GETTERS&SETTERS----------------------------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public HashMap<String, LibraryItem> getItems() {
		return items;
	}

	public void setItems(HashMap<String, LibraryItem> items) {
		this.items = items;
	}
	
	//----------------------------------------METHODS-------------------------------------------

	public boolean addItemToCollection(LibraryItem item) {
		String name = item.getName();
		if (items.get(name) != null)
			return false;
		return items.put(name, item)==null;
	}
	
	public ArrayList<Topic> getTopics(){
		ArrayList<Topic> topics = new ArrayList<Topic>();
		for (LibraryItem item: items.values()) {
			topics.add(item.getTopic());
		}
		return topics;
	}
	public Set<Author> getAuthors(){
		Set<Author> authors = new HashSet<Author>();
		
		
		
		items.values().forEach(item -> authors.add(item.getAuthor()));
		return authors;
	}
	
	public LibraryItem getBest(ScoreCalculator calc) {
		TreeSet<LibraryItem> best = new TreeSet<LibraryItem>(new Comparator<LibraryItem>() {
			@Override
			public int compare(LibraryItem i1, LibraryItem i2) {
				return (i1.getAvgRate(calc).compareTo(i2.getAvgRate(calc)));
			}
		});
		return best.last();
	}
	
	@Override
	public String toString() {
		return "collection name: "+this.getName() + this.id;
	}
}
