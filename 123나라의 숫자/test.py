def solution(n):
    # 반환은 문자열로 이루어져야 한다.
    answer = ''
    
    #n을 전부 소모시킬 때 까지
    while n:
        # 3으로 나누어지는 숫자가 아닐 경우 나머지를 더한다(문자열로 변환 후!)
        if n % 3:
            answer += str(n%3)
            n //= 3
        # 3으로 떨어질 경우 4로 바꾸어 더한다
        else:
            answer += '4'
            n = n//3-1
            
    # 결과인 문자열을 거꾸로 뒤집어 출력한다.
    return answer[::-1]

print(solution(15))