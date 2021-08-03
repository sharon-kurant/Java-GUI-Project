package Model;

import java.io.Serializable;

import Utils.Topic;

public class Author extends LibraryUser{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4143026017452320929L;
	protected Topic topic;

	public Author(String fName, String lName, Topic topic) {
		super(fName, lName);
		this.topic = topic;
	}
	public Author(String fName, String lName) {
		super(fName, lName);
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	@Override
	public String toString() {
		return this.getfName() + " "+ this.getlName();
	}
	
	public int NumReaders() {
		int sum = 0;
		for (LibraryItem item: this.getItems().values()) {
			sum+=item.getReaders().size();
		}
		return sum;
	}
}
