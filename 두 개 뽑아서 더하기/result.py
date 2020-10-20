def solution(numbers):
    #배열 선언
    answer = []
    #첫번째 반복문, 덧셈을 위한 첫번째 수
    for i in range(len(numbers)):
        #두번째 반복문, 덧셈을 위한 두번째 수 및 연산
        for j in range(i+1,len(numbers)):
            #두개의 수 더하기
            result = numbers[i] + numbers[j]
            #더한 두개의수 배열에 추가
            answer.append(result)

    #배열의 중복값 제거
    answer = list(set(answer))
    #배열 정렬!
    answer.sort()
    #배열 반환
    return answer

numbers = [2,1,3,4,1]
result = solution(numbers)
print(result)
