# 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

# 세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

# 직사각형의 네 번째 점의 좌표를 출력한다.


'''
예제 입력

5 5
5 7
7 5

예제 출력 

7 7
'''

import sys

first = [0] * 3
second = [0] * 3

resultFirst = 0
resultSecond = 0

for i in range(3):
    first[i], second[i] = map(int,sys.stdin.readline().split())

firstVal = list(set(first))
secondVal = list(set(second))


for i in range(len(firstVal)):
    if first.count(firstVal[i])%2 != 0:
        resultFirst = firstVal[i]

    if second.count(secondVal[i])%2 != 0:
        resultSecond = secondVal[i]


print(resultFirst, resultSecond)

