#Time Complexity  - O(n)
#Space Complexity - O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n  #Handling  k > n

        # Reverse helper function
        def reverse(start, end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1
        #Reverse entire array
        reverse(0, n - 1)
        #Reverse first k elements
        reverse(0, k - 1)
        #Reverse remaining elements
        reverse(k, n - 1)