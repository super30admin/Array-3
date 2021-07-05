#timecomplexity is o(n)
#space complexity is o(1)
class Solution(object):
    def rotate(self, nums, k):
        n = len(nums)
        k = k % n
        nums[:] = nums[n-k:] + nums[:n-k]
        
                
    
        