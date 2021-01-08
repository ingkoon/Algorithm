def solution(num):
    tmp = list(map(str, num))
    tmp.sort(key = lambda x: x*3, reverse = True)
    
    return str(int(''.join(tmp)))

num = [6,12,10,3]
print(solution(num))