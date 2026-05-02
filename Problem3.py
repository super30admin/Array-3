# https://leetcode.com/problems/rotate-array/description/


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n

        i = 0
        count = 0

        while count < n:
            currIdx = i
            currVal = nums[i]

            while True:
                nextIdx = (currIdx + k) % n
                nextVal = nums[nextIdx]

                nums[nextIdx] = currVal

                currIdx = nextIdx
                currVal = nextVal

                count += 1
                if i == currIdx: break

            i += 1


# Using reverse and swap
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n

        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)

    def reverse(self, nums, l, r):
        while l < r:
            self.swap(nums, l, r)
            l += 1
            r -= 1

    def swap(self, nums, i, j):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp