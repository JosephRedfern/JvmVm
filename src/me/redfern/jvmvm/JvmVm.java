package me.redfern.jvmvm;

import java.util.HashMap;

import me.redfern.jvmvm.exceptions.InvalidBytecodeException;
import me.redfern.jvmvm.exceptions.InvalidRegisterException;
import me.redfern.jvmvm.vm.VmContext;
import me.redfern.jvmvm.vm.instructions.IInstruction;
import me.redfern.jvmvm.vm.instructions.Instruction;

public class JvmVm {
	int[] intcode;
	
	public static void main(String args[]) throws InvalidBytecodeException, InvalidRegisterException{
		JvmVm vm = new JvmVm(new int[]{
				1333333337, //magic
				3, //3 instructions
				1, 10, 0, //move 10 to r0
				1, 20, 1, //move 20 to r1
				1, 7, 2, //move 7 to r2
				2, 0, 1, // add r0 to r1
				3, 2, 1, //subtract r2 from r1
				4, 2, 1, //Multiply r1 by r2
				6, 1}); //print r1
		
		vm.run();
	}
	
	public JvmVm(int[] intcode) throws InvalidBytecodeException{
		this.intcode = intcode;
		if(intcode[0]!=1333333337){
			throw new InvalidBytecodeException("Invalid Magic - expecting 1333333337, got "+intcode[0]);
		}else{
			new VmContext(intcode[1]);
		}
	}

	/***
	 * run loop goes here... ip=0 look at intcode[ip], look up instruction,
	 * execute instruction, ip+=sizeof(instruction[ip]), repeat while 
	 * ip<sizeof(intcode)
	 * @throws InvalidRegisterException 
	 */
	public void run() throws InvalidRegisterException{
		HashMap<Integer, IInstruction> mapping = generateInstructionMapping();
		
		int ip = 2;
		while(ip<this.intcode.length){
			IInstruction i = mapping.get(intcode[ip]).getInstance(ip, intcode);
			i.execute();
			ip += i.getSize();
		}
	}
	
	public static HashMap<Integer, IInstruction> generateInstructionMapping(){
		HashMap<Integer, IInstruction> mapping = new HashMap<Integer, IInstruction>();
		
		for(Instruction i : Instruction.values()){
			mapping.put(i.opcode, i.instruction);
		}
		
		return mapping;
	}
}