def solution(n, edge):
    answer = 0
    
    edge.sort()
    
    qu = []
    done = set()
    
    qu.append(1)
    
    while qu:
        Val = qu.pop(0)
        done.add(Val)
        print(Val)
        for i in range(len(edge)):
            if edge[i][0] == Val:
                qu.append(edge[i][1])
            else:
                continue
    
        
    return answer