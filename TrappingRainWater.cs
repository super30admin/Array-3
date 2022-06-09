using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class TrappingRainWater
    {
        /*
         * T.C: O(n) where n is number of heights in array
         * S.C: O(1) no extra sapce used
         */
        public int Trap(int[] height)
        {
            if (height == null || height.Length == 0) return 0;

            int lw = 0, rw = 0;
            int l = 0, r = height.Length - 1;
            int result = 0;

            while (l <= r)
            {
                if (lw <= rw)
                {
                    if (lw > height[l])
                    {
                        result = result + lw - height[l];
                    }
                    else
                    {
                        lw = height[l];
                    }
                    l++;
                }
                else
                {
                    if (rw > height[r])
                    {
                        result = result + rw - height[r];
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
}
