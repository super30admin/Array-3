class Solution:
    def trap(self, height: List[int]) -> int:
        left_max=[]
        # right_max=[]
        left=float('-inf')
        right=float('-inf')
        area=0
        for i in range(len(height)):
            if height[i]>=left:
                left=height[i]
            left_max.append(left)
            
        for i in range(len(height)-1,-1,-1):
            if height[i]>=right:
                right=height[i]
            print(right)
            area+=min(left_max[i],right)-height[i]
        print(left_max)
        # print(right_max)
        # for i in range(len(height)):
        #     area+=min(left_max[i],right_max[i]) - height[i]
            
        return area
            
            
        
            
            
        