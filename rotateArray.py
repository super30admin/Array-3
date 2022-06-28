'''
Time Complexity: 0(n)
Space Complexity: 0(1)
Runon leetcode: Yes
'''

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if k > len(nums):
            k = k%(len(nums))
        
        # 1. swap n-k elements
        ptr1= 0
        ptr2 = len(nums)-k-1
        
        while ptr1 <= ptr2:
            # swap ptr1 and ptr2 value
            nums[ptr1],nums[ptr2] = nums[ptr2], nums[ptr1]
            ptr1+=1
            ptr2-=1

        
        # 2. swap k elements
        ptr1= len(nums)-k
        ptr2 = len(nums)-1
        
        while ptr1 <= ptr2:
            # swap ptr1 and ptr2 value
            nums[ptr1],nums[ptr2] = nums[ptr2], nums[ptr1]
            ptr1+=1
            ptr2-=1
        
        # 3. swap entire nums list
        ptr1= 0
        ptr2 = len(nums)-1
        
        while ptr1 <= ptr2:
            # swap ptr1 and ptr2 value
            nums[ptr1],nums[ptr2] = nums[ptr2], nums[ptr1]
            ptr1+=1
            ptr2-=1
        
        
        # rerturn the result
        print("Nums is:\t",nums)