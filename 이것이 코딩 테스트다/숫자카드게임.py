# n * m 크기 지정
n,m = map(int, input().split())

# 각 줄의 최소값을 담기 위한 list
minValue = []

# 반복문을 통하여 각행의 최솟값을 list에 저장
for i in range(m):
    data = list(map(int, input().split()))
    minValue.append(min(data))

# list의값중 최대 값을 결과 변수에 할당
result = max(minValue)

# 결과 출력
print(result)
