package me.redfern.jvmvm.vm.instructions;

public enum Instruction {
	AddReg(1, new AddReg());
	
	public Integer opcode;
	public AbstractInstruction instruction;
	
	Instruction(int opcode, AbstractInstruction instruction){
		this.instruction = instruction;
		this.opcode = opcode;
	}
}
