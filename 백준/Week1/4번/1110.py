user_input = int(input())

cnt = 0

a = int(user_input/10)
b = user_input%10

while True:
    result = a + b
    new = b*10 + result%10
    
    if user_input == new:
        cnt +=1
        break
    else:        
        cnt += 1
        a = int(b)
        b = result % 10

print(cnt)
