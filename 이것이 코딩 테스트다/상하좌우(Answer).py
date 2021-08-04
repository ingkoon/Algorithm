# 입력 지정
n = int(input())

# 결과에 대한 좌표값 지정
x, y = 1, 1

# 문자열 입력
plans = input().split()

# 좌표 이동값에 대한 리스트 지정
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# 좌표 이동 타입 지정
move_types = ['L', 'R', 'U', 'D']

# 계획된 좌표이동
for plan in plans:
    # 이동타입 개수만큼의 반복 수행
    for i in range(len(move_types)):
        # 이동타입의 값과 같을 경우
        if plan == move_types[i]:
            # 각각의 좌표 이동
            nx = x + dx[i]
            ny = y + dy[i]
        # 특정 조건의 경우 이동을 제한할 수 있도록 continue 문을 사용해서 제한
        if nx < 1 or ny < 1 or nx > n or ny > n:
            continue
        # 증가한 값을 재할당
        x, y = nx, ny
        
# 결과 출력
print(x, y)