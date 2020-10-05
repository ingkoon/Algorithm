def solution(skill, skill_trees):
    answer = 0
    eval1 = []
    for i in range (len(skill)):
        eval1.append([skill[i],i])

    temp = []
    eval2 = []
    for j in range (len(skill_trees)):
        for k in range (len(skill_trees[j])):
            temp.append([skill_trees[j][k],k])
        eval2.append(temp)
        temp = []
    
    return answer
skill = "CBD"

skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]

print(solution(skill, skill_trees))
