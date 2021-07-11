"""189. Rotate Array
TC - O(N)
SC - O(1)"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def rev(i, j):
            while i<j:
                nums[i], nums[j] = nums[j], nums[i]
                i+=1
                j-=1

        if k>len(nums):
            k = k%len(nums)

        # Logic
        rev(0, len(nums)-1) # Reverse entire array
        rev(0, k-1) # Reverse 0 to k
        rev(k, len(nums)-1) # Reverse k to end

        return nums 