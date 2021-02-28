#Time Complexity:O(2n)
#Space Complexity:O(1)
#approach:Reverse the whole list, then reverse the first k character and then reverse remaining characters in the list
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums)==0:
            return 
        n=len(nums)
        if k>=n:
            k=k%n
        nums.reverse()
        nums[0:k]=nums[0:k][::-1]
        nums[k:n]=nums[k:n][::-1]