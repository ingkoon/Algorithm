'''
문제
정수 A를 B로 바꾸려고 한다. 
가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다. 
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.11

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
'''
import sys
from collections import deque
a, b = map(int, sys.stdin.readline().split())

def bfs(a, n):
    queue = deque()
    queue.append((a, n))
    
    while queue:
        nextA, nextN = queue.popleft()
        if nextA == b:
            return nextN
        if nextA * 2 <= b:
            queue.append((nextA * 2, nextN +1 ))
        if nextA * 10 + 1 <= b:
            queue.append((nextA * 10 + 1, nextN +1))
    return -1

print(bfs(a, 1))
        
        
    
    
    
    
        