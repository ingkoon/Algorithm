def solution(array, commands):

    answer = []

    for list in commands:

        slice_list = array[list[0]-1:list[1]]
        slice_list.sort()

        answer.append(slice_list[list[2]-1])

    return answer

array = [1, 5, 2, 6, 3, 7, 4]
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]

print (solution(array, commands))
