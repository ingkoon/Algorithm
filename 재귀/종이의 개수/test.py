'''
문제
N×N크기의 행렬로 표현되는 종이가 있다. 
종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 
우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.

만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
(1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 
각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
이와 같이 종이를 잘랐을 때, 
-1로만 채워진 종이의 개수, 
0으로만 채워진 종이의 개수, 
1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 
다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

출력
첫째 줄에 -1로만 채워진 종이의 개수를, 
둘째 줄에 0으로만 채워진 종이의 개수를, 
셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
'''

import sys

n = int(sys.stdin.readline())

board = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]

result = [0] * 3

def check(x, y, n):    
    val = board[y][x]
    for i in range(n):
        for j in range(n):
            # if 0 <= x + j < n and 0 <= y + i < n:        
            if val != board[y + i][x + j]:
                return False
    return True

     
def dq(x, y, n):
    if check(x, y, n):
        result[board[y][x]+ 1] += 1
    else:
        for i in range(3):
            for j in range(3):
                dq(y + i* n//3, x + j* n//3, n//3)
    return

dq(0,0,n)
for i in range(3):
    print(result[i])


    