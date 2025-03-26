//In this approach, we take two pointers at each end and two walls at each end and whichever wall is higher, we process the opposite end one and trap that water, because we have a guarantee that there is a higher wall down the road.
//When processing smaller wall, we see if the height of the pointer at that is less than the wall, only then we capture that water, if not, we make the wall as the current pointer height
//Time Complexity: O(n);
//Space Complexity: O(1);
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int result = 0;
        int lw = 0;
        int l = 0;
        int rw = 0;
        int r = n - 1;
        while(l <= r){
            if(lw <= rw){
                //process left side
                if(lw > height[l]){
                    result += (lw - height[l]) * 1; //width 1
                } else {
                    lw = height[l];
                }
                l++;
            } else{
                //process right side
                if(rw > height[r]){
                    result += (rw-height[r]) * 1; //width 1
                } else {
                    rw = height[r];
                }
                r--;
            }
            
        }
        return result;
    }
}