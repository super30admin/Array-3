# Time: O(n) for slicing and concat
# Space: O(n) for sliced nums
# Leetcode: Yes
# Issues: Deep copy on nums and extends.

# slice at k and join
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n                                       # k becomes 0 if k is greater than size. Therfore we dont proceed with slicing
        nums[:] = nums[n-k:] + nums[:n-k]               # cant use a.extend(b) as it returns none
        


# reversing strings
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)                              # k becomes 0

        rnums = nums[::-1]                          # reverse while str
        r1 = rnums[:k][::-1]                        # slice 2nd hlaf and reverse
        r2 = rnums[k:][::-1]                        # slice 1st hlaf and reverse

        nums[:] = r1+r2                             # join both and use a deepcopy
        










