def solution(numbers, target):
    n = len(numbers)
    answer = 0
    def dfs(idx, result):        
        if idx == n:
            if result == target:                
                nonlocal answer # 함수 안에 선언된 함수라 global 키워드를 못쓴다.
                answer += 1
            return
        else:
            dfs(idx+1, result+numbers[idx])
            dfs(idx+1, result-numbers[idx])
    dfs(0,0)
    return answer

print(solution([1, 1, 1, 1, 1], 3))

