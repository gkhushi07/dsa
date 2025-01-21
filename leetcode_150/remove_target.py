def remove_target(nums, target):
    i=0
    for j in range(len(nums)):
        if nums[j] != target:
            nums[i] =nums[j]
            i+=1
    return i

nums= [1,3,3,2,4,3,7]
index = remove_target(nums, 3)
print(nums[:index])
    