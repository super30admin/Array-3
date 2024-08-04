# Time Complexity :
# O(n) 

# Space Complexity :  
# O(n) 


# Approach:
# Create a result array of size "n+1", where n = lenght(citations)
# Then traverset through citations array, and go to current index in result array to update/increment the values.
# Finally, traverse the result array in reverese order, to find the cumulative sum and return the index when that cum. sum become greater than or equal to that index(while traversing).



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