arr = [9,6,4,2,0,1,3,5,7,8]

n = len(arr)
swapped = False
for i in range(n):
    swapped = False
    for j in range (0, n-i-1):
        if arr[j]> arr[j+1]:
            arr[j], arr[j+1] = arr[j+1], arr[j]
            swapped = True # if its not true that means in the first iteration only we can state that the array is sorted and we can break 
    if not swapped:
        break

print(arr)
