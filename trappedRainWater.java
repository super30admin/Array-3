Did this code ran on leetcode: yes
Approach : we can say that if there is a larger bar at one end (say right), we are assured that the water trapped would be dependant 
on height of bar in current direction (from left to right). As soon as we find the bar at other end (right) is smaller, 
we start iterating in opposite direction (from right to left).

Time Complexity : O(n)
Space Complexity : O(1)

class Solution {
    public int trap(int[] height) {
        if(height.length == 0 || height == null) return 0;
       int n = height.length;
        int l = 0;
        int r = n-1;
        int lw = 0;
        int rw = 0;
        int result = 0;
        while (l<=r)
        {
            if(lw < rw)
            {
                if(lw > height[l])
                {
                    result += lw - height[l];
                }
                else
                {
                    lw = height[l];
                }
                l++;
            }
            else
            {
                 if(rw > height[r])
                {
                    result += rw - height[r];
                }
                else
                {
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}