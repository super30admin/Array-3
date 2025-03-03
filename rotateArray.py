class Solution:
    # TC : O(n)
    # SC : O(1)
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums is None:
            return
        n = len(nums)
        k = k% n
        for i in range(k):
            nums.insert(0,nums.pop())