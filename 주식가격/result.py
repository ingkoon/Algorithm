def solution(prices):
    #입력배열의 크기만큼 초기화
    answer = [0] * len(prices)

    #배열의 길이만큼 반복
    for i in range(len(prices)):
        #현재위치서부터 마지막까지 반복
        for j in range(i+1,len(prices)):
            #현재위치가 다음위치보다 크기가 작을경우 1증가 후 종료
            if prices[i] <= prices[j]:
                answer[i] +=1
            #현재위치가 다음 위치보다 클 경우 값을 1증가시키고 종료
            else:
                answer[i] +=1
                break;

    return answer

prices = [15,2,3,2,1,5,3,2,4,5]
print(solution(prices))
