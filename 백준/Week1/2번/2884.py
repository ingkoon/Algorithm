h, m = map(int, input().split(" "))

if h == 0 and m < 45:
    h = 23
    m = 60 + m - 45
elif m<45:
    h -= 1
    m = 60 + m - 45 
else:
    m -= 45

print("%d %d" %(h, m))