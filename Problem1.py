class Solution:
    
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : O(N) 
        Space : O(1)

        Paseed Test Cases : Yes
        
    """
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        left = 0
        right = 0
        i = 0
        j = len(height)-1
        water = 0
        
        while i < j:
            
            left = max(left, height[i])
            right = max(right, height[j])
            
            if left < right:
                water += left - height[i]
                i += 1
            else:
                water += right - height[j]
                j -= 1
        
        return water
