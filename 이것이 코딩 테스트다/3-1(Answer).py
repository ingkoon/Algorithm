n = 1260
coin_arr = [500,100,50,10]

result = 0

for coin in coin_arr:
    result += n//coin
    n %= coin 

print(result)