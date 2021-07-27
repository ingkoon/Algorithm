def biggestNum(arr1,arr2):
    arr2.sort()

    result = 0

    cnt = 1

    max = arr2[arr1[0]-1]
    max2 = arr2[arr1[0]-2]

    print(max,max2)
    while cnt <= arr1[1]:
        if cnt % arr1[2] == 0:
            result +=max2
        else:
            result += max
        cnt +=1

    return result



arr1 = [5,8,3]
arr2 = [2,4,5,4,6]

result = biggestNum(arr1,arr2)

print(result)

        
    