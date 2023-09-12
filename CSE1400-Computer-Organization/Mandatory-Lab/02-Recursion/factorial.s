input: .asciz "Enter a non-negative number:\n"
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

    pop %rcx
    pop %rcx            # get number value

    mov %rcx, %rdi      # set subroutine arguments
    call factorial      # call factorial subroutine

    mov $output, %rdi
    mov %rcx, %rsi      
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

    cmp $0, %rdi
    jle nonPositive
    jmp positive

    nonPositive:
        mov $1, %rax
        jmp end

    positive:
        mov %rdi, %rax
        sub $1, %rdi
        
        call factorial

        add $1, %rdi
        mul %rdi
        jmp end

    end:
        # Epilogue
        mov %rbp, %rsp
        pop %rbp

        ret
