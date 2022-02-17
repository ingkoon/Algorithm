import sys

t = int(sys.stdin.readline())

def recur(n):
    if n == 1:
        return 1

    elif n == 2:
        return 2
    elif n == 3:
        return 4
    else:
        return recur(n-1) + recur(n-2) + recur(n-3)

for _ in range(t):
    n = int(sys.stdin.readline())
    print(recur(n))
