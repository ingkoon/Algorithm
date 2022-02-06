import sys

cups = [i for i in range(1, 4)]

n = int(sys.stdin.readline())
for _ in range(n):
    n, m = map(int, sys.stdin.readline().split())
    nn = cups.index(n)
    nm = cups.index(m)
    cups[nn], cups[nm] = cups[nm], cups[nn]
print(cups[0])