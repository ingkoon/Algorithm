# import sys
# from collections import deque

# n, m = map(int, sys.stdin.readline().split())

# graph = [[]  for _ in range(n)]

# for i in range(1, n):    
#     graph[i] = list(map(int, sys.stdin.readline().split()))


# request = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

# graph.sort()

# visited = [0] * n
# def bfs(start, destination):
#     visited[start] = graph[start][2]
#     queue = deque()    
#     queue.append(graph[start])
#     while queue:              
#         x, y, d = queue.popleft()
#         if x == destination:
#             return  
#         if visited[y] ==  0:
#             visited[y] += visited[x] + d
#             queue.append(graph[y])
#     return 

# for start, destination in request:
#     print(bfs(start, destination))



import sys
input = sys.stdin.readline
from collections import defaultdict,deque

def Distance(a,b):
    queue = deque()
    queue.append(a)
    visited = [False]*(N+1)
    visited[a] = True
    target_dist = [0]*(N+1)
    while queue:
        v = queue.popleft()
        if v==b:
            print(target_dist[v])
            return
        for next,dist in graph[v]:
            if not visited[next]:
                queue.append(next)
                visited[next] = True
                target_dist[next] += target_dist[v] +dist
                



N,M = map(int,input().split())
graph = defaultdict(list)


for _ in range(N-1):
    a,b,dist = map(int,input().split())
    graph[a].append((b,dist))
    graph[b].append((a,dist))

for _ in range(M):
    a,b = map(int,input().split())
    Distance(a,b)