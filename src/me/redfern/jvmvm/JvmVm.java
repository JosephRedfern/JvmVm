package me.redfern.jvmvm;

import java.util.HashMap;

import me.redfern.jvmvm.exceptions.InvalidBytecodeException;
import me.redfern.jvmvm.exceptions.InvalidRegisterException;
import me.redfern.jvmvm.vm.VmContext;
import me.redfern.jvmvm.vm.instructions.AbstractInstruction;
import me.redfern.jvmvm.vm.instructions.Instruction;

public class JvmVm {
	int[] intcode;
	
	public static void main(String args[]) throws InvalidBytecodeException, InvalidRegisterException{
		JvmVm vm = new JvmVm(new int[]{1333333337, 1, 1, 0, 0}); //temp
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
		HashMap<Integer, AbstractInstruction> mapping = generateInstructionMapping();
		System.err.println(mapping);
		
		int ip = 2;
		while(ip<this.intcode.length){
			AbstractInstruction i = mapping.get(intcode[ip]).getInstance(ip, intcode);
			System.out.println(i);
			i.execute();
			ip += i.getSize();
		}
	}
	
	public static HashMap<Integer, AbstractInstruction> generateInstructionMapping(){
		HashMap<Integer, AbstractInstruction> mapping = new HashMap<Integer, AbstractInstruction>();
		
		for(Instruction i : Instruction.values()){
			mapping.put(i.opcode, i.instruction);
		}
		
		return mapping;
	}
}