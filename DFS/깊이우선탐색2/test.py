import sys
sys.setrecursionlimit(10**6)
###
n, m, r = map(int, sys.stdin.readline().split())

visited = [0] * (n+1)
board = [[] for _ in range(n + 1)]

for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    board[u].append(v)
    board[v].append(u)

for i in range(len(board)):
    board[i].sort()

def dfs(r, cnt):
    visited[r] = cnt    
    cnt += 1 
    for i in board[r]:
        if visited[i] == 0:
            dfs(i, cnt)

cnt = 1
dfs(r, cnt)

for i in visited[1:]:    
    print(i)

