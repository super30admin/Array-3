"""
The approach here is to iterate through the array and find the max building height towards the left
and right of the current building, then find the min amoung both since that would be the one where the
water would collect, i.e it will collect till that point, now deduct it with the height of current index
to get the total trapped water.
Leetcode - TLE
Time complexity - O(N^2)
Space complexity - O(1)
"""
def trap(self, height):
    ans = 0
    for i in range(len(height)):
        max_left = 0
        max_right = 0
        
        for j in range(i,-1,-1):
            max_left = max(max_left,height[j])
            print max_left
        for j in range(i,len(height)):
            max_right = max(max_right,height[j])
            #print max_right
        ans += min(max_left,max_right) - height[i]
    return ans