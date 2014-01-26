package me.redfern.jvmvm.vm.instructions;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;
import me.redfern.jvmvm.vm.Register;
import me.redfern.jvmvm.vm.VmContext;
import me.redfern.jvmvm.vm.instructions.formats.Format2R;

/***
 * Opcode 2, FORMAT_2R
 * 2 rN rM
 * Add rN to rM
 * 
 * @author Joseph Redfern
 */
public class SubtractReg extends Format2R implements IInstruction{
	private Register sourceReg;
	private Register destReg;
	
	public IInstruction getInstance(int ip, int[] intcode) throws InvalidRegisterException{
		return new SubtractReg(ip, intcode);
	}
	
	public SubtractReg(){
		
	}
	
	public SubtractReg(int ip, int[] intcode) throws InvalidRegisterException{
		populateRegisters(ip, intcode);
	}
	
	private void populateRegisters(int ip, int[] intcode) throws InvalidRegisterException{
		this.sourceReg = VmContext.getRegister(intcode[ip+1]);
		this.destReg = VmContext.getRegister(intcode[ip+2]);
	}

	@Override
	public void execute() throws InvalidRegisterException {
		int result = this.destReg.getValue() - this.sourceReg.getValue();
		this.destReg.setValue(result);
	}
}
 