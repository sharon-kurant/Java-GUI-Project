package Model;

import java.io.Serializable;

import Utils.AcademicBook;
import Utils.BookSize;
import Utils.Topic;

public class Book extends LibraryItem{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4594957295668380258L;
	protected BookSize bookSize;
	protected AcademicBook academicBook;
	
	public Book(String name, Topic topic, Author author, BookSize bookSize, AcademicBook academicBook) {
		super(name, topic, author);
		this.bookSize = bookSize;
		this.academicBook = academicBook;
	}
	public Book(String name) {
		super(name);
	}
	//  GETTERS&SETTERS
	public BookSize getBookSize() {
		return bookSize;
	}

	public void setBookSize(BookSize bookSize) {
		this.bookSize = bookSize;
	}

	public AcademicBook getAcademicBook() {
		return academicBook;
	}

	public void setAcademicBook(AcademicBook academicBook) {
		this.academicBook = academicBook;
	}
	
	//		METHODS
	
	@Override
	public String toString() {
		return "book name: "+this.getName();
	}
	
	
}
