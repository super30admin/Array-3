
// Time Complexity  : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this    : No


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n= len(nums)
        k=k%n
        
        temp=nums[n-k:]
        
        for i in range(0,n-k):
                j=(i+k)%n
                temp.append(nums[i])
                
        for i in range(0,n):
            nums[i]=temp[i]
        
        return nums