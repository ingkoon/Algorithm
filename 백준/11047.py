a, b = (map(int, input().split(' ')))

arr = []

for i in range(a):
    arr.append(int(input()))
    
arr.sort(reverse = True)

cnt = 0

for j in range(len(arr)):

    cnt += int(b/arr[j])
    b = b%arr[j]

print(cnt)
    

