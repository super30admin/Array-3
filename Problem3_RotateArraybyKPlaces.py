'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 189. Rotate Array


# https://leetcode.com/problems/rotate-array/

#-----------------
# Time Complexity: 
#-----------------
# O(N): Reverse N elements, then K elements, then N-K elements = 2N operations
#------------------
# Space Complexity: 
#------------------
# O(1) - In place swapping. Need temp variable. Constant space

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(nums, l, r):
            while l < r:
                temp = nums[l]
                nums[l] = nums[r]
                nums[r] = temp
                l += 1
                r -= 1
            
        n = len(nums)
        if n == 0:
            return None
        
        k %= n
        reverse(nums, 0, n-1)
        reverse(nums, 0, k-1)
        reverse(nums, k, n-1)