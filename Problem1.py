#Time complexity: O(n)
#Space complexity: O(1)
#Works on leetcode: yes
#Approach: The idea here is that water will be stored above any building would depenf upon largest height of building to it's left
# and also the largest height of building to it's right. You take the minimum of it as only till that height the water would accumulate
# Now just subtract of height of the building you are currently at so you get the heeight of water above it.

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height or len(height)<3:
            return 0
        vol = 0
        l,r = 0, len(height)-1
        lmax, rmax = height[l], height[r]
        while l<=r:
            lmax, rmax = max(lmax, height[l]), max(rmax, height[r])
            if lmax<=rmax:
                vol += lmax - height[l]
                l +=1
            else:
                vol += rmax - height[r]
                r -=1
        return vol