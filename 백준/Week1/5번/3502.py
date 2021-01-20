arr = []
cnt = 0
for i in range(10):
    arr.append(int(input())%42)

arr = set(arr)
print(len(arr))
