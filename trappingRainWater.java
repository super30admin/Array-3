/* Time complexity: O(n)
space complexity: O(1)
*/

class Solution{
    public int trap(int[] height){
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int l = 0; int r = n-1; int result = 0; int lw = 0; int rw = 0;
        while(l <= r){
            if(lw <= rw){
                if(height[l] > lw){
                    lw = height[l];                    
                }
                else{
                    result += (lw - height[l]);
                }
                l++;
            }
            else{
                if(height[r] > rw){
                    rw = height[r];
                }
                else{
                    result += (rw - height[r]);
                }
                r--;
            }
        }
        return result;
    }
}