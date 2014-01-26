package me.redfern.jvmvm.vm.instructions;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;

public abstract class AbstractInstruction {
	
	public abstract void execute() throws InvalidRegisterException;
	
	public abstract int getSize();
	
	public abstract AbstractInstruction getInstance(int ip, int[] intcode) throws InvalidRegisterException; //ip==Instruction Pointer
}