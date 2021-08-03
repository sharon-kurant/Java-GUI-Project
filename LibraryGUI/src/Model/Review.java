package Model;

import java.io.Serializable;

public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8869963673628114420L;
	protected String fName;
	protected String lName;
	protected String bookName;
	protected String reviewSentence;
	protected int rate;
	
	public Review(String fName, String lName, String bookName, String reviewSentence, int rate) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.bookName = bookName;
		this.reviewSentence = reviewSentence;
		this.rate = rate;
	}
	
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

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getReviewSentence() {
		return reviewSentence;
	}

	public void setReviewSentence(String reviewSentence) {
		this.reviewSentence = reviewSentence;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Review))
			return false;
		Review r = (Review) obj;
		if (this.getfName().equals(r.getfName()) && this.getlName().equals(r.getlName()))
			return true;
		return false;
	}
}
