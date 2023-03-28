#All TC on leetcode passed


class Solution:
    def trap(self, height: List[int]) -> int:

        #Here we 4 pointers lw, l, r, rw to track the left wall, cur left ht, cur right ht, right wall. If we have left wall greater than left and right wall greater than or equal to left wall then water at left pointer can be trapped. Similarly if we have right pointer lesser than right wall and right wall lesser than left wall then water at right pointer can be trapped. Here left and right walls act as boundaries for trapping water
        #Time complexity - O(n) 
        #Space complexity - O(1)
        n = len(height)
        l=0
        r=n-1
        lw = 0
        rw = 0

        res = 0
        while l<=r:

            if lw<=rw:
                if height[l]>lw:
                    lw = height[l]
                else:
                    res += (lw-height[l])
                l+=1
            else:
                if height[r]>rw:
                    rw = height[r]
                else:
                    res += (rw-height[r])
                r-=1

        return res




#--------------------------------------------------OR----------------------------------------------------------

 

        #Here we calculate the max left and right right for every position and then we compute the water trapped as min of left and right minus the cur height.
        #Time complexity - O(n) 
        #Space complexity - O(n) - to store the max left and right values fro all heights

        n = len(height)
        maxLeft = [0]*n
        maxRight = [0]*n

        for i in range(1, n):
            maxLeft[i] = max(height[i-1], maxLeft[i-1])
        
        for i in range(n-2,-1,-1):
            maxRight[i] = max(height[i+1], maxRight[i+1])

        res = 0
        for i in range(n):
            minval = min(maxRight[i], maxLeft[i])
            val = (minval-height[i])
            if val>0:
                res = res + val
        return res
        