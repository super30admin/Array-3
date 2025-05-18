'''
Learnt about the pattern taught in the class.

When the array rotation was specified, always rotate the array, and work out on the pattern.

Hint:
You have to specify rotation in multiple half splits, and one full split.

Initially had issues when I am rotating the array using nums[::-1], it didn't work, as it creates a new list every single time.

Space complexity :O(1)
Time Complexity: O(n)
'''

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        def reverse(nums, start, end):

            while(start<=end):
                nums[start], nums[end] =nums[end],nums[start]
                start+=1
                end-=1

        k=k%len(nums)

        reverse(nums, 0, len(nums)-1)
        reverse(nums, 0,k-1)
        reverse(nums, k,len(nums)-1)






