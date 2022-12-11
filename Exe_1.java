class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;

        int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;

        int ans = 0;

        while(l <= r){
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);

            if(lMax < rMax){
                ans += lMax - height[l];
                ++l;
            } else {
                ans += rMax - height[r];
                --r;
            }
        }
        return ans;
    }
}

//tc= O(n)
//sc= O(1)
