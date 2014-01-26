package me.redfern.jvmvm.vm.instructions;

public enum Instruction {
	
	Const(1, new Const()),
	AddReg(2, new AddReg()),
	SubReg(3, new SubReg()),
	Print(4, new Print());
	
	public Integer opcode;
	public IInstruction instruction;
	
	Instruction(int opcode, IInstruction instruction){
		this.instruction = instruction;
		this.opcode = opcode;
	}
}
