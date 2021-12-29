'''
테스트 케이스

3 3
3 1 2
4 1 4
2 2 2
'''

import sys
 
n, m = map(int, sys.stdin.readline().split())

result = 0

for i in range(n):
    arr = list(map(int, sys.stdin.readline().split()))
    minVal = min(arr)
    result = max(result, minVal)

print(result)