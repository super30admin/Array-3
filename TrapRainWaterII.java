// Time complexity = O(n)
// Space complexity = O(1)
class Solution {
    public int trap(int[] height) {
        int result =0;
        int l=0;
        int r= height.length-1;
        int lw =0;
        int rw= height.length-1;
        while(l<= r) {
            if(height[lw] <= height[rw]) {
                // process left side first.
                // rw acts as the barrier.
                if(height[lw]> height[l]) {
                    result+= height[lw] - height[l];
                } else {
                    lw =l;
                }
                l++;
                
            } else {
                // process right side first.
                // left side acts as the barrier.
                if(height[rw] > height[r]) {
                    result+= height[rw]- height[r];
                } else {
                    rw=r;
                }
                r--;
            }
        }
        return result;
    
    }
}