import time

time0 = time.time() 

#입력
n = list(input())

#배열의 첫번째값을 저장
result = int(n[0])

# for문을 반복하여 값을 더하거나 곱한다.
for i in range(1,len(n)):

    val = int(n[i])

    #둘중 하나가 0일 경우 더하기 연산을 수행
    if result == 0 or val == 0:
        result += val
    # 그 외의 케이스는 모두 곱셈을 수행한다.
    else:
        result *= val
print(result)
    
print(time.time() - time0)
