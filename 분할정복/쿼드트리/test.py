
import sys

n = int(sys.stdin.readline())

video = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(n)]

result = []
def quadTree(x, y, n):
    # 전역 변수 지정
    global result

    tmp = video[y][x]

    # 좌표상
    for i in range(y, y + n):
        for j in range(x, x + n):
            if tmp != video[i][j]:
                result.append("(")
                quadTree(x, y, n//2)                
                quadTree(x + n//2, y, n//2)
                quadTree(x, y + n//2, n//2)
                quadTree(x + n//2, y + n//2, n//2)
                result.append(")")
                return
    result.append(tmp)

quadTree(0,0,n)
print("".join(map(str,(result))))