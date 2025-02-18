
arr = [5, 1, 7, 3, 2, 11, 15, 7]

print("This is unsorted array:", arr)

# def insertion_sort(arr):
#     for i in range(1, len(arr)):
#         curr = arr[i]
#         pos = i
        
#         for j in range(i-1, -1, -1):
#             if curr < arr[j]:
#                 arr[j+1] = arr[j]
#                 pos = j
        
#         arr[pos] = curr

# insertion_sort(arr)
# print("This is sorted array:", arr)


def insertion_sort(arr):
    for i in range(1, len(arr)):
        curr = arr[i]
        j = i-1
        while(j>=0 and arr[j]>curr):
            arr[j+1]= arr[j]
            j-=1
        
        arr[j+1] = curr

insertion_sort(arr)

print("This is sorted array:", arr)
