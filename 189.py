class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        array = [0]* len(nums)
        n = len(nums)
        for i in range(n):
            array[(i+k)% n] = nums[i]
        for i in range(n):
            nums[i] = array[i]
        return nums