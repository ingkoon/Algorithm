'''
문제
가중치 없는 방향 그래프 G가 주어졌을 때, 
모든 정점 (i, j)에 대해서, 
i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 
둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다. 
i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 
존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. 
i번째 줄의 i번째 숫자는 항상 0이다.

출력
총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 
정점 i에서 j로 가는 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 
없으면 0으로 출력해야 한다.
'''

import sys

n = int(sys.stdin.readline())

g = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

#플로이드-워셜 알고리즘
for k in range(n): #경로 for문이 가장 상위 단계여야 누락되지 않는다
    for i in range(n):
        for j in range(n): 
            if g[i][j] == 1 or (g[i][k] == 1 and g[k][j] == 1):
              g[i][j] = 1


#출력
for row in g:
    for col in row:
        print(col, end = " ")
    print()