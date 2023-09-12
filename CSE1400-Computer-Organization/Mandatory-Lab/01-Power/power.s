input: .asciz "Enter two non-negative numbers:\n"
scan: .asciz "%ld"
output: .asciz "%ld ^ %ld = %ld\n"

.global main

main:
    # Prologue
    push %rbp
    mov %rsp, %rbp

    mov $input, %rdi
    mov $0, %rax
    call printf         # print enter message

    mov $scan, %rdi
    sub $16, %rsp       # reserve space for two inputs
    lea -8(%rbp), %rsi  # save address for first number
    mov $0, %rax        
    call scanf          # read first number
    
    mov $scan, %rdi
    lea -16(%rbp), %rsi # save address for second number
    mov $0, %rax        
    call scanf          # read second number

    pop %rbx            # get second number value
    pop %rcx            # get first number value

    mov %rcx, %rdi      # set subroutine arguments
    mov %rbx, %rsi
    call pow            # call pow subroutine

    mov $output, %rdi
    mov %rcx, %rsi      
    mov %rbx, %rdx      
    mov %rax, %rcx      
    mov $0, %rax
    call printf         # print result

    #Epilogue
    mov %rbp, %rsp
    pop %rbp

    mov $0, %rdi
    call exit

pow: 
    # Prologue
    push %rbp
    mov %rsp, %rbp

    mov $1, %rax        # intialize result if exponent is 0

    cmp $0, %rsi        # return if exponent is 0
    je end

    loop:
        sub $1, %rsi    # subtract 1 from exponent until it equals 1
        mul %rdi        # multuply the result by the base

        cmp $0, %rsi    # end of loop condition
        jg loop

end:
    #Epilogue
    mov %rbp, %rsp
    pop %rbp

    ret
