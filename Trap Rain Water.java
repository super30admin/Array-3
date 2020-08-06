// Time Complexity : O(n^2) 
// Space Complexity : O(1)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return n;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }
}

// Time Complexity : O(n) 
// Space Complexity : O(1)

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int l = 0; int r =n-1;
        int lw = 0; int rw =0;
        int result = 0;
        while(l<=r){
            if(rw>lw){
                if(lw>height[l]){
                    result += lw - height[l];
                }else{
                    lw = height[l];
                }
                l++;
            }
            else{
                if(rw>height[r]){
                    result += rw - height[r];
                }else{
                    rw = height[r];
                }
                r--;
            }
        }

        return result;
    }
} 
