class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """First reverse whole string, then reverse till k ele and reverse other n-k ele
        Time complexity-O(n)
        Space complexity-O(1)"""
        k=k%len(nums)
        # self.reverse(nums, 0, len(nums)-1)
        # self.reverse(nums, 0, k-1)
        # self.reverse(nums, k, len(nums)-1)
        """Reverse first n-k elements, then reverse other k ele, then reverse whole string"""
        self.reverse(nums, 0, len(nums)-k-1)
        self.reverse(nums, len(nums)-k, len(nums)-1)
        self.reverse(nums, 0, len(nums)-1)
        
        
    def reverse(self, nums, start, end):
        while start<end:
            nums[start],nums[end]=nums[end], nums[start]
            start+=1
            end-=1
    
            
        
        """
        Do not return anything, modify nums in-place instead.
        """
        """Time complexity-O(n)
        Space complexity-O(n)"""
        # n=len(nums)
        # k=k%n
        # nums[:]=nums[n-k:]+nums[:n-k] 
        """Time elimit exceeded
        Time complexity-O(nk)
        Space complexity-O(1)"""
        # while k:
        #     j=1
        #     temp=nums[0]
        #     while j<len(nums):
        #         temp1=nums[j]
        #         nums[j]=temp
        #         temp=temp1
        #         j+=1
        #     nums[0]=temp
        #     k-=1
                
        