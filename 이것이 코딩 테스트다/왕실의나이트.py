# 입력 라이브러리 import
import sys

# 데이터 입력
user_input = sys.stdin.readline()

# 행값은 문자열을 정수 타입으로 변경하여 할당
row = int(user_input[1])
col = int(ord(user_input[0])) - int(ord('a'))+1

# 모든 루트에 대한 값을 리스트에 저장
steps = [(-2,-1), (-1,-2), (-2,1), (1,-2), (2,-1), (-1,2) ,(2,1), (1,2)]

#결과 카운트값 할당
cnt = 0

# 반복문을 통해 리스트의 값을 가져와 해당 값이 조건에 맞는지 검사
# 검사 후 카운트 값 증가
for step in steps:
    next_row = row + step[0]
    next_col = col + step[1]
    if next_row >= 1 and next_col <= 8 and next_col >=1 and next_row <= 8:
        cnt += 1

# 결과 출력
print(cnt)

