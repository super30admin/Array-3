class Solution:
    def trap(self, height: List[int]) -> int:
        max_left = [0]*len(height)
        max_right = [0]*len(height)

        maxl= height[0]
        maxr = height[-1]

        result = 0

        for i in range(len(height)):
            max_left[i]=maxl
            maxl = max(maxl,height[i])

        for j in range((len(height)-1),-1,-1):
            max_right[j] = maxr
            maxr = max(maxr,height[j])

        for i in range(len(height)):
            if (min(max_left[i], max_right[i]) - height[i])>0:
                result += (min(max_left[i], max_right[i]) - height[i])


        return result