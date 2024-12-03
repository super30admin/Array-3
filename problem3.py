class Solution(object):
    def rotate(self, nums, k): #T.C ->O(N)
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        self.nums = nums
        self.rev(0,n-1)
        self.rev(0,k-1)
        self.rev(k,n-1)

    
    def rev(self,l,r):
        while l < r:
            self.nums[l],self.nums[r] = self.nums[r],self.nums[l]
            l+=1
            r-=1
    

        