class Solution(object):
    def rotate(self, nums, k):
        """
        Time complexity:  O(n)
        Space complexity: O(1)
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if nums is None or len(nums) == 0:
            return

        n = len(nums)
        if k > n:
            k = k % n

        # Function to reverse a portion of the array 'nums' from index 'left' to index 'right'.
        def reverse(nums, left, right):
            while left < right:
                # Swap elements at indices 'left' and 'right'.
                nums[left], nums[right] = nums[right], nums[left]
                # Move the left pointer one step right, and the right pointer one step left.
                left += 1
                right -= 1

        # Step 1: Reverse the entire array 'nums'. This brings the last 'k' elements to the front
        # and the first 'n-k' elements to the end.
        reverse(nums, 0, n - 1)

        # Step 2: Reverse the first 'k' elements of the array 'nums'. Now the last 'k' elements (originally at the front)
        # are at the end, and the first 'n-k' elements are at the front.
        reverse(nums, 0, k - 1)

        # Step 3: Reverse the remaining elements in the array 'nums' (from index 'k' to 'n-1').
        # The elements originally from the front of the array are now at the front of the rotated array.
        reverse(nums, k, n - 1)
