'''
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 
섬의 개수를 세는 프로그램을 작성하시오.



한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 
지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

입력

입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. 
w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 
1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력

각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

'''

# 입력을 위한 라이브러리
import sys

# 재귀 제한
sys.setrecursionlimit(10 ** 6)


# 초기 입력
w, h = map(int, sys.stdin.readline().split())

# dfs선언
def dfs(x, y):
    # 지도 밖을 벗어나지 못하도록 지정
    if x >= w or  x < 0 or y >= h or y < 0:
        return False

    # 땅이 있을 경우 인접한 땅 지정
    if mapList[y][x] == 1:
        mapList[y][x] = 0
        dfs(x + 1, y)
        dfs(x - 1 , y)
        dfs(x , y + 1)
        dfs(x , y - 1)
        dfs(x + 1 , y + 1)
        dfs(x - 1 , y + 1)
        dfs(x + 1 , y - 1)
        dfs(x - 1 , y - 1)
        return True
    return  False

# 0 0 이 나오기 전까지 반복
while w != 0 and h != 0:
    # 지도를 위한 배열 선언
    mapList = []

    # 결과 반환을 위한 변수 선언
    result = 0

    # 지도에 대한 리스트 요소를 반복문 수행하여 삽입
    for _ in range(h):
        mapList.append(list(map(int, sys.stdin.readline().split())))
    
    # 반복문을 수행해 돌려본다
    for i in range(w):
        for j in range(h):
            if dfs(i, j) == True:
                result += 1
    print(result)

    w, h = map(int, sys.stdin.readline().split())


