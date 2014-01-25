package me.redfern.jvmvm;

public class JvmVm {
	
	public static void main(String args[]){
		JvmVm vm = new JvmVm(new int[]{0}); //temp
		vm.run();
	}
	
	public JvmVm(int[] intcode){
		
	}
	

	/***
	 * run loop goes here... ip=0 look at intcode[ip], look up instruction,
	 * execute instruction, ip+=sizeof(instruction[ip]), repeat while 
	 * ip<sizeof(intcode)
	 */
	public void run(){
		
	}
}
