// TC : O(n)
// SC : O(1)
// Method : Four pointers

class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        
        if(n == 0 || height == null) return 0;
        
        int l = 0, r = n - 1, lw = 0, rw = 0, result = 0;
        
        while(l <= r) {
            
            if(lw <= rw) {
                if(lw > height[l]) {
                    result += lw - height[l];
                }
                else
                    lw = height[l];
                l++;
            }
            else {
                if(rw > height[r]) {
                    result += rw - height[r];
                }
                else
                    rw = height[r];
                r--;
            }
            
        }
        return result;
    }
}
