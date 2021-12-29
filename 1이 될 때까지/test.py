'''
25 5
'''

import sys

n, k = map(int, sys.stdin.readline().split())

result = 0

while True:
    if n < k:
        break
    
    result += 1
    
    if n%k:
        n //= k
    else:
        n -= 1

print(result)
    
        