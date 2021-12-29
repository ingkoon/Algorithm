def solution(n, computers):
    answer = 0    
    def dfs(n, c):        
        checkP = False
        if computers[c].count(1) == 1:
            return True
        
        
        for i in range(n):          
            if c == i:
                computers[i][i] = 0
            if computers[c][i] == 1:
                print("{0}과 {1}은 네트워크로 묶인 사이입니다.".format(c, i))
                computers[c][i] = 0                
                dfs(n, i)
                checkP = True                  
        return checkP
                        
    for i in range(n):
        if dfs(n,i) == True:
            answer += 1    
    return answer


computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]	
n = 3
print(solution(n, computers))