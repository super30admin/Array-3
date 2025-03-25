# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class PrefixArraySolution:
    def trap(self, height: List[int]) -> int:
        maxLs, maxRs = [], []

        cur_max = 0
        for h in height:
            maxLs.append(cur_max)
            cur_max = max(cur_max, h)
        
        cur_max = 0
        for h in height[::-1]:
            maxRs.append(cur_max)
            cur_max = max(cur_max, h)
        
        maxRs = maxRs[::-1]

        water = 0
        for i in range(len(height)):
            collected_here = min(maxLs[i], maxRs[i]) - height[i]
            if collected_here >= 0:
                water += collected_here
        
        return water

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
class TwoPassSolution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        max_ix = 0
        max_h = 0
        
        for i,h in enumerate(height):
            if h >= max_h:
                max_h = h
                max_ix = i
        
        max_left = 0
        water_collected = 0

        for i in range(max_ix+1):
            if height[i] >= max_left:
                max_left = height[i]
                continue
            water_collected += max_left - height[i]
        
        max_right = 0
        for i in range(n-1, max_ix-1, -1):
            if height[i] >= max_right:
                max_right = height[i]
                continue
            water_collected += max_right - height[i]

        return water_collected

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class SinglePassSolution:
    def trap(self, height: List[int]) -> int:
        l,r = 0,len(height)-1
        lw,rw = 0, 0

        water_collected = 0
        while l < r:
            # update lw,rw
            lw = max(lw, height[l])
            rw = max(rw, height[r])

            if lw <= rw:
                # process l
                water = min(lw,rw) - height[l]
                if water > 0:
                    water_collected += water
                l += 1
            else:
                # process r
                water = min(lw,rw) - height[r]
                if water > 0:
                    water_collected += water
                r -= 1

        return water_collected 