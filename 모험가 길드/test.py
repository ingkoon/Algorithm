import time
start = time.time()

import sys

def solution(n, arr):

    # 배열의 번호를 카운트할 변수
    cnt = 0

    #결과, 그룹의 개수를 세는 배열
    result = 0

    # 배열 정렬
    arr.sort(reverse=True)

    # 공포값을 담을 변수
    val = 0

    while cnt != n:        
        val = arr[cnt]
        #해당 모험가의 공포가 전체 인원보다 클 경우
        if val >= len(arr):
            # 모집 종료
            break
        # 공포가 전체 인원보다 작을 경우
        else:
            # 결과 1 증가
            result +=1
            # 배열의 번호를 증가시킨다.
            cnt += val
    # 결과값 출력
    print(result)

# 입력 단
n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

# 함수 호출
solution(n,arr)

# 시간 호출
print(time.time() - start)