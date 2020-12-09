from typing import Dict

def fibonacci(n: int, memo: Dict={}) -> int:
    if n in memo: return memo[n]

    if n <= 2: return 1
    memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo)

    return memo[n]

print(fibonacci(50))