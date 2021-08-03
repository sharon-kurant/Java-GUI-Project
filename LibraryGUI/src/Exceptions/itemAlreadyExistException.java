package Exceptions;

import java.io.Serializable;

public class itemAlreadyExistException extends Exception implements Serializable{
	private static final String error= "item Already Exists: : ";

	public itemAlreadyExistException(String name) {
		super(error + name);
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
