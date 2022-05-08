import sys

n = list(sys.stdin.readline().rstrip())
n.sort(reverse=True)

sum = 0
if '0' not in n:
    print(-1)
else:
    for i in n:
        sum += int(i)
    print(sum)
    if sum%3 != 0:
        print(-1)
    else:
        print(''.join(n))
    



