import sys
from collections import deque
n, k, r = map(int,sys.stdin.readline().split())

farm = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]

location = [list(map(int,sys.stdin.readline().split())) for _ in range(k)]

result = []

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(x, y):
    queue = deque()
    queue.append((x,y))
    while queue:
        px, py = queue.popleft()                
        visited[py][px] = 1
        for i in range(n):
            nx = px + dx[i]
            ny = py + dy[i]
            if 0<= nx < n and 0<= ny < n:
                if [ny, nx] not in location and visited[ny][nx]!= 0:                                        
                    queue.append(nx, ny)
            

for i, cow in enumerate(location):
    visited = [[0] * n for _ in range(n)]
    bfs(cow[0], cow[1])
    for r, c in 