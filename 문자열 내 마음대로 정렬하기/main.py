def strange_sort(strings, n):
    # 특정 문자열을 기준으로 문자열 정렬
    '''strings의 문자열들을 n번째 글자를 기준으로 정렬해서 return하세요'''
    return sorted(strings, key=lambda x: x[n])

strings = ["sun", "bed", "car"] 
print(strange_sort(strings, 1))

