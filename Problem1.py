# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : N/A
# Your code here along with comments explaining your approach: I have followed the optimal approach discussed in the class.
# approach 1:
# two - pass approach.
class Solution:
    def trap(self, height: List[int]) -> int:
        currTrap = 0
        result = 0
        slow = 0
        fast = 1
        '''forward pass'''
        while fast <= len(height)- 1:
            if height[slow] > height[fast]:
                currTrap += height[slow] - height[fast]
            else:
                result += currTrap
                currTrap = 0
                slow = fast
            fast += 1    
        currTrap = 0  
        peek = slow
        #backward pass
        slow = len(height) -1
        fast = slow -1
        while fast >= peek:
            if height[slow] > height[fast]:
                currTrap += height[slow] - height[fast]
            else:
                result += currTrap
                currTrap = 0
                slow = fast
            fast -= 1 
        return result
# approach 2:
# finding Peek then one forward pass untill peek and one backward pass until peek.
# complexity: O(2n) --> O(n) asymptotically.
class Solution:
    def trap(self, height: List[int]) -> int:
        currTrap = 0
        result = 0
        slow = 0
        fast = 1
        # finding peek
        i = 0
        peek = 0
        while i <= len(height) - 1:
            if height[i] > height[peek]:
                peek = i
            i += 1
        # forward pass till peek
        while fast <= peek:
            if height[slow] > height[fast]:
                currTrap += height[slow] - height[fast]
            else:
                result += currTrap
                currTrap = 0
                slow = fast
            fast += 1    
        currTrap = 0  
        #backward pass
        slow = len(height) -1
        fast = slow -1
        while fast >= peek:
            if height[slow] > height[fast]:
                currTrap += height[slow] - height[fast]
            else:
                result += currTrap
                currTrap = 0
                slow = fast
            fast -= 1 
        return result 
# approach 3:
# single pass 
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0:
            return 0
        l = 0
        lw = 0
        rw = 0
        r = len(height) - 1
        result = 0
        while l <= r:    
            if lw <= rw :
                #left
                if height[l] < lw:
                    result += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                #right
                if height[r] < rw:
                    result +=  rw - height[r]
                else:
                    rw = height[r]
                r -= 1
                    
        return result           
                        
                        