# 완주하지 못한 선수
def solution(participant, completion):
    # 선수 정렬
    participant.sort()
    completion.sort()
    # 두개의 리스트에서 각각 요소를 추출하여 반복문 수행
    for i, j in zip(participant, completion):
        # 다를 경우 i 반환
        if i != j:
            return i
    # 전부 같을 경우 가장 마지막의 선수 반환            
    return participant[-1]

print(solution(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]))