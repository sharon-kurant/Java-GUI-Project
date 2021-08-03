package Exceptions;

import java.io.Serializable;

public class AuthorNotExistException extends Exception implements Serializable{
	private static final String error= "author does not Exist: ";

	public AuthorNotExistException(String name) {
		super(error + name);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
