def solution(x):
    answer = False
    data = x
    arr=[]    
    while x > 0:
        if x >= 10000:    
            arr.append(x//10000)
            x %= 10000
        elif x >= 1000:
            arr.append(x//1000)
            x %= 1000
        elif x >= 100:
            arr.append(x//100)
            x %= 100
        elif x >= 10:
            arr.append(x//10)
            x %= 10
        else:
            arr.append(x)
            x %= x
    
    tmp = 0
    for i in arr:
        tmp += i
    
    if data%tmp == 0:
        return True
    
    return answer

x = 10

print(solution(x))

# 다음은 간편한 풀이

def Harshad(n):
    # n은 하샤드 수 인가요?
    return n % sum([int(c) for c in str(n)]) == 0

# 아래는 테스트로 출력해 보기 위한 코드입니다.
print(Harshad(18))