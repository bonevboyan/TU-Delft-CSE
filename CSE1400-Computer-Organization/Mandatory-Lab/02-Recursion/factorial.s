input: .asciz "Boyan Bonev (bibonev)\nSimeon Nedelkov (snedelkov)\Recursion assignment:\nEnter a non-negative number:\n"
scan: .asciz "%ld"
output: .asciz "%ld! = %ld\n"

.global main

main:
    # Prologue
    push %rbp
    mov %rsp, %rbp

    mov $input, %rdi
    mov $0, %rax
    call printf         # print enter message

    mov $scan, %rdi
    sub $16, %rsp       # reserve space for input
    lea -8(%rbp), %rsi  # save address for input number
    mov $0, %rax        
    call scanf          # read number

    pop %r8
    pop %r8            # get number value

    mov %r8, %rdi      # set subroutine arguments
    call factorial      # call factorial subroutine

    mov $output, %rdi
    mov %r8, %rsi      
    mov %rax, %rdx
    mov $0, %rax
    call printf         # print result

    # Epilogue
    mov %rbp, %rsp
    pop %rbp

    mov $0, %rdi
    call exit

factorial: 
    # Prologue
    push %rbp
    mov %rsp, %rbp

    cmp $0, %rdi        # check if value is positive
    jle nonPositive
    jmp positive

    nonPositive:
        mov $1, %rax    # return 0 if argument is non-positive
        jmp end

    positive:
        push %rdi
        push %rdi       # push rdi twice into stack
        sub $1, %rdi    # subtract 1 from rdi
        call factorial  # call function

        pop %rdi        
        pop %rdi        
        mul %rdi        # pop rdi twice and multiply rax by rdi

    end:
        # Epilogue
        mov %rbp, %rsp
        pop %rbp

        ret