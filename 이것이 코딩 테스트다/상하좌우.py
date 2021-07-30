import sys

# 입력및 변수 초기화
n = sys.stdin.readline()

# 각각의 좌표에 대한 초기화
x = 1
y = 1

# 루트에 대한 값을 리스트 타입으로 받는다
route = list(map(str, input().split()))

# 조건문을 통해 좌표 수정
for i in route:
    if i == "L" and (y>1 and y<=5):
        y -= 1
    elif i == "R" and (y>=1 and y<5):
        y += 1
    elif i == "U" and (x>1 and x<=5):
        x -= 1
    elif i == "D" and (x>=1 and x<5):
        x += 1
        
# 결과 출력
print(x, y)