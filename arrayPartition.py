class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        max_sum = 0
        nums.sort()
        for i in range(0, len(nums), 2):
            max_sum += nums[i]
        return max_sum
