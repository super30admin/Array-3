class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l = [0 for i in range(len(nums))]
        n=len(nums)
        for i in range(len(nums)): 
            if i+k<n:
                l[i+k]=nums[i]
            else:
                x=(i+k)%n
                l[x]=nums[i]      
        for i in range(len(l)):
            nums[i]=l[i]
        return
