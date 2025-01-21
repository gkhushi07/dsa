def remove_duplicate_I(nums):
    i = 0
    for j in range (len(nums)):
        # print(i-2,nums[i-2])
        
        if nums[j] != nums[i-2]:
            nums[i] = nums[j]
            i+=1
            # print(nums)
    return i
    
# nums = [1]
# nums = [1,1,1,3,2,2,4,4,0,0,1]
nums = [1,1,1,3,2,2,4,4,0,0,1]

index=remove_duplicate_I(nums)

if index ==0:
    print([nums[0]])
else:
    print(nums[:index])