
graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}

def bfs(graph, start):
    visited = []
    queue = [start]

    while queue:
        n = queue.pop()
        if n not in visited:
            visited.append(n)
            queue += graph[n] - set(visited)
    return visited

print(bfs(graph, 'A'))
