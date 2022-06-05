
// Time Complexity : O(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
	// 1) lw is height of left wall
	// 2) l is left pinter
	// 3) rw is height of right wall
	// 4) r is right pointe
	// 5) Assuming right of left wall , there will be some bigger right wall, where we can trap the water
	// 	a. RW (height of r) > LW (height of l) -> then we can trap the water
	// 6) We have wall on right side, we will handle separately.


public int Trap(int[] height) {
     
    if(height == null || height.Length == 0)
        return 0;
    
    int result = 0;
    int lw = 0, rw = 0;
    int l = 0, r = height.Length - 1;
    
    while(l <= r)
    {
        if(lw <= rw)
        {
            if(lw >= height[l])
                result += lw - height[l];
            else
                lw = height[l];
            l++;
        }
        else
        {
            if(rw >= height[r])
                result += rw - height[r];
            else
                rw = height[r];
            r--;
        }
    }
    
    return result;
}