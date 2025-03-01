# tc O(n), sc O(1).
def reverse(start, end):
    while start < end:
        nums[start], nums[end] = nums[end], nums[start]
        start += 1
        end -= 1

k = k % len(nums)
reverse(0, len(nums)-1)
reverse(0, k-1)
reverse(k, len(nums)-1)