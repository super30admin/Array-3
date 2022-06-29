'''
In single pass
Time: o(n)
Space: O(1)
'''


class Solution:
    def trap(self, height: List[int]) -> int:
        
        if height is None:
            return 0
        
        res = 0
        l = 0
        r = len(height)-1
        lw = 0
        rw = len(height)-1
        
        while l <= r:
            if height[lw] <= height[rw]:
                if height[lw] < height[l]:
                    lw = l
                else:
                    res += height[lw] - height[l]
                l+=1
            else:
                if height[rw] < height[r]:
                    rw = r
                else:
                    res += height[rw] - height[r]
                r-=1
        return res


'''
Finding max and iterate from left then right
Time: O(n)
Space: (1)
'''

class Solution:
    def trap(self, height: List[int]) -> int:
        
        if height is None:
            return 0
        
        ma,mi,res = 0,0,0
        for i in range(len(height)):
            if ma <= height[i]:
                ma = max(ma,height[i])
                mi = i
        
        lw = 0
        for i in range(mi+1):
            if height[lw] > height[i]:
                res += height[lw]-height[i]
            else:
                lw = i
        
        rw = len(height)-1
        for i in range(len(height)-1,mi-1,-1):
            if height[rw] > height[i]:
                res += height[rw]-height[i]
            else:
                rw = i
        
        return res




class Solution:
    def trap(self, height: List[int]) -> int:
        res = 0
        
        if len(height) <= 1:
            return res
        
        ma = 0
        for i in range(len(height)):
            if ma <= height[i]:
                ma = max(ma,height[i])
                mi = i
        
        lw = 0
        l = 0
        
        print(mi)
        
        while l <= mi :
            print(lw,l)
            if height[lw] <= height[l]:
                lw = l
                l += 1
            elif height[lw] > height[l]:
                res += (height[lw]-height[l])
                l += 1
        
        rw, r = len(height) - 1, len(height) - 1
        
        while r >= mi:
            if height[rw] <= height[r]:
                rw = r
                r -= 1
            elif height[rw] > height[r]:
                res += (height[rw]-height[r])
                r -= 1
        
        return res