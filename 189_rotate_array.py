from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        """
            https://leetcode.com/problems/rotate-array/
            Time Complexity - O(n)
                'n' is the length of the list
            Space Complexity - O(1)
            
            Right Rotation: 
                 - Reverse whole list
                 - Reverse (0, k - 1)
                 - Reverse (k, n - 1)
            
            Left Rotation: 
                - Reverse whole list
                - Reverse (0, n-k-1)
                - Reverse (n-k, n-1)
        """
        k = k % len(nums)
        self._reverse(nums, 0, len(nums) - 1)
        self._reverse(nums, 0, k - 1)
        self._reverse(nums, k, len(nums) - 1)

    def _reverse(self, nums: List[int], start, end) -> None:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        """
            Time Complexity - O(kn)
            Space Complexity - O(1) 
        """
        k = k % len(nums)
        for i in range(k):
            nums.insert(0, nums.pop())

    def rotate(self, nums: List[int], k: int) -> None:
        """
            Time Complexity - O(n)
            Space Complexity - O(n)
        """
        n = len(nums)
        result = [0] * len(nums)
        for i in range(0, n - k):
            result[i + k] = nums[i]
        for i in range(0, k):
            result[i] = nums[(n - k) + i]
        print(result)


if __name__ == '__main__':
    Solution().rotate([1, 2, 3, 4, 5, 6, 7], 3)
