def solution(board, moves):
    answer = 0
    stack = [5,2,5]
    for i in moves:
        i -= 1
        for j in range(len(board)):            
            print(j, i+1)
            if board[j][i] == 0:
                print("empty!")
                continue
            else:
                print("stack added!")
                stack.append(board[j][i])   
                board[j][i] = 0
                print(board[j][i]+1)
                print(stack)
                break

        if len(stack) >= 2:
            if stack[-1] == stack[-2]:
                answer += 1
                del stack[-1]
                del stack[-1]
            else:
                continue
        
    return answer

a = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	
b = [1,5,3,5,1,2,1,4]

print(solution(a,b))