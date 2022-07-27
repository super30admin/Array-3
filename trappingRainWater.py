# TC: O(N)
# SC: O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0: return 0
        
        l, h = 0, len(height) - 1
        
        l_max, r_max = height[l], height[h]
        ans = 0
        
        while l < h:
            if l_max < r_max:
                # we can move this forward before checking value at idx0 cause we can't really trap any water there
                l += 1
                # ensure current index doesn't give us the better max than previous
                l_max = max(l_max, height[l])
                ans += l_max - height[l]
            else:
                # we can move this backward before checking value at idx -1 cause we can't really trap any water there
                h -= 1
                r_max = max(r_max, height[h])
                ans += r_max - height[h]
        return ans