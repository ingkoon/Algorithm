import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    arr = [[] for i in range(n)]
    for i in range(n):
        arr[i] = list(map(int, sys.stdin.readline().split()))
    