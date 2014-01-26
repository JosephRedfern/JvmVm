package me.redfern.jvmvm.vm;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;

public class Register {
	private int value = 0;
	
	public Register(){
	}
	
	public int getValue() throws InvalidRegisterException{
		return value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public String toString(){
		return "<Register #"+this.value+">";
	}
}
