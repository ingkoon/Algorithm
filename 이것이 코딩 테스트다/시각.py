import sys

# 정수타입으로 시각 입력
n = int(sys.stdin.readline())

# 3이 카운트 되기 위한 변수 지정
cnt = 0

# 시, 분, 초를 계산하기 위하여 3중 반복문으로 구성
for i in range(n+1):
    for j in range(60):
        for k in range(60):
            # 시, 분, 초를 각각 문자열로 변경하여 3이 포함되는지 확인
            t = str(i) + str(j) + str(k)
            if "3" in t:
                cnt += 1

# 출력
print(cnt)
