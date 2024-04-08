class Solution {
    public int trap(int[] h) {
        // return helperOptimized(h);
        return helper(h);
    }

    // Sc: O(1)
    // Tc: O(n)
    private int helperOptimized(int[] h) {
        int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
        while (l < r) {
        lmax = Math.max(lmax, h[l]);
        rmax = Math.max(rmax, h[r]);
        ans += (lmax < rmax) ? lmax - h[l++] : rmax - h[r--];
        }
        return ans;
    }

    // Sc: O(n)
    // Tc: O(n)
     public int helper(int[] height) {

        if(height.length <= 2){
            return 0;
        }

        int n = height.length;
        int leftboundary[] = new int[n];
        int rightboundary[] = new int[n];
        // leftboundary making
        leftboundary[0] = height[0];
        for(int i = 1;i<n;i++){
            leftboundary[i] = Integer.max(leftboundary[i-1],height[i]);
        }
        // right boundary making
        rightboundary[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--){
            rightboundary[i] = Integer.max(rightboundary[i+1],height[i]);
        }
        int sum = 0;
        for(int i = 0;i<n;i++){
            int waterlevel = Integer.min(leftboundary[i],rightboundary[i]);
            sum += waterlevel-height[i];
        }
        return sum; 
    }
}