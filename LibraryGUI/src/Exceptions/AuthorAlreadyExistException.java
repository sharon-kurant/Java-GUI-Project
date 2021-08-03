package Exceptions;

import java.io.Serializable;

public class AuthorAlreadyExistException extends Exception implements Serializable{
	private static final String error= "author Already Exists: ";

	public AuthorAlreadyExistException(String name) {
		super(error + name);
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
