import sys

n = sys.stdin.readline()

x = 1
y =1
route = list(map(str, input().split()))
for i in route:
    if i == "L" and (y>1 and y<=5):
        y -= 1
    elif i == "R" and (y>=1 and y<5):
        y += 1
    elif i == "U" and (x>1 and x<=5):
        x -= 1
    elif i == "D" and (x>=1 and x<5):
        x += 1
print(x, y)