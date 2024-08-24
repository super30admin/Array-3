def rotateArray(nums,k):
    temp = nums[:]
    l=len(temp)
    for i in range(l):
        nums[(i+k)%l]=temp[i]
    return nums

nums = [1,2,3,4,5,6,7]
k = 3
print(rotateArray(nums, k))

#time = O(n)
