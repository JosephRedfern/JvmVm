package me.redfern.jvmvm.vm;

import java.util.ArrayList;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;

public class VmContext {
	private static ArrayList<Register> registers = new ArrayList<Register>();
	private static int regCount;
	
	public VmContext(int n){
		
	}
	
	public static Register getRegister(int n) throws InvalidRegisterException{
		if(n<regCount && n < registers.size()){
			return registers.get(n);
		}else if(n>=registers.size()){
			throw new InvalidRegisterException("Null Pointer Exception - register value undefined");
		}else{
			throw new InvalidRegisterException("Invalid Register");
		}
	}
}
