class Solution:
    def trap(self, height: List[int]) -> int:
        
        min_of_l_r = [-1]*len(height)
        l = -1
        for i in range(len(height)-1):
            min_of_l_r[i+1] = max(l, height[i])
            l = max(l, height[i])
        
        r = -1
        for i in range(len(height)-1, -1, -1):
            min_of_l_r[i] = min(min_of_l_r[i], r)
            r = max(r, height[i])
        
        #print(min_of_l_r)
        res = 0
        for i in range(len(height)):
            res += min_of_l_r[i] - height[i] if min_of_l_r[i]>0 and height[i] < min_of_l_r[i] else 0
        return res
