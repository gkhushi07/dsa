def next_greater_number(n):

    nums = list(str(n))
    n = len(nums)

    min_digit = float('inf')

    for i in range(n-1, -1, -1):
        if nums[i] > nums[i-1]:
            for j in range(i, n):
                if nums[j] < min_digit:
                    min_digit = nums[j]
                    min_index = j
            nums[i-1], nums[min_index] = nums[min_index], nums[i-1]
        break
    nums = nums[:i] + sorted(nums[i+1:])
    print(nums)

n = 218765

next_greater_number(n)
    