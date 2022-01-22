import sys
from collections import deque

n, m = map(int,sys.stdin.readline().split())
canvas = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

visited = [[False] * m for _ in range(n)]
dx = [1,-1, 0, 0]
dy = [0, 0, 1, -1]

count = 0
def bfs(x, y, count):
    queue = deque()
    queue.append((x, y))
    visited[y][x] = True
    while queue:
        px, py = queue.popleft()
    
        count += 1
        for i in range(4):
            nx = px + dx[i]
            ny = py + dy[i]

            if 0<= nx < m and 0 <= ny < n:
                if visited[ny][nx] == False and canvas[ny][nx] == 1:
                    visited[ny][nx] = True
                    queue.append((nx, ny))
    return count

result = []

for i in range(n):
    for j in range(m):
        if canvas[i][j] == 1 and not visited[i][j]:
            result.append(bfs(j, i, 0))
    

print(len(result))
if not result:
    print(0)
else:
    print(max(result))    
