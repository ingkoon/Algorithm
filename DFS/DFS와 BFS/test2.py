import sys
from collections import deque

n, m, v = map(int, sys.stdin.readline().split())

# graph = { i : [] for i in range(1, 5) }


graph = [[] for i in range(n+1)]
for _ in range(m):
    tmp1, tmp2 = map(int, sys.stdin.readline().split())
    graph[tmp1].append(tmp2)
    graph[tmp2].append(tmp1)

for i in range(1, n+1):
    graph[i].sort()


def dfs(v):
    visited[v] = True
    print(v, end = " ")
    for i in graph[v]:
        if visited[i] == False:
            dfs(i)


def bfs(v):
    visited[v] = True
    queue = deque([v])    
    while queue:
        tmp = queue.popleft()     
        print(tmp, end = " ")          
        for i in graph[tmp]:
            if not visited[i]:                                                                  
                queue.append(i)
                visited[i] = True   


visited = [False] * (n + 1)            
dfs(v)

print()

visited = [False] * (n + 1)
bfs(v)