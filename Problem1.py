# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def trap(self, height):
        if len(height) == 0:
            return 0 
        result = 0 
        l, r = 0, len(height)-1 
        lw, rw = 0 , 0 
        
        while l <= r:
            if lw < rw:
                if lw > height[l]:
                    result += (lw - height[l])
                else:
                    lw = height[l]
                l += 1 
            else:
                if rw > height[r]:
                    result += (rw - height[r])
                else:
                    rw = height[r]
                r -= 1 
        return result 
                
        
if __name__ == "__main__":
    s = Solution()
    print(s.trap([0,1,0,2,1,0,1,3,2,1,2,1]))