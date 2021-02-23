class Solution:
    def trap(self, height: List[int]) -> int:
        '''
        Time Complexity: O(n)
        Space Complexity: O(1)
        '''
        if(len(height)<2):
            return 0
        lw = 0
        rw = len(height)-1
        l = 1 
        r = len(height)-2
        result = 0
        while(l<=r):
            if(height[lw]<=height[rw]):
                # process left side
                if(height[l]<height[lw]):
                    # decrease left wall - left pointer
                    result += height[lw]-height[l]
                    l+=1
                else:
                    lw=l
                    l+=1
            else:
                # process right side
                if(height[r]<height[rw]):
                    # decrease right wall- right pointer
                    result += height[rw]-height[r]
                    r-=1
                else:
                    rw=r
                    r-=1
            
        return result
