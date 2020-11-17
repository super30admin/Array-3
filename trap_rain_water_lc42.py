"""
Method 1 - Brute force -For every element, find the max on either side, thats how much
water can be stored from that point. In order for water to hold in the crevice, take minimum of
the height and subtract with currect height

Did it run on LC: No - TLE

Time Complexity: O(n^2) - for every element, you will find max on either side which means n^2 comprision

Space Complexity: O(1) - extra space for variables

"""
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height)==0:
            return 0
        
        res = 0
        n = len(height)
        for i in range(0,n-1):
            left = height[i]
            
            for j in range(i):
                left = max(left,height[j])
                
            right = height[i]
            for j in range(i+1,n):
                right = max(right,height[j])
            res = res + (min(left,right) - height[i])
        return res