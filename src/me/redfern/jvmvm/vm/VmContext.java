package me.redfern.jvmvm.vm;

import java.util.HashMap;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;

public class VmContext {
	private static HashMap<Integer, Register> registers = new HashMap<Integer, Register>();
	private static int regCount;
	
	public VmContext(int n){
		regCount = n;
		allocateRegisters(n);
	}
	
	public static void allocateRegisters(int n){
		for(int i=0; i<n; i++){
			registers.put(i, new Register()); //default to 0...
		}
	}
	
	public static Register getRegister(int n) throws InvalidRegisterException{
		if(n<regCount){
			return registers.get(n);
		}else{
			throw new InvalidRegisterException("Invalid Register ("+n+")");
		}
	}
}
