def solution(arr):
    temp = arr
    num = len(temp)
    array = []
    
    for i in range(len(temp)-1):      
        if temp[i] != temp[i+1]:
            array.append(temp[i])
            
    array.append(temp[-1])
    return array

    
test = [1,1,3,3,0,1,1]
print(solution(test))