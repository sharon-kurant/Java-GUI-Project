package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

import Utils.Topic;

public class Recommender implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Recommender RECOMMENDER;
	private HashMap<Reader, HashMap<Topic,Integer>> topicMap;
	//private HashMap<String, Reader> readers;
	
	public static Recommender getInstance() {
		if (RECOMMENDER == null) {
			RECOMMENDER= new Recommender();
		}
		return RECOMMENDER;
	}

	public Recommender() {
	}
	
	//===============================Methods receives Reader and returns his Ordered Topic/Author Map============================= 
	
	private HashMap<Topic,Integer> updateTopicMap(Reader reader) {
		HashMap<Topic, Integer> toReturn = new HashMap<Topic, Integer>();
		for (LibraryItem item: reader.getItems().values()) {
			if (!toReturn.containsKey(item.getTopic())) {
				toReturn.put(item.getTopic(), 1);
			}else toReturn.put(item.getTopic(), toReturn.get(item.getTopic())+1);
		}
		return toReturn;
	}
	
	private HashMap<Author,Integer> updateAuthorMap(Reader reader) {
		HashMap<Author, Integer> toReturn = new HashMap<Author, Integer>();
		for (LibraryItem item: reader.getItems().values()) {
			if (!toReturn.containsKey(item.getAuthor())) {
				toReturn.put(item.getAuthor(), 1);
			}else toReturn.put(item.getAuthor(), toReturn.get(item.getAuthor())+1);
		}
		return toReturn;
	}
	
	//==================Method receives all the items in the library and sorts it according to ScoreCalculator==============
	
	public ArrayList<LibraryItem> sortItems(ScoreCalculator score,HashMap<String, LibraryItem> items){
		ArrayList<LibraryItem> orderedItems = new ArrayList<LibraryItem>(items.values());
		orderedItems.sort(new Comparator<LibraryItem>() {
			@Override
			public int compare(LibraryItem i1, LibraryItem i2) {
				if (i1.getAvgRate(score) > i2.getAvgRate(score))
					return -1;
				else if (i1.getAvgRate(score) < i2.getAvgRate(score))
					return 1;
				else
					return 0;
			}
		});
		return orderedItems;
	}
	
	//==================================Recommend Books/Papers By Topic=======================================
	
	public ArrayList<Book> recommendBooksByTopic(Reader reader, int k, ScoreCalculator score, HashMap<String, LibraryItem> items){
		HashMap<Topic, Integer> topicCounter = updateTopicMap(reader); //Maps Topics for reader
		ArrayList<Topic> bestTopics = new ArrayList<Topic>();
		bestTopics.addAll(topicCounter.keySet()); //adds all unique topics in reader.getItems();
		bestTopics.sort(new Comparator<Topic>() { //sorts topics by occurrence
			@Override
			public int compare(Topic top1, Topic top2) {
				return topicCounter.get(top1).compareTo(topicCounter.get(top2));
			}
		});
		ArrayList<Book> recBooks = new ArrayList<Book>();
		ArrayList<LibraryItem> orderedItems = sortItems(score,items);
		while (k>0 && !bestTopics.isEmpty()) {
			Topic topic = bestTopics.get(0);
			for (LibraryItem item : orderedItems) {
				if (item instanceof Book && item.getTopic().equals(topic) && !reader.getItems().containsKey(item.getName())) {
					//adds to recBooks if item is by "author" and reader has'nt read it
					recBooks.add((Book) item);
					k--;
					if (k==0)
						return recBooks;
				}
			}
			bestTopics.remove(0);
		}
		return recBooks;
	}
	
	public ArrayList<Paper> recommendPapersByTopic(Reader reader, int k, ScoreCalculator score, HashMap<String, LibraryItem> items){
		HashMap<Topic, Integer> topicCounter = updateTopicMap(reader); //Maps Topics for reader
		ArrayList<Topic> bestTopics = new ArrayList<Topic>();
		bestTopics.addAll(topicCounter.keySet()); //adds all unique authors in reader.getItems();
		bestTopics.sort(new Comparator<Topic>() { //sorts authors by occurrence
			@Override
			public int compare(Topic top1, Topic top2) {
				return topicCounter.get(top1).compareTo(topicCounter.get(top2));
			}
		});
		ArrayList<Paper> recPapers = new ArrayList<Paper>();
		ArrayList<LibraryItem> orderedItems = sortItems(score,items);
		while (k>0 && !bestTopics.isEmpty()) {
			Topic topic = bestTopics.get(0);
			for (LibraryItem item : orderedItems) {
				if (item instanceof Paper && item.getTopic().equals(topic) && !reader.getItems().containsKey(item.getName())) {
					//adds to recPapers if item is by "author" and reader has'nt read it
					recPapers.add((Paper) item);
					k--;
					if (k==0)
						return recPapers;
				}
			}
			bestTopics.remove(0);
		}
		return recPapers;
	}
	
	//==================================Recommend Books/Papers By Author=======================================

	public ArrayList<Paper> recommendPapersByAuthor(Reader reader, int k, ScoreCalculator score, HashMap<String, LibraryItem> items){
		HashMap<Author, Integer> authorCounter = updateAuthorMap(reader); //Maps Authors for reader
		ArrayList<Author> bestAuthors = new ArrayList<Author>();
		bestAuthors.addAll(authorCounter.keySet()); //adds all unique authors in reader.getItems();
		bestAuthors.sort(new Comparator<Author>() { //sorts authors by occurrence
			@Override
			public int compare(Author a1, Author a2) {
				return authorCounter.get(a1).compareTo(authorCounter.get(a2));
			}
		});
		ArrayList<Paper> recPapers = new ArrayList<Paper>();
		ArrayList<LibraryItem> orderedItems = sortItems(score,items); //sorts all items in library
		while (k>0 && !bestAuthors.isEmpty()) {
			Author author = bestAuthors.get(0);
			for (LibraryItem item : orderedItems) {
				if (item instanceof Paper && item.getAuthor().equals(author) && !reader.getItems().containsKey(item.getName()) && !recPapers.contains(item)) {
					//adds to recPapers if item is by "author" and reader has'nt read it
					recPapers.add((Paper) item);
					k--;
					if (k==0)
						return recPapers;
				}
			}
			bestAuthors.remove(0);
		}
		return recPapers;
	}
	
	public ArrayList<Book> recommendBooksByAuthor(Reader reader, int k, ScoreCalculator score, HashMap<String, LibraryItem> items){
		HashMap<Author, Integer> authorCounter = updateAuthorMap(reader); //Maps Authors for reader
		ArrayList<Author> bestAuthors = new ArrayList<Author>();
		bestAuthors.addAll(authorCounter.keySet()); //adds all unique authors in reader.getItems();
		bestAuthors.sort(new Comparator<Author>() { //sorts authors by occurrence
			@Override
			public int compare(Author a1, Author a2) {
				return authorCounter.get(a1).compareTo(authorCounter.get(a2));
			}
		});
		ArrayList<Book> recBooks = new ArrayList<Book>();
		ArrayList<LibraryItem> orderedItems = sortItems(score,items); //sorts all items in library
		while (k>0 && !bestAuthors.isEmpty()) {
			Author author = bestAuthors.get(0);
			for (LibraryItem item : orderedItems) {
				if (item instanceof Book && item.getAuthor().equals(author) && !reader.getItems().containsKey(item.getName()) && !recBooks.contains(item)) {
					//adds to recBooks if item is by "author" and reader has'nt read it
					recBooks.add((Book) item);
					k--;
					if (k==0)
						return recBooks;
				}
			}
			bestAuthors.remove(0);
		}
		return recBooks;
	}
}
