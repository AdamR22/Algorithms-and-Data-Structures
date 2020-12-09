def grid_traveler(m, n, memo={}):

    key = (m, n)

    if key in memo: return memo[key]  
    if m == 1 and n == 1: return 1
    if m == 0 or n == 0: return 0

    memo[key] = grid_traveler(m-1, n) + grid_traveler(m, n-1)

    return memo[key]

print(grid_traveler(2, 3))
print(grid_traveler(3, 3))
print(grid_traveler(10, 10))