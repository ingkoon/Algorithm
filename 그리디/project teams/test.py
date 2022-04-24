import sys

n  = int(sys.stdin.readline())

arr = list(map(int, sys.stdin.readline().split()))
arr.sort()


result = 200001
for i in range(n):
    if arr[i] + arr[-(i + 1)] < result:
        result = arr[i] + arr[-(i + 1)]

print(result)