class Solution:
    def trap(self, height: List[int]) -> int:
        #Approach: Two-pointers
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #where, n is the length of height
        
        lw = rw = 0                     #height of left and right walls
        l, r = 0, len(height) - 1       #left and right pointers
        
        total_water = 0
        while l <= r:
            if lw <= rw:                #try trapping b/w left wall and left pointer
                if lw > height[l]:
                    total_water += lw - height[l]
                else:
                    lw = height[l]
                l += 1
                
            else:                       #try trapping b/w right wall and right pointer
                if rw > height[r]:
                    total_water += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        
        return total_water