def rotate_array_right(nums, k): 
    n = len(nums)
    k%=n
    temp =[0]*n

    for i in range(n-k):
        temp[i+k] = nums[i]

    for j in range((n-k), n):
        temp[k-(n-j)] = nums[j]

    for k in range(n):
        nums[k] = temp[k]

    print(nums)

nums = [1,2,3,4,5,6,7]
# nums1 = [-1,-100,3,99]

rotate_array_right(nums, 2)

# def rotate_array_left(nums1, k): 

#     n = len(nums1)
#     k%=n
#     temp =[0]*n

#     for i in range(k, n):
#         temp[i-k] = nums1[i]

#     for j in range(k):
#         temp[k-(n+j)] = nums1[j]

#     for k in range(n):
#         nums1[k] = temp[k]

#     print(nums1)

# rotate_array_left(nums1, 2)

def rotate_array_left(nums, k): 
    n = len(nums)
    k %= n  # Handle cases where k is greater than n
    temp = [0] * n  # Temporary array to store rotated elements

    # Place the last (n - k) elements at the beginning
    for i in range(k, n):
        temp[i - k] = nums[i]

    # Place the first k elements at the end
    for j in range(k):
        temp[n - k + j] = nums[j]

    # Copy back from temp to nums
    for i in range(n):
        nums[i] = temp[i]

    print(nums)

# Example usage
nums1 = [1, 2, 3, 4, 5, 6, 7]
rotate_array_left(nums1, 2)





