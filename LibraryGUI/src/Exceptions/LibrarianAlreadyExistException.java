package Exceptions;

import java.io.Serializable;

public class LibrarianAlreadyExistException extends Exception implements Serializable {
	private static final String error= "Librarian Already Exists: ";

	public LibrarianAlreadyExistException(String name) {
		super(error + name);
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
