// TC : O(n)
// SC : O(1)
class Solution {
    public int trap(int[] height) {
        int lw = 0, rw = 0 ;
        int l = 0 , r = height.length -1;
        int result = 0 ;
        while(l <= r)
        {
            if(lw <= rw)
            {
                if(lw <= height[l])
                {
                    lw = height[l];
                }
                else
                {
                    result += 1 * (lw - height[l]);
                }
                l++;
            }
            else
            {
                if(rw <= height[r])
                {
                    rw = height[r];
                }
                else
                {
                    result += 1 * (rw - height[r]);
                }
                r--;
            }
        }

        return result;
    }
}