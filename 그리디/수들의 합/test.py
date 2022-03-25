import sys

s = int(sys.stdin.readline())

cnt = 0
d = 0

for i in range(1, s):
    if d + i <= s:
        d += i
        cnt += 1
        continue
    break

print(cnt)

