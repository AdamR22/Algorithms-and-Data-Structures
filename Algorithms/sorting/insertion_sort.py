from typing import List

def insertion_sort(numbers: List[int]) -> List[int]:
    for i in range(len(numbers)):
        j = i
        while j > 0 and numbers[j-1] > numbers[j]:
            temp = numbers[j-1]
            numbers[j-1] = numbers[j]
            numbers[j] = temp
            del(temp)
            j = j - 1
           
    return numbers



sample: List[int] = [1, 2, 6, 3, 77, 11, 33, 22, 33, 44, 21]
print(insertion_sort(sample))
