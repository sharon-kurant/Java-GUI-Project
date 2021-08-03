package Model;

import Utils.PaperValue;
import Utils.Topic;

public class Paper extends LibraryItem{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3860037427578460711L;
	protected PaperValue paperValue;
	protected String university;

	public Paper(String name, Topic topic, Author author, PaperValue paperValue, String university) {
		super(name, topic, author);
		this.paperValue = paperValue;
		this.university = university;
	}
	
	public Paper(String name) {
		super(name);
	}

	public PaperValue getPaperValue() {
		return paperValue;
	}

	public void setPaperValue(PaperValue paperValue) {
		this.paperValue = paperValue;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}
	
	//	METHODS

	@Override
	public String toString() {
		return "paper name: "+this.getName();
	}
	
}
