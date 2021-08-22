def solution(arr):

    arr.sort()

    max_val = []
    min_val = []

    cnt = []

    for i in range(0, 256):
        for j in  arr:
            if j >= i:
                max_val.append(i)
            else:
                min_val.append(j)
        
        val = len(max_val) - len(min_val)

        if val < 0:
            val = 999
        
        cnt.append(val)

        max_val = []
        min_val = []
    
    answer = cnt.index(min(cnt))

    return answer

arr = [1, 52, 125, 10, 25, 201, 244, 192, 128, 23, 203, 98, 154, 255]

print(solution(arr))