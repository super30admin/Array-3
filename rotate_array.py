# Time: O(n)
# Space: O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if(k > len(nums)):
            k = k%len(nums)
        
        # reverse whole list
        # |7,6,5,4,3,2,1|
        nums.reverse()
        
        temp1 = nums[:k]       
        temp2 = nums[k:]
        
        # reverse two halves of the list
        # |7,6,5||,4,3,2,1|
        temp1.reverse()
        temp2.reverse()

        nums[:k] = temp1
        nums[k:] = temp2