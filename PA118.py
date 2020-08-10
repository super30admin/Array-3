#Time Complexity - O(n)
#Space Complexity - O(n)
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        tmp = [0] * len(nums)
        print(tmp)
        for i in range(len(nums)):
            #print(tmp[(i+k) % len(nums)])
            tmp[(i+k)%len(nums)] = nums[i]
        
        for i in range(len(nums)):
            nums[i] = tmp[i]