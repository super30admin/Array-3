# Time: O(n) for all
# Space: O(n) worst // O(1) best
# Leetcode: Yes
# Issues: No


# 2 pointers and 2 walls// Space: O(1) 1 pass solution
class Solution:
    def trap(self, height: list[int]) -> int:
        n = len(height)

        result = 0
        l, lw = 0,0
        r, rw = n-1,0                           # right pointer starts form end

        while l <= r:                           # 2 pointers cross each other
            if lw <= rw:                        # if right wall is bigger we traverse left        
                if lw > height[l]:
                    result += lw - height[l]
                else:
                    lw  = height[l]
                l+=1
            else:                               # if left wall is bigger we traverse right   
                if rw > height[r]:
                    result += rw - height[r]
                else:
                    rw = height[r]
                r-=1
        return result
    

# mononically increasing stack pattern// Space: O(n) for stack
class Solution:
    def trap(self, height: list[int]) -> int:
        n = len(height)
        st = []
        res = 0

        for i in range(n):
            while st and height[i] > height[st[-1]]:                        # only when you find a wall that is bigger than previous wall, we pop
                popped = st.pop()       
                if st:
                    w = i - st[-1] -1
                    minHt = min(height[i],height[st[-1]])                               
                    res += w * (minHt - height[popped])                                     # calculate area
            st.append(i)                                                    # otherwise push it to stack

        return res
        

# Using max height(and its index); then traverse left and right// Space: O(1) 3 pass soln
class Solution:
    def trap(self, height: list[int]) -> int:
        n = len(height)
        maxIdx = -1                                         
        maxHeight = 0                                           

        for i in range(n):                                  # find max height
            if maxHeight < height[i]:
                maxHeight = height[i]
                maxIdx = i
            
        l = 0
        lw = 0
        result = 0

        while l < maxIdx:                                       # left traversal
            if lw > height[l]:
                result += lw - height[l]
            else:
                lw = height[l]
            l+=1
        
        r  = n-1
        rw = 0

        while r > maxIdx:                                       # right reverse traversal
            if rw > height[r]:
                result += rw - height[r]
            else:
                rw = height[r]
            r-=1
        return result
    

# 3 pass max height arrays difference solution

class Solution:
    def trap(self, height: list[int]) -> int:
        n = len(height)
        
        l = [0] * n                                     # find left maxht array
        l[0] = height[0]    
        for i in range(1,n):
            l[i] = max(l[i-1],height[i])

        r = [0] * n                                     # find right maxht array
        r[n-1] = height[n-1]
        for i in range(n-2,-1,-1):
            r[i] = max(r[i+1],height[i])    

        res = 0 
        for i in range(n):                              # compute min bw 2 heights - curent height, if negative we consider 0
            res += max(0, min(l[i],r[i]) - height[i])

        return res        









