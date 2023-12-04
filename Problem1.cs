public class TrappingRainWater
	{
        // Time Complexity : O(n)
        // Space Complexity : O(1) - in place
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public int Trap(int[] height)
        {
            int n = height.Length;
            int result = 0;
            int lw = 0;
            int lp = 0;
            int rw = 0;
            int rp = n-1;

            while(lp <= rp)
            {
                if(lw < rw)
                {
                    //process left side
                    if(lw < height[lp])
                    {
                        lw = height[lp];
                    }
                    else
                    {
                        result = result + (lw - height[lp]);
                    }
                    lp++;
                }
                else
                {
                    //process right side
                    if (rw < height[rp])
                    {
                        rw = height[rp];
                    }
                    else
                    {
                        result = result + (rw - height[rp]);
                    }
                    rp--;
                }
            }

            return result;
        }
}
