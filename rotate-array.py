# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        
        """
        Do not return anything, modify nums in-place instead.
        
        """
        
        if nums==None or len(nums)==0: return nums
        def rev(nums,s,e):
            s=s
            e=e
            while s<=e:
                nums[s],nums[e]=nums[e],nums[s]
                s+=1
                e-=1
        n=len(nums)
        k=k%n
        rev(nums,0,n-1)
        rev(nums,0,k-1)
        rev(nums,k,n-1)