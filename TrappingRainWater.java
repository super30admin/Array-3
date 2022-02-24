package array3;

public class TrappingRainWater {
	//Time Complexity : O(n), where n is length of height array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int trap(int[] height) {
        int amount = 0;
        int l = 0, r = height.length - 1;
        int lw = 0, rw = 0;
        
        while(l <= r) {
            if(lw <= rw) {
                if(height[l] < lw)
                    amount += lw - height[l];
                else
                    lw = height[l];
                l++;
            } else {
                if(height[r] < rw)
                    amount += rw - height[r];
                else
                    rw = height[r];
                r--;
            }
        }
        
        return amount;
    }
}
