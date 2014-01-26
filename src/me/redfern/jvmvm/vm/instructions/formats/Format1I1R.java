package me.redfern.jvmvm.vm.instructions.formats;
import me.redfern.jvmvm.vm.instructions.AbstractInstruction;

public abstract class Format1I1R extends AbstractInstruction{
	public int getSize(){
		return 3;
	}
}