def fib(number):
    if number <= 1:
        return number
    else:
        return(fib(number-1) + fib(number-2))

nterms = int(input("Enter a number: "))

if nterms <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(nterms):
        print(fib(i))