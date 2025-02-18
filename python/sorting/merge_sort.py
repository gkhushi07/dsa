# def merge_sort(arr, si, ei):
# 	if si>=ei:
# 		return 
	
# 	mid = si + (ei-si) / 2
# 	merge_sort(arr, si, mid)
# 	merge_sort(arr , mid+1, ei)
# 	merge(arr, si, mid, ei)


# def merge(arr, si, mid, ei):
# 	merged =[0]*(ei-si)
# 	i = si
# 	j = mid+1
# 	x = 0
	
# 	while(i<= mid and j<= ei):
# 		if(arr[i] < arr[j]):
# 			merged[x] = arr[i]
#             x += 1
#             i += 1
# 		else:
# 			merged[x] = arr[j]
#             x += 1
#             j += 1

# 	while(i<=mid):
# 		merged[x] = arr[i]
#         x += 1
#         i += 1
	
# 	while(j<= ei):
# 		merged[x] = a[j]
#         x += 1
#         j += 1


# 	idx=0, j = si
# 	for idx in merged.length, : 
# 		arr[j] = merged[i]
#         j += 1


# arr = [9,6,4,2,0,1,3,5,7,8]
# merge_sort(arr, 0, arr.length)
# print(arr)


def merge_sort(arr, si, ei):
    if si >= ei:
        return

    mid = si + (ei - si) // 2  # Correct mid calculation
    merge_sort(arr, si, mid)
    merge_sort(arr, mid + 1, ei)
    merge(arr, si, mid, ei)


def merge(arr, si, mid, ei):
    merged = [0] * (ei - si + 1)  # Initialize merged array
    i = si
    j = mid + 1
    x = 0

    # Merge the two halves
    while i <= mid and j <= ei:
        if arr[i] < arr[j]:
            merged[x] = arr[i]
            x += 1
            i += 1
        else:
            merged[x] = arr[j]
            x += 1
            j += 1

    # Copy remaining elements from the left half
    while i <= mid:
        merged[x] = arr[i]
        x += 1
        i += 1

    # Copy remaining elements from the right half
    while j <= ei:
        merged[x] = arr[j]
        x += 1
        j += 1

    # Copy merged elements back into the original array
    for idx in range(len(merged)):
        arr[si + idx] = merged[idx]


# Example usage
arr = [9, 6, 4, 2, 0, 1, 3, 5, 7, 8]
merge_sort(arr, 0, len(arr) - 1)
print(arr)  # Sorted array
