# Time O(n)
# Space O(n)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        while k > n: k = k - n
        arr = nums.copy()
        for i in range(n-k):
            if i < n-k:
                nums[i+k] = arr[i]
        j = 0
        for i in range(n-k, n):
            nums[j] = arr[i]
            j += 1

# Time O(2n)
# Space O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if n <=1: return
        while k > n: k = k - n
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)
        

    def reverse(self, nums: List[int], left: int, right: int):
        while left < right:
            temp = nums[right]
            nums[right] = nums[left]
            nums[left] = temp
            left += 1
            right -= 1
        

     
        