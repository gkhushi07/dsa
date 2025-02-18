def swap(arr, a, b):
    arr[a], arr[b] = arr[b], arr[a]
    
def partition(arr, si, ei):
    i= si-1 
    pivot= arr[ei] 

    for j in range(si, ei):
        if arr[j]<= pivot:
            i+=1
            arr[j], arr[i] = arr[i], arr[j]
            
    i+=1 
    print(pivot,arr, ei, i)
    arr[ei], arr[i] = arr[i], arr[ei]
    return i

def quickSort(arr, si, ei):
    if si < ei:
        pi = partition(arr, si, ei)
        quickSort(arr, si, pi-1)
        quickSort(arr, pi+1, ei)



arr = [7,2,9,1,5,3]

quickSort(arr, 0, len(arr)-1 )
print(arr)
