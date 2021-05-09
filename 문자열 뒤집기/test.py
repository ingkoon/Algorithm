#입력
n = list(input())

# 0과 1의 그룹을 카운트하기위한 변수
cnt_0 = 0
cnt_1 = 0

# 초기 값 설정
if n[0] == '0':
    cnt_0 += 1
else:
    cnt_1 += 1

# 반복문을 수행하면서 끝이 바뀔 때 카운트 증가하도록 선언
for i in range(len(n)-1):
    # 0 이 증가하는 경우
    if n[i] == '1':
        if n[i] != n[i+1]:
            cnt_0 += 1
    # 1이 증가하는 경우
    else:
        if n[i] != n[i+1]:
            cnt_1 += 1

# 두 변수 간 최소값을 출력
print(min(cnt_0, cnt_1))

