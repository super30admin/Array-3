#Rotate Array by K Places

# // Time Complexity :  O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if k%len(nums)==0 or k==0: return nums                  #if we have to rotate it 0 times, then return the array without nay change
        k = k%len(nums)
        def reverse(nums, l,r):
            while(l<r):
                nums[l],nums[r] = nums[r],nums[l]
                l+=1
                r-=1
        
        reverse(nums,0, len(nums)-1)                    #reverse the whole array
        reverse(nums, 0, k-1)                           #reverse the first k elements
        reverse(nums, k, len(nums)-1)                   #reverse the rest of the elements
        return nums