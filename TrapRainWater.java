// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class TrapRainWater {
    class Solution {
        public int trap(int[] height) {
            //2 pass: find max -> middle wall, accumulate sum from both sides
            int n = height.length;
            if(n == 0)
                return 0;
            int lp = 0, rp = n-1;
            int lw = 0, rw = 0;
            int result = 0;

            while(lp <= rp){
                if(height[lp] > lw)
                    lw = height[lp];

                if(height[rp] > rw)
                    rw = height[rp];

                if(lw <= rw){
                    result += lw - height[lp];
                    lp++;
                }
                else{
                    result += rw -height[rp];
                    rp--;
                }
            }
            return result;
        }
    }
}
