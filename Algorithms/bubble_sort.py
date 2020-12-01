from typing import List

def bubble_sort(arr: List) -> List:
    """
    arr: A list of values
    Performs bubble sort on arr and returns sorted r
    """
    for i in range(len(arr)): #First iterate all the elements
        for j in range(0, len(arr)-i-1): #Iterate through all elements apart from the one in ith index
            if arr[j] > arr[j+1]:
                temp = arr[j] #Temporary variable housing element in ith index
                arr[j] = arr[j+1] #Swap element in ith index for lesser element
                arr[j+1] = temp #Swap greater element for one in ith index
                del(temp) #Delete temporary variable

    return arr

sample: List[int] = [1, 2, 6, 3, 77, 11, 33, 22, 33, 44, 21]
sorted_sample = bubble_sort(sample)
print(sorted_sample)