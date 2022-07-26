"""
Approach - 
Starting from left to right - 
We maintain two pointers slow and fast and everytime height[slow]>height[fast]: we add the water that can be collected to a temp variable(currTrap)
Once we find a position where height[fast]>height[slow]- we shift slow to the curr fast and fast to fast+1
We repeat the process from right to left
TC = O(n)
SC = O(1)
"""


class Solution:
    def trap(self, height: List[int]) -> int:
        slow = 0
        fast = 1
        currTrap = 0
        result = 0
        while fast<len(height):
            if height[slow]>=height[fast]:
                currTrap+=height[slow]-height[fast]
                fast+=1
            else:
                result+=currTrap
                currTrap = 0
                slow = fast
                fast = fast+1
        peak = slow
        currTrap = 0
        slow = len(height)-1
        fast = slow -1
        
        while fast>=peak:
            if height[slow]>height[fast]:
                currTrap+=height[slow]-height[fast]
                fast-=1
            else:
                result+=currTrap
                currTrap = 0
                slow = fast
                fast = fast-1
        return result
            
                
        
        