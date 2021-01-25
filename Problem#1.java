// Problem# S30 118 ##LC 42
// Traping rain water

class Solution {
    public int trap(int[] height) {
        
        if(height == null || height.length == 0) {
            return 0;
        }
        
        int result = 0;
        int n = height.length;
        int l = 0, r = n - 1;
        int l_max = 0, r_max = 0;
        
        while(l <= r) {
            if(height[l] < height[r]) {
                if(height[l] >= l_max) {
                    l_max = height[l];
                }
                else {
                    result += l_max - height[l];
                }
                l++;
            }
            else {
                if(height[r] >= r_max) {
                    r_max = height [r];
                }
                else {
                    result += r_max - height[r];
                }
                r--;
            }
        }
        
        return result;
        
    }
}

/*

Complexity Analysis
Time complexity: O(n). 
Space complexity: O(1) extra space. 
*/