#Time COmplexity : O(N) where N is number of elements 
#Space Complexity :O(1) class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) ==0 :
            return 0
        l = 0
        r = len(height)-1
        lw = 0
        rw = 0
        amount = 0
        
        while (l <= r):
            if lw < rw:
                if lw < height[l]:
                    lw = height[l]
                else:
                    amount+=lw - height[l]
                l+=1
            else:
                if rw < height[r]:
                    rw = height[r]
                else:
                    amount += rw -height[r]
                r-=1
        return amount