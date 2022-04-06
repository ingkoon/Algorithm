
import sys
sys.setrecursionlimit(10 ** 6)
n = int(sys.stdin.readline())

tree = {i:[] for i in range(1, n+1)}
visited = [0] * (n + 1)

for i in range(n-1):
    n1, n2 = map(int,sys.stdin.readline().split())
    tree[n1].append(n2)
    tree[n2].append(n1)


def dfs(n):
    for i in tree[n]:
        if visited[i] == 0:
            visited[i] = n
            dfs(i)

dfs(1)
for i in range(2,n+1):
    print(visited[i])



