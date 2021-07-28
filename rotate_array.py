# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def rotate(self, nums,k):
        """
        Do not return anything, modify nums in-place instead.
        """

        #    We are taking % because if k > n then it will lead to equivalent k%n value
        n = len(nums)
        k %= n

        #         first we will reverse whole string and then will reverse string till k from start and
        #         then we will reverse rest of the string

        i = 0
        j = n - 1

        while i <= j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1
        i = 0
        j = k - 1

        while i <= j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1
        i = k
        j = n - 1

        while i <= j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1

