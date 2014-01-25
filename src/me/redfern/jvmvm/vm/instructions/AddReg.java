package me.redfern.jvmvm.vm.instructions;

import me.redfern.jvmvm.vm.Register;
import me.redfern.jvmvm.vm.VmContext;

/***
 * Opcode 0x01, FORMAT_2R
 * 0x01 0xNN 0xMM
 * add 0xNN to 0xMM
 * @author Joseph Redfern
 *
 */
public class AddReg extends Instruction{
	private Register sourceReg;
	private Register destReg;
	
	public AddReg(int[] ic){
		populateRegisters(ic);
	}
	
	private void populateRegisters(int[] ic){
		this.sourceReg = VmContext.getRegister(ic[1]);
		this.destReg = VmContext.getRegister(ic[2]);
	}

	@Override
	public void execute() {
		int result = this.destReg.getValue() + this.sourceReg.getValue();
		this.destReg.setValue(result);
	}
}
 