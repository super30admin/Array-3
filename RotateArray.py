'''
time complexity: O(n)
space complexity: O(1)
'''
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if(k==0 or len(nums)<=1): return
        k=k%len(nums)
        l = 0
        r = len(nums)-1
        while(l<r):
            nums[l],nums[r] = nums[r],nums[l]
            r-=1
            l+=1
        print(nums)
        l = k
        r = len(nums)-1
        while(l<r):
            nums[l],nums[r] = nums[r],nums[l]
            r-=1
            l+=1
        l = 0
        r = k-1
        while(l<r):
            nums[l],nums[r] = nums[r],nums[l]
            r-=1
            l+=1
        