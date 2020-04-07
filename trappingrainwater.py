# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No, giving wrong ans for more than 
#half of the test cases of the type [4,3,2]. Just submitted whatever i tried using two pointer approach


# Your code here along with comments explaining your approach
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        start = 0
        end = 1
        vol = 0
        result = 0
        while end < len(height):
            
            if height[end]>=height[start]:
                result +=vol
                start = end
                end +=1
                vol = 0
            elif end == len(height)-1 and start!=end:
                start +=1
                end = start+1
                vol = 0 
            elif height[end]<height[start]:
                vol+=height[start]-height[end]
                end +=1   
                
        return result
                
            
            
        