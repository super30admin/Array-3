#// Time Complexity : O(N) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No I watched the class video and then solved the problem

class Solution:
    def trap(self, height: List[int]) -> int:
        lw = 0
        rw = len(height) - 1
        l = 0
        r = len(height) - 1
        result = 0

        while l <= r:
            if height[lw] < height[rw]:
                if height[l] < height[lw]:
                    result += height[lw] - height[l]
                else:
                    lw = l
                l += 1
            else:
                if height[r] < height[rw]:
                    result += height[rw] - height[r]
                else:
                    rw = r
                r -= 1
        return result


        # maxid = 0
        # maxi = 0
        # for i in range(len(height)):
        #     if height[i] >maxi:
        #         maxi = height[i]
        #         maxid = i
        # result = 0
        # l = 0
        # for i in range(maxid):
        #     if height[i] < height[l]:
        #         result += height[l] - height[i]
        #     else:
        #         l = i
        
        # r = len(height) - 1
        # for i in range(len(height)-1,maxid,-1):
        #     if height[i] < height[r]:
        #         result += height[r] - height[i]
        #     else:
        #         r = i
        
        # return result

#Approach:
# we keep left wall and right wall. The right wall acts as the guarentee that we can trap the water and we trap the water and add it to the result. 
# If in case the left wall height is greater than the rightwall then we considerr leftwall as guarentee and iterate the right pointer

        