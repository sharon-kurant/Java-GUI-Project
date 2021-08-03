package Exceptions;

import java.io.Serializable;

public class LibrarianNotExistException extends Exception implements Serializable{
	private static final String error= "Librarian does not Exist: ";

	public LibrarianNotExistException(String name) {
		super(error + name);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
