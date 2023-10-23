outputCharacter: .asciz "%c"

.include "final.s"

.global main

# ************************************************************
# Subroutine: decode                                         *
# Description: decodes message as defined in Assignment 3    *
#   - 2 byte unknown                                         *
#   - 4 byte index                                           *
#   - 1 byte amount                                          *
#   - 1 byte character                                       *
# Parameters:                                                *
#   first: the address of the message to read                *
#   return: no return value                                  *
# ************************************************************
decode:
	# prologue
	pushq	%rbp 			# push the base pointer (and align the stack)
	movq	%rsp, %rbp		# copy stack pointer value to base pointer

	pushq %r12				# push callee saved registers to stack - r12: current value
	pushq %r13				# r13b - ASCII character
	pushq %r14				# r14b - amount of times for the character to be printed
	pushq %r15				# r15d - next memory address
	pushq %rbx				# rbx - address
	pushq $0				# push filler value to respect the stacks alignment

	mov $0, %r12			# reset values of registers
	mov $0, %r13
	mov $0, %r14
	mov $0, %r15

	movq %rdi, %rbx

	loop:
		movq %rbx, %r8		# set r8 to the first address
	
		movq %r15, %rax		# set next address to rax 
		movq $8, %r9
		mulq %r9			# multiply rax bt 8 to calculate the number of bits

		addq %rax, %r8		# add the number of bits to the first address

		movq (%r8), %r12	# set the value of the next address to r12 

		movb %r12b, %r13b	# set current symbol
		shr $8, %r12		# shift r12 to access the amount
		movb %r12b, %r14b	# set current amount
		shr $8, %r12		# shift r12 to access the next address
		movl %r12d, %r15d	# set next address

		repeatCharacter:
			cmp $0, %r14b	# end of repeat character loop condition
			jle endRepeatCharacter

			decb %r14b		# decrement counter

			movq $outputCharacter, %rdi
			mov %r13b, %sil
			mov $0, %rax
			call printf		# print character

			jmp repeatCharacter
		endRepeatCharacter:

		cmp $0, %r15d		# end loop if next address is 0
		je endLoop

		jmp loop
	endLoop:
	
	popq %rbx 				# pop filler value
	popq %rbx 				# pop original values to callee saved registers in reverse order
	popq %r15
	popq %r14
	popq %r13
	popq %r12

	# epilogue
	movq	%rbp, %rsp		# clear local variables from stack
	popq	%rbp			# restore base pointer location 
	ret

main:
	pushq	%rbp 			# push the base pointer (and align the stack)
	movq	%rsp, %rbp		# copy stack pointer value to base pointer

	movq	$MESSAGE, %rdi	# first parameter: address of the message
	call	decode			# call decode

	popq	%rbp			# restore base pointer location 
	movq	$0, %rdi		# load program exit code
	call	exit			# exit the program

