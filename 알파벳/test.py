'''
문제
세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 
보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 
새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 
즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 
말이 지나는 칸은 좌측 상단의 칸도 포함된다.

입력
첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. 
(1 ≤ R,C ≤ 20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.

출력
첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.


예제 입력
2 4
CAAB
ADCB

예제 출력
3
'''

import sys
sys.setrecursionlimit(10 ** 6)

# 가로 세로 입력
r, c  = map(int, sys.stdin.readline().split())

arr = []

# 배열에 입력데이터 추가
for _ in range(r):
    arr.append(list(sys.stdin.readline().rstrip()))

# 탐색을 위한 이동 방향 지정
moveX = [1, -1, 0, 0]
moveY = [0 , 0 , 1, -1]

# 방문처리를 위한 배열 선언
visited = [[False] * c for _ in range(r)]

# 중복 체크를 위한 배열 선언
dupliCheck = []

# dfs
def dfs(x, y):
    # 방문처리
    visited[y][x] = True    
    dupliCheck.append(arr[y][x])
    # 4방향 탐색 시작
    for i in range(4):        
        nx = x + moveX[i]
        ny = y + moveY[i]
        
        # 배열의 크기를 벗어나지 않는 경우에 다음 재귀 수행
        if 0 <= nx < c and 0 <= ny < r:     
            # 방문하지 않거나, 중복체크 되지 않은 곳에 대해 재귀 수행      
            if visited[ny][nx] == False and arr[ny][nx] not in dupliCheck:  
                # 중복 체크 배열에 값 추가                         
                dfs(nx, ny)            

# 결과 변수 선언
result = 0

# 배열 크기만큼 반복
for i in range(r):
    for j in range(c):
        # 방문하지 않은 위치에 한해서 dfs수행
        if visited[i][j] == False:
            dfs(j, i)            
            # 재귀 수행 후 배열의 길이를 결과변수와 비교,
            if result < len(dupliCheck):
                result = len(dupliCheck) # =>  결과변수를 변경 시킨다 0 => n
        # 중복 체크를 위한 배열을 다시 비워준다.
        dupliCheck = []

# 결과 변수 출력                
print(result)


# 왜 틀리는가?

