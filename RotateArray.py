#Time Complexity- O(N)
#Space Complexity- O(1)
def rotate(self, nums, k):
    k %= len(nums)
        
    def reverse(nums, i, j):
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1
    #reversing three times
    #reversing whole array
    reverse(nums, 0, len(nums)-1)
    #reversing till k
    reverse(nums, 0, k-1)
    #reversing from k till length of array
    reverse(nums, k, len(nums)-1)