"""
Reverse the entire array
Reverse the first k elements
Reverse the remaining n - k elements
"""
"""
Time Complexity: O(n) - Traversal
Space Complexity: O(1) (in-place)
"""


class rotateArray:
    def rotate(self, nums: list[int], k: int) -> None:
        n = len(nums)
        k %= n  

        def reverse(start, end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1

        reverse(0, n - 1)
        reverse(0, k - 1)
        reverse(k, n - 1)

if __name__ == "__main__":
    nums = [1,2,3,4,5,6,7]
    k = 3
    obj = rotateArray()
    obj.rotate(nums, k)
    print(nums)
