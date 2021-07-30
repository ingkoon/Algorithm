def change(n):
    #총 4개의 경우에 대한 조건문 정의를 통해 문제 해결
    result_arr = [0,0,0,0]
    while n != 0:
        if n >= 500:
            result_arr[0] = n//500
            n = n%500
        elif n >= 100:
            result_arr[1] = n//100
            n = n%100
        elif n >= 50:
            result_arr[2] = n//50
            n = n%50
        else:
            result_arr[3] = n//10
            n = n%10
    return result_arr

n = 1250
result = [0,0,0,0]
result = change(n)
print(result[0], result[1], result[2], result[3])