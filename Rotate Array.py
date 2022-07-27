""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums == None or len(nums) == 0:
            return
        k = k % len(nums)
        self.swap(nums, 0, len(nums) - 1)
        self.swap(nums, 0, k - 1)
        self.swap(nums, k, len(nums) - 1)

    def swap(self, nums, p1, p2):
        while p1 < p2:
            nums[p1], nums[p2] = nums[p2], nums[p1]
            p1 += 1
            p2 -= 1

# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         k=k%len(nums)


#         p1=0
#         p2=len(nums)-1
#         while p1<p2:
#             nums[p1], nums[p2]=nums[p2], nums[p1]
#             p1+=1
#             p2-=1


#         p1=0
#         p2=k-1
#         while p1<p2:
#             nums[p1], nums[p2]=nums[p2], nums[p1]
#             p1+=1
#             p2-=1


#         p1=k
#         p2=len(nums)-1
#         while p1<p2:
#             nums[p1], nums[p2]=nums[p2], nums[p1]
#             p1+=1
#             p2-=1

""""// Time Complexity : O(nk)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         if k == 0:
#             return
#         for i in range(1, k + 1):
#             nums.insert(0, nums[-i])
#         del nums[-k:]