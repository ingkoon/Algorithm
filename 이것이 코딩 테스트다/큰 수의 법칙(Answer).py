def biggestNum(arr1,arr2):
    #배열 정렬 먼저 수행
    arr2.sort()

    #결과값 반환을 위한 배열 
    result = 0

    # 시작 카운트 (1~8까지)
    cnt = 1

    # 최대값과 그다음 최대값을 변수로 지정
    max = arr2[arr1[0]-1]
    max2 = arr2[arr1[0]-2]

    #지정 한 조건으로 반복문을 수행
    while cnt <= arr1[1]:
        # 특정 구간에는 두번째 최대값을 더한다.
        if cnt % arr1[2] == 0:
            result +=max2
        # 이외의 구간에는 최대값을 결과값에 더한다
        else:
            result += max
        # 카운트 증가
        cnt +=1

    return result

# arr1 = list(map(int, input().split()))
# arr2 = list(map(int, input().split()))

# 입력 부분
arr1 = [5,8,3]
arr2 = [2,4,5,4,6]

# 함수호출 및 결과 반환
result = biggestNum(arr1,arr2)

# 반환된 결과값 출력
print(result)
