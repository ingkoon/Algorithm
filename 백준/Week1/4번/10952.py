a, b = map(int, input().split(' '))

arr1 = []
arr2 = []

arr1.append(a)
arr2.append(b)

while (True):
    if ((a == 0) and (b == 0)) and (0<a,b<10):
        break
    else:
        a, b = map(int, input().split(' '))
        arr1.append(a)
        arr2.append(b)

for i in range(len(arr1)-1):
    print("%d" %(arr1[i] + arr2[i]))
    