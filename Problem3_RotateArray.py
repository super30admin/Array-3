# Time Complexity: O(n), where n is length of the input array
# Space Complexity: O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if not nums or len(nums) == 0:
            return

        n = len(nums)
        k = k % n

        # Reverse the entire array
        self.reverse(nums, 0, n - 1)

        # Reverse the array from indices 0 to k - 1
        self.reverse(nums, 0, k - 1)

        # Reverse the array from indices k to n - 1
        self.reverse(nums, k, n - 1)


    def reverse(self, nums: List[int], start: int, end: int) -> None:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1