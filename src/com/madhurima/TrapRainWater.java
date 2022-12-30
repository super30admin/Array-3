//Time complexity: O(n)
//Space Complexity: O(1)
//Did the code run successfully in LeetCode = yes

package com.madhurima;

public class TrapRainWater {
}

class TrapRainWaterSolution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int n = height.length;
        int lw = 0, rw = 0;
        int l = 0, r = n-1;
        int result = 0;

        while(l <= r){
            if(lw <= rw){
                if(height[l] < lw){
                    result = result + (lw - height[l]); //can trap water
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                if(height[r] < rw){
                    result = result + (rw - height[r]); //can trap water
                }else{
                    rw = height[r];
                }
                r--;
            }
        }

        return result;

    }
}
