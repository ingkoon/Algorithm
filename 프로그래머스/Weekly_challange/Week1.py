# 함수 선언
def solution(price, money, count):
    # 임시 변수 할당
    tmp = 0    
    for i in range(1,count+1):
        tmp += price * i
    answer = tmp - money
    if answer > 0:
        return answer
    return 0

# 테스트 케이스 인자 선언
price = 3
money = 20
count = 4

# 결과값 출력
print(solution(price, money, count))