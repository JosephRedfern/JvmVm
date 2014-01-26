package me.redfern.jvmvm.vm.instructions;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;
import me.redfern.jvmvm.vm.Register;
import me.redfern.jvmvm.vm.VmContext;
import me.redfern.jvmvm.vm.instructions.formats.Format2R;

/***
 * Opcode 0x01, FORMAT_2R
 * 1 N rM
 * Give rM value N. 
 * 
 * @author Joseph Redfern
 */
public class Const extends Format2R implements IInstruction{
	private int value;
	private Register destReg;
	
	public IInstruction getInstance(int ip, int[] intcode) throws InvalidRegisterException{
		return new Const(ip, intcode);
	}
	
	public Const(){
		
	}
	
	public Const(int ip, int[] intcode) throws InvalidRegisterException{
		populateRegisters(ip, intcode);
	}
	
	private void populateRegisters(int ip, int[] intcode) throws InvalidRegisterException{
		this.value = intcode[ip+1];
		this.destReg = VmContext.getRegister(intcode[ip+2]);
	}

	@Override
	public void execute() throws InvalidRegisterException {
		int result = this.destReg.getValue() + this.value;
		this.destReg.setValue(result);
	}
}
 