// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * This approach is by using 4 pointers lw-> the left wall(initializing to 0 as its height); rw-> the right wall(initializing to 0 as its height);
 * l-> left index and r-> right index
 * when the value of lw is lesser than or equal to the rw the process the left side as there will be a possibility to hold the rain water towards the right wall;
 * else process from the right side. when the height of left/right is greater than the left/right wall respectively then make the new left/right wall as the height of left/right.
 */
public class TrappingRainWater {
	public int trap(int[] height) {
        if(height == null || height.length < 2) return 0;
        int result = 0;
        int n = height.length;
        int lw = 0; int rw = 0;
        int l = 0;
        int r = n-1;
        while(l <= r){
            if(lw <= rw){
                //process left side
                if(height[l] < lw){
                    result += lw - height[l];
                } else{
                    lw = height[l];
                }
                l++;
            }
            else{
                //process right side
                if(height[r] < rw){
                    result += rw - height[r];
                } else{
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}
