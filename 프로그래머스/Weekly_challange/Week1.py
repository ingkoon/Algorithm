def solution(price, money, count):
    tmp = 0
    for i in range(1,count+1):
        tmp += price * i
    answer = tmp - money
    if answer > 0:
        return answer
    return 0


price = 3
money = 20
count = 4

print(solution(price, money, count))