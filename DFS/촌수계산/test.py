'''
우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 
독특한 문화를 가지고 있다. 
이러한 촌수는 다음과 같은 방식으로 계산된다. 
기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 
예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 
아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.

여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 
주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.

사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 
입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 
둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 
그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 
넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 
이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.

각 사람의 부모는 최대 한 명만 주어진다.

과정을 담는 것이 중요한 문제다.
따라서 한차례 값을 더할때마다 해당 노드의 위치에 값을 더해주는것이 좋다.
'''

import sys
sys.setrecursionlimit(10 ** 6)

# 전체 사람의 수
n = int(sys.stdin.readline())

# 관계를 딕셔너리 형태로 정의
relation = {i:[] for i in range(1, n+1)}

# 촌수를 계산해야하는 서로 다른 두 사람의 번호
p1, p2 = map(int, sys.stdin.readline().split())

# 부모 자식간의 관계 개수 
m = int(sys.stdin.readline())

for _ in range(m):
    parents, child = map(int,sys.stdin.readline().split())
    relation[parents].append(child)
    relation[child].append(parents)

# 관계를 정의하였을 경우를 체크하기 위한 변수
visited = [False] * (n+1)

cnt = 0

# visited에 값을 누적
def dfs(s):    
    for i in relation[s]:
        if visited[i] == False:            
            visited[i] = visited[s] + 1            
            dfs(i)
dfs(p1)
result = visited[p2]

if result != 0: print(result)
else: print(-1)
