package me.redfern.jvmvm.vm.instructions;

public enum Instruction {
	
	Const(1, new Const()),
	AddReg(2, new AddReg()),
	SubReg(3, new SubtractReg()),
	MultiplyReg(4, new MultiplyReg()),
	DivideReg(5, new DivideReg()),
	Print(6, new Print());
	
	public Integer opcode;
	public IInstruction instruction;
	
	Instruction(int opcode, IInstruction instruction){
		this.instruction = instruction;
		this.opcode = opcode;
	}
}
