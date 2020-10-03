def solution(prices):
    answer = []
    for i in range(len(prices)):
        count = 0
        for j in range(i+1,len(prices)):
            if prices[i] <= prices[j]:
                count += 1
        answer.append(count)
    return answer

prices = [1,2,3,2,4,5,3,2,4,5]
print(solution(prices))
