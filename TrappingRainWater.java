//Time Complexity: O(n)
//Space Complexity: O(1)

/*
 * we move two pointers left and right and maintain a wall for 
 * their water level. Wall is the highest value on both sides.
 * while processing the water quantity when we get wall greater than
 * current we calculate the water level and add it to the volume.
 */


class Solution {
    public int trap(int[] height) {
        int lw = 0; int rw = 0;
        int l = 0; int r = height.length -1;
        int volume = 0;
        while(l <= r){
            //process left
            if(lw <= rw){
                if(lw <= height[l]){
                    lw = height[l];
                }
                else{
                    volume += (lw - height[l]);
                }
                l++;
            }
            //process right
            else{
                if(rw <= height[r]){
                    rw = height[r];
                }
                else{
                    volume += (rw - height[r]);
                }
                r--;
            }
        }
        return volume;
    }
}