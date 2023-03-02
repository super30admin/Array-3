# Time Complexity = O(n)
# Space Complexity = O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        [-1,-100,3,99] k = 2
        [-100, -1, 99, 3]
        """
        k = k % len(nums)
        if k == 0:
            return nums

        def rotate(i, j):
            while i < j:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
                j -= 1

        rotate(0, len(nums)-1)
        rotate(0, k-1)
        rotate(k, len(nums)-1)
#         print(nums)
#         for i in range(k):
#             nums[i], nums[len(nums)-i-1] = nums[len(nums)-i-1], nums[i]

        print(nums)
