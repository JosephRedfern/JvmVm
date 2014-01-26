package me.redfern.jvmvm.vm.formats;
import me.redfern.jvmvm.vm.instructions.AbstractInstruction;

public abstract class Format1R extends AbstractInstruction{
	public int getSize(){
		return 2;
	}
}