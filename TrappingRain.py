#42. Trapping Rain Water
"""
Time Complexity : O(n)
Space Complexity : O(1)
"""
class Solution:
    def trap(self, height: List[int]) -> int:
        slow = 0
        fast = 1
        result = 0
        curr = 0
        peak = 0
        for i in range(0, len(height)):
            if height[i] > height[peak]:
                peak = i
        
        #pass1 left to right
        while fast <= peak:
            #case1
            if height[slow] > height[fast]:
                curr = curr + height[slow] - height[fast]
            
            #case2
            else:
                result = result + curr
                curr = 0
                slow = fast
            
            fast = fast + 1
            
        #pass2 right to left
        fast = len(height) - 1
        slow = len(height) - 1
        while fast >= peak:
            #case1
            if height[slow] > height[fast]:
                curr = curr + height[slow] - height[fast]
            
            #case2
            else:
                result = result + curr
                curr = 0
                slow = fast
            
            fast = fast - 1
            
        
        return result
