def solution(skill, skill_trees):
    answer = 0
    for i in skill_trees:
        result = []
        for j in skill:
            if i.index(j):
                result.append(j)
            else:
                continue
            print(result)
        print("-----------")
        
    return answer
skill = "CBD"

skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]

print(solution(skill, skill_trees))
