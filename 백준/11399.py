user_input = int(input())
cntNum = input()

arr = []

for i in range(user_input):
    if cntNum[i].isdigit() == True:
        arr.append(int(cntNum[i]))

arr.sort()

result = 0
ans = 0
for i in range(len(arr)):
    result += arr[i]
    ans += result

print(result)


