class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #Time: O(N)
        #Space: O(1)
        k=k%len(nums)
        def swap(nums,i,j):
            while i<j:
                nums[i],nums[j]=nums[j],nums[i]
                i+=1
                j-=1
            return nums
        nums = swap(nums,0,len(nums)-1)
        nums = swap(nums,0,k-1)+swap(nums,k,len(nums)-1)