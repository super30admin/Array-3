class Solution:
    def trap(self, height: List[int]) -> int:
        # Time: O(N)
        # Space: O(1)
        if height==[]:
            return 0
        LW = 0
        RW = 0
        L = 0
        R = len(height)-1
        sol = 0
        
        while L<=R:
            if LW<=RW:
                if(LW<height[L]):
                    LW = height[L]
                else:
                    sol+=LW - height[L]
                L+=1
            else:
                if(RW<height[R]):
                    RW = height[R]
                else:
                    sol+=RW - height[R]
                R-=1
        return sol