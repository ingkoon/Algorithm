# 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

# 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 

# 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 

# 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 

# 입력으로 주어지는 간선은 양방향이다.

# 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

import sys
from collections import deque
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end =' ')
    # print('visited', v)
    for i in graph[v]:        
        if not visited[i]:    
            # print('we will visit', i)    
            dfs(graph, i, visited)


def bfs(graph, v, visited):
    queue = deque([v])

    visited[v] = True

    while queue:
        val = queue.popleft()
        print(val, end = ' ')
        for i in graph[val]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

n, m, v = map(int, sys.stdin.readline().split())

graph = [[] for i in range(n+1)]

for i in range(1, m+1):
    x, y = list(map(int, sys.stdin.readline().split()))
    graph[x].append(y)
    graph[y].append(x)

for i in range(len(graph)):
    graph[i].sort()
print(graph)

visited = [False] * (m + 1)

dfs(graph,v, visited)

visited = [False] * (m + 1)

bfs(graph,v, visited)

