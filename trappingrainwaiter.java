// Time Complexity: O(n)
// Space Complexity: O(1)
public class TrappingRainWater {
    public int trap(int[] height)
    {
        int max = 0;
        if(height == null || height.length == 0)
         return 0;

        int l = 0 , lw = 0, r = height.length-1, rw = 0;

        while(l <= r)
        {
            if(lw <= rw) // start with two walls
            {
                if(lw >= height[l]) // capture water if there is a wall on left to block
                {
                    max +=  (lw - height[l]) * 1;
                }
                else
                {
                    lw = height[l];
                }
                l++;
            }
            else // right wall is samller than left wall
            {
                if(rw >= height[r]) // capture water if there is a wall on right to block
                {
                    max += (rw - height[r])* 1;
                }
                else
                {
                    rw = height[r];
                }
                r--;
            }
        }
        return max;
    }
}