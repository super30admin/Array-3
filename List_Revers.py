#Space:O(1) in place
#Time:O(n)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k=k%len(nums)
        def list_reverse(l,r,nums):
            while(l<r):
                nums[l],nums[r]=nums[r],nums[l]
                l+=1
                r-=1
        list_reverse(0,len(nums)-1,nums)
        list_reverse(0,k-1,nums)
        list_reverse(k,len(nums)-1,nums)
        return nums