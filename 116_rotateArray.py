'''
Accepted on leetcode(189)
time - O(N)
space - O(1)
Approach:
1. Take the modulus value for k, as 'k' can be larger than length of array as well.
2. reverse whole array.
3. reverse first kth part.
4. reverse remaining part.
'''


class Solution:
    def rotate(self, nums, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        # 1. reverse whole array
        self.reverse(nums, 0, len(nums) - 1)
        # 2. reverse first kth part
        self.reverse(nums, 0, k - 1)
        # 3. reverse remaining part
        self.reverse(nums, k, len(nums) - 1)

    def reverse(self, nums, i, j):
        while i < j:
            print(i, j)
            # swapping
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp

            i += 1
            j -= 1

