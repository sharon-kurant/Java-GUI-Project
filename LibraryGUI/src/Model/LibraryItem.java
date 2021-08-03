package Model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Utils.Topic;

public class LibraryItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8033740454264307844L;
	protected String name;
	protected Topic topic;
	protected Author author;
	protected HashSet<Review> reviews;
	protected HashMap<String,Reader> readers;
	
	public LibraryItem(String name, Topic topic, Author author) {
		this.name = name;
		this.topic = topic;
		this.author = author;
		this.reviews = new HashSet<Review>();
		this.readers = new HashMap<String, Reader>();
	}
	
	public LibraryItem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public HashSet<Review> getReviews() {
		return reviews;
	}

	public void setReviews(HashSet<Review> reviews) {
		this.reviews = reviews;
	}

	public HashMap<String, Reader> getReaders() {
		return readers;
	}

	public void setReaders(HashMap<String, Reader> readers) {
		this.readers = readers;
	}

	public boolean addReader(Reader reader) {
		String name = reader.getfName() + " " + reader.getlName();
		if (this.getReaders().containsKey(name))
			return false;
		return readers.put(name, reader)==null;
	}
	
	public boolean removeReader(Reader toRemove) {
		String name = toRemove.getfName() + " " + toRemove.getlName();
		if (!this.getReaders().containsKey(name))
			return false;
		return readers.remove(name)!=null;
	}
	
	public boolean addReview(Review review) {
		if (review == null)
			return false;
		for (Review rev: reviews) {
			if (rev.equals(review))
				return false;
		}
		return reviews.add(review);
	}
	
	public boolean isReviewByReader(String name){
		if (name == null)
			return false;
		for (Review rev: reviews) {
			String toCheck = rev.getfName() + " " + rev.getlName();
			if (toCheck.equals(name))
				return true;
		}
		return false;
	}
	
	public Double getAvgRate(ScoreCalculator calc) {
		return calc.scoreCalc(this);
	}
}
