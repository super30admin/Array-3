//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

class Trapping_Rain_Water_42 {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int count = 0;
        int l = 0, r = height.length-1;
        int lw = height[l], rw = height[r];
        while(l <= r)
        { 
            if(rw > lw)
            {
                if(height[l] < lw)
                    count += lw - height[l];
                else
                    lw = height[l]; 
                l++;
            }
            else
            {
                if(height[r] < rw)
                        count += rw - height[r];
                else
                    rw = height[r]; 
                r--;
            }
        }
        return count;
    }
    
    public static void main(String[] args)
    {
    	int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
    	Trapping_Rain_Water_42 tr = new Trapping_Rain_Water_42();
    	System.out.println(tr.trap(arr));
    }
}
