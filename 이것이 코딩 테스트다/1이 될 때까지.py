import sys

# 입력 지정
n, k = map(int, sys.stdin.readline().split())

# 결과값 할당을 위한 변수
result = 0

# 반복문을 통해 n이 1이 될때까지 반복
while n != 1:
    # n을 k로 나눌 수 있을 때
    if n%k ==0:
        # k로 나눈다
        n //= k
    #그 이외의 경우 1을 차감한다
    else:
        n -= 1
    # 한번 반복 시, 카운트 추가
    result +=1

# 결과값 출력
print(result)