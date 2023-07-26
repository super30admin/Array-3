# In place operation using reversed() function.
# Time and space complexity : O(n) and O(1).
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        k = k % length # If k > n then it'll set pivot in bounds of an array
        nums[:length-k] = reversed(nums[:length-k]) # reversing last k elements in place
        nums[length-k:] = reversed(nums[length-k:]) # reversing first len-k elements
        nums[:] =reversed(nums[:]) # Reversing the entire list
        print(nums)
        
        