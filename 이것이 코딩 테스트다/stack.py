stack = []

# 삽입(5) - 삽입(2) - 삽입(3) - 삭제() - 삽입(7) - 삽입(9) - 삭제()

# 삽입
stack.append(5)
stack.append(2)
stack.append(3)

# 삭제
stack.pop()

# 삽입
stack.append(7)
stack.append(9)

# 삭제
stack.pop()

# 원소 출력
print(stack)

# 최상단 원소서 부터 출력
print(stack[::-1])