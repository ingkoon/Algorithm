'''
ANT가 처음 알고리즘 대회를 개최하게 되면서 현수막을 내걸었다.

저번 학기 영상처리 수업을 듣고 배웠던 지식을 최대한 응용 해보고 싶은 
혁진이는 이 현수막에서 글자가 몇 개인지 알아보는 프로그램을 만들려 한다.

혁진이는 우선 현수막에서 글자인 부분은 1, 글자가 아닌 부분은 0으로 바꾸는 필터를
적용하여 값을 만드는데 성공했다.

그런데 혁진이는 이 값을 바탕으로 글자인 부분 1이 상, 하, 좌, 우, 대각선으로 인접하여 
서로 연결되어 있다면 한 개의 글자라고 생각만 하였다.

혁진이가 필터를 적용하여 만든 값이 입력으로 주어졌을 때, 
혁진이의 생각대로 프로그램을 구현하면 글자의 개수가 몇 개인지 출력하여라.

입력
첫 번째 줄에는 현수막의 크기인 M와 N가 주어진다. (1 ≤ M, N ≤ 250)
두 번째 줄부터 M+1 번째 줄까지 현수막의 정보가 1과 0으로 주어지며, 
1과 0을 제외한 입력은 주어지지 않는다.

출력
혁진이의 생각대로 프로그램을 구현했을 때, 
현수막에서 글자의 개수가 몇 개인지 출력하여라.


8 19
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 1 0 0 0 1 0 1 1 1 1 1 0
0 0 1 0 1 0 0 1 1 0 0 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 1 1 1 1 0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 0 1 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 0 0 1 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0


3
'''
import sys
sys.setrecursionlimit(10**6)



def dfs(y, x):
    graph[y][x] = 0
    for i in range(4):
        ny, nx = y+dy[i], x+dx[i]
        if (0 <= ny < m) and (0 <= nx < n) and graph[ny][nx] == 1:
            dfs(ny, nx)

m, n = map(int, sys.stdin.readline().split())

dx = [1, -1, 0, 0, 1, -1, 1, -1]
dy = [0, 0, 1, -1, 1, 1, -1, -1]

graph = [list(map(int, input().split())) for _ in range(m)]

result = 0

for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            dfs(i, j)
            result += 1

print(result)