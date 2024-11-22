# 189. Rotate Array
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        size = len(nums)
        temp = [0] * size
        for i in range(len(nums)):
            temp[(i+k) % size] = nums[i]

        nums.clear()
        nums.extend(temp)

        