def solution(skill, skill_trees):
    answer = 0
    eval1 = []
    for i in range (len(skill)):
        eval1.append([skill[i],i])

    return answer

skill = "CBD"

skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]

print(solution(skill, skill_trees))
