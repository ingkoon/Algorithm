from collections import deque
def solution(cacheSize, cities):
    
    answer = 0
    
    
    for i in range(len(cities)):
        cities[i] = cities[i].lower()
    
    cache = deque()
    cities = deque(cities)
    
    if cacheSize == 0:
        return 5 * len(cities)
    
    while cities:
        
        city = cities.popleft()
        if not cache:
            cache.append(city)
            answer += 5
            continue
        
        if city in cache:
            cache.remove(city)
            cache.appendleft(city)
            answer += 1
            continue
        
        if len(cache) == cacheSize:
            cache.pop()
            cache.appendleft(city)
            answer += 5

        else:
            cache.appendleft(city)
            answer += 5
    
    return answer
