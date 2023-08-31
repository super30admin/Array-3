#Space:O(n)
#Time:O(n)
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height)<3:
            return 0
        pref_max = [height[0]]
        suff_max = [height[-1]]
        for i in range(1,len(height)):
            pref_max.append(max(pref_max[-1], height[i]))
        for j in range(len(height)-2,-1,-1):
            suff_max.append(max(suff_max[-1], height[j]))
        suff_max.reverse()
        print(pref_max, suff_max)
        water = 0
        for i in range(len(height)):
            water+=min(pref_max[i], suff_max[i])-height[i]
        return water