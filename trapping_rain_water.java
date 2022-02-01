class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length; // integer variable n stores the length of the the integer array height
        int result = 0; //result array stores the units of water that can be stored
        int lw = 0, rw = 0; //we take two variables lw,rw initialized to 0, and these are considered to be as walls for capturing the water
        int l = 0, r = n -1; //we take 2 variables l and r initialized to 0 and n -1 (last index in the integer array)
        while(l <= r) { //we are checking if the l index is less than or equal to r index
            if(lw <= rw) { //if the lw is less than or equal to the rw, we are moving towards the right
                if(lw > height[l]) { //if the lw is greater than the height of l
                    result = result + lw - height[l]; // we are caputring the water in the result.
                }
                else { // if lw is less than or equal to l
                    lw = height[l]; //we update lw to the height of the index l
                }
                l++; //in both the cases, we increment l;
            }
            else { //if lw(leftwall) is greater than rw(rightwall) // we are moving the smaller one, which is towards the left
                if(rw > height[r]) { //if the right wall is greater than the height of l
                    result = result + rw - height[r]; //we capture the height of the water in the result variable
                }
                else { // if rw is less than or equal to the height of r
                    rw = height[r]; //we update the value of rw to the height of index r
                }
                r--; //in both cases, we move towards the left
            }
        }
        return result; //in the end, we return the result
    }
}
//tc and sc - O(n) and O(1)