'''
테스트 케이스
5 8 3
2 4 5 4 6
'''

import sys
# 입력 데이터의 길이, 연산 횟수, 연속 연산 제한의 입력 
n, m, k = map(int, sys.stdin.readline().split())

# 데이터 입력
data = list(map(int, sys.stdin.readline().split()))

# 데이터내의 값들을 정렬
data.sort()

# 최댓값과 그 다음 최댓값
maxVal = data[-1]
maxValSub = data[-2]

# 결과값 변수 할당
result = 0

# 반복 연산 수행
while m:
    if m % k == 0:
        result += maxValSub
    else:
        result += maxVal
    m -= 1

print(result)
