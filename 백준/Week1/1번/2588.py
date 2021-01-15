n1 = int(input())
n2 = int(input())

hunN = int(n2/100)
tenN = int((n2%100)/10)
oneN = int(n2%10)

result1 = n1 * oneN
result2 = n1 * tenN
result3 = n1 * hunN

print ("%d\n%d\n%d" %(result1, result2, result3))

result = result1 + result2 + result3

print(result)
