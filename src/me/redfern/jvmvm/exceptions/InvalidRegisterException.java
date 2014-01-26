package me.redfern.jvmvm.exceptions;

public class InvalidRegisterException extends Exception {
	private static final long serialVersionUID = -2892677837274121188L;

	public InvalidRegisterException(String message){
		super(message);
	}
	
	public InvalidRegisterException(){
		super();
	}
}
