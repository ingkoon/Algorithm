import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())

x, y, d = map(int, sys.stdin.readline().split)

board = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
visited = [[0] * m for _ in range(n)]

def bfs():    

    queue = deque()
    queue.append((x, y))    

    cnt = 0

    while 1:    
        
        px, py = queue.popleft()        
        visited[py][px] = 1
        board[py][px] = 1
        
        for i in range(4):
            nx = px + dx[(d+3)%4]
            ny = py + dy[(d+3)%4]
            
            if 0<= nx < m and 0<= ny < n:
                if board[ny][nx] == 0:
                    visited[ny][nx] = 0
                    cnt += 1 
                    queue.append(nx, ny)

        

        

        








