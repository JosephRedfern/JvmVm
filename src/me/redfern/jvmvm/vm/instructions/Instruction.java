package me.redfern.jvmvm.vm.instructions;

public enum Instruction {
	
	Const(1, new Const()),
	AddReg(2, new AddReg()),
	Print(3, new Print());
	
	public Integer opcode;
	public AbstractInstruction instruction;
	
	Instruction(int opcode, AbstractInstruction instruction){
		this.instruction = instruction;
		this.opcode = opcode;
	}
}
