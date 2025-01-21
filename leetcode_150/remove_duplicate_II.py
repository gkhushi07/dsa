def remove_duplicate_II(nums):
    i = 2
    for j in range(2, len(nums)):
        if nums[j] != nums[i-2]:
            nums[i] = nums[j]
            i+=1
    return i
    
    
nums = [0,1,3,4,4,4,5]
index = remove_duplicate_II(nums)

print(nums[:index])
