import sys

n = int(sys.stdin.readline())

button = [300, 60, 10]
result = [0, 0, 0]
for i in range(3):
    result[i] = n//button[i]
    n = n % button[i]

if n == 0:
    for i in result:
        print(i, end = ' ')
else:
    print(-1)