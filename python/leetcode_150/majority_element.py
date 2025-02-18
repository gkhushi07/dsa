def majority_elemnet(nums):
    count_hash = {}
    for num in nums:
        if num in count_hash:
            count_hash[num] += 1
        else:
            count_hash[num] = 1
    
    for key in count_hash:
        if count_hash[key] > (len(nums) // 2):
            return key
        else:
            return None

# nums = [2,2,1,1,1,2,2]
# nums = [0]
nums = [0,1,2,3]


print(majority_elemnet(nums))
