from typing import List

def selection_sort(arr: List) -> List:
    """
    arr: Unsorted list/array
    Returns sorted arr
    """

    index: int = 0 #Variable for storing our indices

    for i in range(len(arr)):
        index = i #Reassign index with current index in loop

        for j in range(i+1, len(arr)): #Iterate through all elements apart from one in ith index
            if arr[j] < arr[index]: index = j #If element smaller than one in i, reassign variable index
        
        if index != i: #If index not equal to i, swap elements
            temp = arr[i]
            arr[i] = arr[index]
            arr[index] = temp
            del temp

    return arr

sample: List[int] = [1, 2, 6, 3, 77, 11, 33, 22, 33, 44, 21]
sorted_sample = selection_sort(sample)
print(sorted_sample)