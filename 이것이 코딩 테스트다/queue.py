# 큐 예제

from collections import deque

queue = deque()

queue.append(5)
queue.append(2)
queue.append(3)

queue.popleft()

queue.append(7)
queue.append(9)

queue.popleft()

print(queue)

queue.reverse()

print(queue)
