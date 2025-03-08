# This approach is based on the fact that we can reverse the entire array, then reverse the first k elements and then reverse the remaining n-k elements
# This approach is O(n) in time and O(1) in space 


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        def reverse(nums, first, last):
            while first <= last:
                nums[first], nums[last] = nums[last], nums[first]
                first += 1
                last -= 1

        reverse(nums, 0, len(nums) - 1)
        reverse(nums, 0, k - 1)
        reverse(nums, k, len(nums) - 1)

        return nums