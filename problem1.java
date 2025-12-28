// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Appraoch 
Fist we find the maximum height building 
then we start a loop from 0 till index of max height building
we mainitain the height counter if we find a building with greater height
we swtich or else if the height is smaller we take the difference and add it to result

when the loop from 0 till height is done we start another loop from end still max height index doing the
same thing and in the end return result 
*/

class Solution {
    public int trap(int[] height) {
        int maxIdx = 0;
        int maxHeight = 0;
        int result = 0;
        // finding the max height building
        for (int i = 0; i < height.length; i++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
                maxIdx = i;
            }
        }
        int l = 0; // idx
        int lw = 0; // Height

        while (l < maxIdx) {
            if (lw < height[l]) {
                lw = height[l]; // no water trapped as left wall was smaller then cur wall
            } else {
                result += lw - height[l];
            }
            l++;
        }

        int r = height.length - 1;
        int rw = 0;

        while (r > maxIdx) {
            if (rw < height[r]) {
                rw = height[r];
            } else {
                result += rw - height[r];
            }
            r--;
        }
        return result;

    }
}