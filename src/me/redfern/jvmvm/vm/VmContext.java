package me.redfern.jvmvm.vm;

import java.util.ArrayList;

public class VmContext {
	public VmContext(){
		
	}
	
	private static ArrayList<Register> registers = new ArrayList<Register>();
	
	public static Register getRegister(int n){
		return registers.get(n);
	}
}
