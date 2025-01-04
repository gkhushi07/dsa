arr = [9,6,4,2,0,1,3,5,7,8]

n = len(arr)

for i in range(n):
    swapped = False
    print("hi")
    min_index = i 
    for j in range(i+1, n):
        if arr[min_index]> arr[j]:
            min_index = j 
    
    arr[i], arr[min_index] = arr[min_index], arr[i]


print(arr)
# i loop runs n times no matter what 