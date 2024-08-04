# Time Complexity :
# O(n) 


# Space Complexity :  
# O(1) 


# Approach:
# Reverse the original array. Then update k , in case k > n.
# Reverse the array again from index 0 to k-1, which will give us first subpart of result array.
# reverse the array again from index k to n-1, which will give us second subpart of the array.



class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if not nums or len(nums)==0:
            return nums

        n = len(nums)
        k = k % n    # to take into account k > n
        # Reverse the array, and then reverese subarrays from 0 to k, then k to n-1
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)
    

    def reverse(self, nums, l, r):
        while(l <= r):
            self.swap(nums, l, r)
            l += 1
            r -= 1
    
    def swap(self, nums, l, r):
        temp = nums[l]
        nums[l] = nums[r]
        nums[r] = temp
        