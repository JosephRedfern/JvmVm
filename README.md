JvmVm
=====

VM in a VM, yo! Just a bit of fun. 

##IntCode Format

###File Structure
magic, int - constant 133337 - 0x4F790D59

register count, int

bytecode, int[].

###Opcodes
There are currently 6 opcodes:
Const: 1 I R
AddReg: 2 R R
SubtractReg: 3 R R
MultiplyReg: 4 R R
DivideReg: 5 R R
Print: 6 R

where I denotes an integer, and R denotes a register reference. 

A program which multiplied 10 by 5 and printed the result would look like this:

>1333333337 //Magic

>2 //2 registers to be used

>1 10 0 //move 10 to r0

>1 5 1 //move 5 to r1

>4 0 1 // Multiply r1 by r0

>6 1 //Print the value of register 1
