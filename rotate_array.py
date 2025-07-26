# Time complexity: O(n)
# Space complexity: O(1)
def rotate(nums, k):
    k %= len(nums)
    def reverse(start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
    reverse(0, len(nums) - 1)
    reverse(0, k - 1)
    reverse(k, len(nums) - 1)

nums = [1,2,3,4,5,6,7]
k = 3
rotate(nums, k)
print(nums)  # Output: [5,6,7,1,2,3,4]
