'''
방향 없는 그래프가 주어졌을 때, 
연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

첫째 줄에 연결 요소의 개수를 출력한다.

6 5
1 2
2 5
5 1
3 4
4 6

2
'''

import sys

answer = 0

n, m = map(int, sys.stdin.readline().split())

graph = { i:[] for i in range(1, n+1)}
visited = [False] * (n +1)

for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)


def dfs(visited, v):
    if visited[v] == False:
        visited[v] = True
        for i in graph[v]:
            if not visited[i]:
                print('next part is', i)
                dfs(visited, i)
            return True
    return False


for i in range(1, n):
    if dfs(visited, i) == True:
        answer += 1

print(answer)
