#189. Rotate Array
"""
Time Complexity : O(n)
Space Complexity : O(1)

Here, nums array is overwritten 3 times because we are using slice operation 3 times.
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        #part 1 reverse whole array
        nums[:] = nums[::-1]
        print("part1", nums)
        
        #part 2 reverse parts of array 0 - k - end
        #from 0 to k           #from k to end
        nums[:] = ( nums[k-1::-1] + nums[:k-1:-1] )
        print("part 2", nums)
