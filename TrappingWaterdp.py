def trap(self, height):
    if not height:
        return 0
    ans = 0
    size = len(height)
    max_left = [None]* size
    max_left[0] = height[0]

    max_right = [None]* size
    max_right[size-1] = height[size-1]
    
    for j in range(1,size):
        max_left[j] = max(max_left[j-1],height[j])
        
    for x in range(size-2,-1,-1):
        max_right[x] = max(max_right[x+1],height[x])
    
    
    for i in range(len(height)):
        
        ans += min(max_left[i],max_right[i]) - height[i]
    return ans