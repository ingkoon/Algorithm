# 카드게임의 크기 지정
n, m = map(int, input.split())

# 결과값 변수
result = 0

# 반복문을 통해 최대값을 비교하여 result에 재할당
for i in range(n):
    data = list(map(int, input().split()))
    min_value = min(data)
    result = max(result, min_value)

# result 출력
print(result)