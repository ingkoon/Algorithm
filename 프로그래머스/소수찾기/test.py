import math
from itertools import permutations

def solution(numbers):
    answer = 0
    result = []
    for i in range(1, len(numbers)+1):
        arr = list(permutations(numbers, i))
        for j in arr:
            num = int(''.join(map(str,j)))
            if prime_num(num):
                result.append(num)
    answer = len(set(result))
    
    return answer

def prime_num(n):
    if n <= 1:
        return False
    
    for i in range(2, int(math.sqrt(n)) + 1):
        if n%i == 0:
            return False
        
    return True