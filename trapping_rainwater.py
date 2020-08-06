# Time Complexity : Add - O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Use 4 pointers. 2 set of pointers denote left wall and left pointer.The other 2 set denotes right wall and right pointer
2. Water can be trapped if left wall is greater than left pointer and if there is a presence of right wall greater than left wall and vice versa

3. So we check if left is < right wall , then chances are that we'd be able to trap water and then we check if left pointer is < left wall. Similarly we repeat for right wall
'''

class Solution:
    def trap(self, height: List[int]) -> int:
        
        if not height or len(height)<3:
            return 0
        
        lw = 0
        l = 1
        
        rw = len(height)-1
        r = len(height)-2
        
        area  = 0
        while (l<=r):
            
            if height[lw] <= height[rw]:
                
                if height[l] < height[lw]:
                    area += height[lw]-height[l]
                else:
                    lw = l
                    
                l += 1
                
            else:
                if height[r] < height[rw]:
                    area += height[rw]-height[r]
                else:
                    rw = r
                    
                r -= 1
        return area
            
                    
        
        