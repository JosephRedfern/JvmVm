package me.redfern.jvmvm.vm.instructions;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;

public interface IInstruction {
	
	public abstract void execute() throws InvalidRegisterException;
	
	public abstract int getSize();
	
	public abstract IInstruction getInstance(int ip, int[] intcode) throws InvalidRegisterException; //ip==Instruction Pointer
}