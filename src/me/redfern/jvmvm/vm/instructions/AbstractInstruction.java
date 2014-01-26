package me.redfern.jvmvm.vm.instructions;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;

public abstract class AbstractInstruction {
	private int size;
	
	public abstract void execute();
	
	public int getSize(){
		return this.size;
	}
	
	public abstract AbstractInstruction getInstance(int ip, int[] intcode) throws InvalidRegisterException; //ip==Instruction Pointer
}