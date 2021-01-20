arr = []
for i in range(9):
    arr.append(int(input()))

print("%d %d" %(max(arr), arr.index(max(arr))+1))
