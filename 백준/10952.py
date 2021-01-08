a, b = map(int, input().split(' '))

while True:
    if ((a == 0) and (b == 0)) and (0<a,b<10):
        break;
    else:
        print(a+b)
        a, b = map(int, input().split(' '))
    