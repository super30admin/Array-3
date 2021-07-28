class Solution:
    """
    TC:O(n)
    SC:O(1)
    """
    def trap(self, height: List[int]) -> int:
        if not height or len(height)<=2: return 0
        n=len(height)
        h=height
        l=1
        r=n-2
        lw=0
        rw=n-1
        v=0
        # while l<n and r>=0 and l<=r and lw<n and rw>=0:
        while l<=r:
            # if left wall is smaller, move left pointer 
            if h[lw]<=h[rw]:
                if h[l]<h[lw]:
                    v=v+h[lw]-h[l] 
                    l+=1
                else:
                    lw=l
                    l+=1
             # if right wall is smaller, move right pointer
            else:
                if h[r]<=h[rw]:
                    v=v+h[rw]-h[r]
                    r-=1
                else:
                    rw=r
                    r-=1
        return v
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
        
        
