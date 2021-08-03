package Exceptions;

import java.io.Serializable;

public class itemNotExistException extends Exception implements Serializable{
	private static final String error= "item does not Exist: : ";

	public itemNotExistException(String name) {
		super(error + name);
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
