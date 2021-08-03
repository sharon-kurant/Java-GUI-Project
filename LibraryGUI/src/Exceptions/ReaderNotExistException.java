package Exceptions;

import java.io.Serializable;

public class ReaderNotExistException extends Exception implements Serializable{
	private static final String error= "Reader does not Exist: ";

	public ReaderNotExistException(String name) {
		super(error + name);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
