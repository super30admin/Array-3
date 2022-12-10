# https://leetcode.com/problems/trapping-rain-water
'''
Approach 1: Array

We create 2 arrays leftMax and rightMax to store the max left and max right height for each tower in heights thus space complexity = O(n + n)

We iterate over leftMax array and store max height for each tower comparing with the previous leftMax and the current height  TC = O(n)

Then similarly we iterate over rightMax(backwards) array and store max height for each tower by comparing with the previous leftMax and the current height  TC = O(n)

Then, we add to ans the difference between min of left and right height and current height = TC = O(n)

Thus total TC: O(n + n + n) = O(n)
Thus total SC: O(n + n) = O(n)

'''
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        leftMax = [0 for i in range(len(height))]
        rightMax = [0 for i in range(len(height))]
        
        leftMax[0] = height[0]
        
        for i in range(1,n):
            leftMax[i] = max(height[i], leftMax[i-1])
           
        rightMax[n-1] = height[n-1]
        for i in range(n-2, -1, -1):
            rightMax[i] = max(rightMax[i+1], height[i])
            
        ans = 0
        for i in range(1,n):
            ans += min(leftMax[i], rightMax[i]) - height[i]
        
        return ans
            

# Approach 2: 2 pointer
class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height)-1
        
        lMax = float("-inf")
        rMax = float('-inf')
        
        ans = 0
        
        while (l <= r):
            lMax = max(lMax, height[l])
            rMax = max(rMax, height[r])
            
            if(lMax < rMax):
                ans += lMax - height[l] 
                l += 1
            else:
                ans += rMax - height[r]
                r -= 1
        
        return ans
            