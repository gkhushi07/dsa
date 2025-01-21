def merge_sorted_array(nums1, n, nums2, m):
    print("nums1 = " , nums1)
    print("nums2 = ", nums2)
    
    i = m-1
    j = n-1
    k = m+n-1
    print(k)

    while(i>=0 and j >= 0):
        if nums1[i] > nums2[j]:
            nums1[k] = nums1[i]
            i-=1
        else:
            nums1[k]=nums2[j]
            j-=1
        k-=1


    while(j>=0):
        nums1[k] = nums2[j]
        j-=1
        k-=1
    
    print("Sorted Array = " , nums1)


# nums1 = [1,2,3,0,0,0]
# nums2 = [2,5,6]

nums1 = [0]
nums2 = [1]


# merge_sorted_array(nums1, 3, nums2, 3)
merge_sorted_array(nums1, 0, nums2, 1) #not working 