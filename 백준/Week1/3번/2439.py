user_input = int(input())

for i in range(1,user_input+1):
    result = " " * (user_input-i) + "*"*i
    print(result)

