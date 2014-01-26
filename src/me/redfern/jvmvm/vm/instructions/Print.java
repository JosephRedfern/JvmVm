package me.redfern.jvmvm.vm.instructions;

import me.redfern.jvmvm.exceptions.InvalidRegisterException;
import me.redfern.jvmvm.vm.Register;
import me.redfern.jvmvm.vm.VmContext;
import me.redfern.jvmvm.vm.instructions.formats.Format1R;
import me.redfern.jvmvm.vm.instructions.formats.Format2R;

/***
 * Opcode 0x03, FORMAT_1R
 * 3 rN
 * Print rN to screen.
 * 
 * @author Joseph Redfern
 */
public class Print extends Format1R implements IInstruction{
	private Register sourceReg;
	
	public IInstruction getInstance(int ip, int[] intcode) throws InvalidRegisterException{
		return new Print(ip, intcode);
	}
	
	public Print(){
		
	}
	
	public Print(int ip, int[] intcode) throws InvalidRegisterException{
		populateRegisters(ip, intcode);
	}
	
	private void populateRegisters(int ip, int[] intcode) throws InvalidRegisterException{
		this.sourceReg = VmContext.getRegister(intcode[ip+1]);
	}

	@Override
	public void execute() throws InvalidRegisterException {
		System.out.print("> "+this.sourceReg.getValue());
	}
}
 