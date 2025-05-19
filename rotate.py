class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Approach:
        1. This uses the array reversal method to rotate the array in-place.
        2. To rotate the array to the right by k steps:
           - First, reverse the entire array.
           - Then, reverse the first k elements.
           - Finally, reverse the remaining n - k elements.
        3. This repositions the elements to their correct rotated order.

        Time Complexity: O(n) — Each element is visited a constant number of times.
        Space Complexity: O(1) — In-place rotation without using extra space.
        """
        d = k % len(nums)  # In case k > len(nums)

        def rotate_section(start, end):
            while start <= end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1

        rotate_section(0, len(nums) - 1)
        rotate_section(0, d - 1)
        rotate_section(d, len(nums) - 1)
