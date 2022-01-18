import sys
from collections import deque

n = int(sys.stdin.readline())

queue = deque()
for _ in range(n):
    val = int(sys.stdin.readline())
    if val == 0:
        queue.pop()
        continue
    queue.append(val)

print(sum(queue))


    