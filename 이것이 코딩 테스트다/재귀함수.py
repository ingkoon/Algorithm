def recursive_function(i):
    if i == 10:
        return
    print(i, '번 재귀함수 호출', i+1,'번 호출 예정')
    recursive_function(i+1)
    print(i, '번째 호출을 종료합니다')

recursive_function(0)