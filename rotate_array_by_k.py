class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        k = k % len(nums)
        self.swap(0, len(nums)-1, nums)
        
        self.swap(0, k-1, nums)
        self.swap(k,len(nums)-1 , nums)

    def swap(self,left_p,right_p,nums):
        while left_p<right_p:
            nums[left_p],nums[right_p] = nums[right_p],nums[left_p]
            left_p += 1
            right_p-=1