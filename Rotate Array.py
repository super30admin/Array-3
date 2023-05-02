class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Time Complexity: O(n)
        # Space Complexity: O(1)
        n = len(nums)
        if n == 0: return

        def swap(i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp

        def reverse(i, j):
            while i <= j:
                swap(i, j)
                i += 1
                j -= 1

        if k > n:
            k = k % n

        reverse(0, n - 1)
        reverse(0, k - 1)
        reverse(k, n - 1)

