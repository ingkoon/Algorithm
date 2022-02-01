import sys

t = int(sys.stdin.readline())
for _ in range(t):
    zero = 1
    one = 0 
    tmp = 0
    n = int(sys.stdin.readline())
    for _ in range(n):
        tmp = one
        one += zero
        zero = tmp
    print(zero, one)
