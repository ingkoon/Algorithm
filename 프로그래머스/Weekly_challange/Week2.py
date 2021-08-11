# programmers weekly challange 2주차

# 상호 평가
def solution(scores):
    
    # 결과값
    answer = ''
    
    # 임시리스트
    arr = []  

    # 평균을 나누기 위한 정수를 저장하는 리스트      
    cnt = []
    
    # 총합 값을 저장하기 위한 배열
    result = [0 for i in range (len(scores))]

    
    for i in range(len(scores)):

        # 배열의 n*n값은 기준값으로 사용하기 위해 별도로 지정
        val = scores[i][i]    

        # 열의 값을 반복문을 통해 추가
        for j in range(len(scores[i])):
            if j == i:
                continue           
            arr.append(scores[j][i])
                            
        # n*n에 해당하는 값이 기준에 부합한다면 배열에 추가
        if val <= max(arr) and val >= min(arr):
            arr.append(val)
        
        # 배열의 개수만큼 카운트 추가
        cnt.append(len(arr))
        
        # 총합값 반복문을 통해 계산
        for k in arr:
            result[i] += k    
        
        # 배열 초기화
        arr = []

    # 반복문으로 평균값 계산 후 처리
    for n, m in zip(result, cnt):
        avg = i/j
        print(avg)
        if avg >= 90:
            answer += 'A'
        elif 90 > avg and avg >= 80:
            answer += 'B'
        elif 80 > avg and avg >= 70:
            answer += 'C'
        elif 70 > avg and avg >= 50:
            answer += 'D'
        else:
            answer += 'F'                               
    
    return answer

scores = [[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]

solution(scores)