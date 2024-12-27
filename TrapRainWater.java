// Approach : From brute force approach where you need to have lw and rw in order to trap. 
// Using two pass approach with one pass you can find
// the max height(tallest building) which acts as a rw for all the buildings.
// so now you only need to have a lw and do the comparisons to see if you can tap the water
// Time : O(n) + O(n)
// Space : O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int maxHeight = 0; // height of tallest building
        int maxIdx = 0; // position of tallest building
        // first pass to find the max height to determine as right wall
        // Basically it is the tallest building and it acts as a right wall for all the left buildings
        for(int i =0;i<n;i++){
            if(height[i]>maxHeight){
                maxHeight = height[i];
                maxIdx = i;
            }
        }

        int l = 0;
        int lw = 0;
        int result=0; // trap
        // iterate over all the buildings until you reach the tallest building
        while(l<maxIdx){
            if(lw<height[l]){
                lw = height[l];
                l++;
            }else{
                // if we have a bigger left wall then we can trap water
                result+=lw-height[l];
                l++;
            }
        }
        // once you reach the tallest building from leftmost
        int r = n-1;
        int rw=0;
        // traverse from right to the tallest building
        while(r>maxIdx){
            if(rw<height[r]){
                rw=height[r];
                r--;
            }else{
                // if we have a bigger right wall then we can trap water
                result+=rw-height[r];
                r--;
            }
        }
        return result;
    }
}


// Approach : From brute force approach where you need to have lw and rw in order to trap. 
// with just one pass approach, at each and every building to trap the rain water if we know we have the
// bigger wall at some where in the right than the currrent/left wall then we can trap the water based of left wall and vice versa.
// so we dont need to know the tallest building before hand. so go with two pointers l & r and lw and rw.
// Time : O(n) // one pass logic
// Space : O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0;
        int lw = 0; // left wall

        int r = n - 1; // right wall
        int rw = 0;

        int result = 0; // trap

        while (l <= r) {
            // Before we compute , consider which wall is bigger
            // if lw == rw we can choose to go either the left or right
            if (lw <= rw) {
                // implies we have bigger right wall
                // Hence go to side of the left wall.
                if (lw < height[l]) {
                    lw = height[l];
                    l++;
                } else {
                    // if we have a bigger left wall then we can trap water
                    result += lw - height[l];
                    l++;
                }
            } else {
                // implies we have bigger left wall
                // Hence go to side of the right wall.
                if (rw < height[r]) {
                    rw = height[r];
                    r--;
                } else {
                    // if we have a bigger right wall then we can trap water
                    result += rw - height[r];
                    r--;
                }
            }
        }
        return result;
    }
}