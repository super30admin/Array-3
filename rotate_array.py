class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return None
        k %= len(nums)
        def swap(nums, start, end):
            while(start<=end):
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1
        swap(nums, 0, len(nums)-1)
        swap(nums, 0, k-1)
        swap(nums, k, len(nums)-1)

#time complexity - O(n)
#space complexity - O(1), inplace

#all test cases passed