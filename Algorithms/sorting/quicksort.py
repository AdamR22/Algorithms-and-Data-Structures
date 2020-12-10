from typing import List

def quick_sort(numbers: List[int], low: int, high: int):
    '''
    Numbers: List of numbers to be sorted
    low: Lowest index in numbers
    highest index in numbers
    '''
    
    if low >= high: return
    
    pivot = partition_and_swap(numbers, low, high)
    quick_sort(numbers, low, pivot-1)
    quick_sort(numbers, pivot+1, high)
    
def swap_numbers(numbers: List[int], i, j):
    temp = numbers[i]
    numbers[i] = numbers[j]
    numbers[j] = temp
    del(temp)
    

def partition_and_swap(numbers: List[int], low: int, high: int) -> int:
    pivot = (low+high)//2
    
    swap_numbers(numbers, pivot, high)
    
    i = low
    
    for j in range(low, high):
        if numbers[j] <= numbers[high]:
            swap_numbers(numbers, i, j)
            i += 1
        
    swap_numbers(numbers, i, high)
    return i

sample: List[int] = [1, 2, 6, 3, 77, 11, 33, 22, 33, 44, 21]
quick_sort(sample, 0, len(sample)-1)
print(sample)
