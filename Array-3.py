# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

class Solution:
    def trap(self, height: List[int]) -> int:
        num_elements = len(height)

        # Initialize arrays to store the maximum to the left and right of each element.
        max_left = [height[0]] * num_elements
        max_right = [height[-1]] * num_elements

        # Fill the max_left array with the maximum height to the left of each element.
        for i in range(1, num_elements):
            max_left[i] = max(max_left[i - 1], height[i])

        # Fill the max_right array with the maximum height to the right of each element.
        for i in range(num_elements - 2, -1, -1):
            max_right[i] = max(max_right[i + 1], height[i])

        # Calculate the total amount of trapped water using the height difference
        # between the minimum of max_left and max_right for each element and the height at that element.
        trapped_water = sum(min(max_left[i], max_right[i]) - height[i] for i in range(num_elements))

        # Return the total amount of trapped water.
        return trapped_water
# TC = O(n), SC = O(n)


## Problem2 H-Index (https://leetcode.com/problems/h-index/)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        def hasAtLeastHPapersWithHCitations(h, citations):
            return sum(cite_count >= h for cite_count in citations) >= h

        low = 0
        high = len(citations)
        while low <= high:
            mid = (low + high) // 2
            if hasAtLeastHPapersWithHCitations(mid, citations):
                low = mid + 1
            else:
                high = mid - 1
        return high
# TC = O(n log n), SC = O(1)

## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # The effective rotation needed when k is larger than the array's length
        k %= len(nums)
      
        # Perform rotation
        # The last k elements are moved to the front and the remainder are appended
        nums[:] = nums[-k:] + nums[:-k]
# TC = O(n), SC = O(1)
