class Solution:
    def trap(self, height: List[int]) -> int:
        total=0
        """using 4 pointers
        Time complexity-O(n) where n is the length of list
        Space complexity-O(1)"""
        l=0
        r=len(height)-1
        lw=0
        rw=0
        while l<=r:
            if lw<rw:
                if height[l]<lw:
                    total+=lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                if height[r]<rw:
                    total+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        return total
            
                    
        