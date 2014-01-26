package me.redfern.jvmvm.vm.formats;
import me.redfern.jvmvm.vm.instructions.AbstractInstruction;

public abstract class Format2R extends AbstractInstruction{
	final int size = 3; //op, reg, reg.
}
