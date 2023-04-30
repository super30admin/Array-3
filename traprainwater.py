class Solution:
    # Find max left and max right of each entry and current height - the min of both of them gives the water that will be trapped in that building
    #TC-O(N),SC-O(N)
    def trap(self, height: List[int]) -> int:
        left =[0]
        right = [0]
        for i in range(1,len(height)):
            left.append(max(left[-1],height[i-1]))
        for j in range(len(height)-2,-1,-1):
            right.append(max(right[-1],height[j+1]))
        right.reverse()
        su = []
        for i in range(len(height)):
            m = min(left[i],right[i])
            if m > height[i]:
                su.append(m-height[i])
        return sum(su)


        