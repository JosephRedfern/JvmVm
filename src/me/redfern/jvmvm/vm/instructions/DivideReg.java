package me.redfern.jvmvm.vm.instructions;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;
import me.redfern.jvmvm.vm.Register;
import me.redfern.jvmvm.vm.VmContext;
import me.redfern.jvmvm.vm.instructions.formats.Format2R;

/***
 * Opcode 5, FORMAT_2R
 * 5 rN rM
 * Divide rM to rN
 * 
 * @author Joseph Redfern
 */
public class DivideReg extends Format2R implements IInstruction{
	private Register sourceReg;
	private Register destReg;
	
	public IInstruction getInstance(int ip, int[] intcode) throws InvalidRegisterException{
		return new DivideReg(ip, intcode);
	}
	
	public DivideReg(){
		
	}
	
	public DivideReg(int ip, int[] intcode) throws InvalidRegisterException{
		populateRegisters(ip, intcode);
	}
	
	private void populateRegisters(int ip, int[] intcode) throws InvalidRegisterException{
		this.sourceReg = VmContext.getRegister(intcode[ip+1]);
		this.destReg = VmContext.getRegister(intcode[ip+2]);
	}

	@Override
	public void execute() throws InvalidRegisterException {
		int result = this.destReg.getValue() / this.sourceReg.getValue();
		this.destReg.setValue(result);
	}
}
 