package Exceptions;

import java.io.Serializable;

public class ReaderAlreadyExistException extends Exception implements Serializable{
	private static final String error= "Reader Already Exists: ";

	public ReaderAlreadyExistException(String name) {
		super(error + name);
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
