# time complexity : - O(n)
# space complexity:- O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in range(k):
            z = nums.pop()
            nums.insert(0, z)
        return nums