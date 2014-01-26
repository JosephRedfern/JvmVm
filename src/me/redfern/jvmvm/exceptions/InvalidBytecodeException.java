package me.redfern.jvmvm.exceptions;

public class InvalidBytecodeException extends Exception{
	private static final long serialVersionUID = 987095836266724978L;

	public InvalidBytecodeException(String message){
		super(message);
	}
}
