// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Four Pointers, if the left pointer cross the right right pointer till then, check if the leftWall is less or equal then right, whoever is small will be processed first, in the side check if the wall is grater then the hight of pointer, then add the difference to the result, if not set the wall the hight of that pointer. return the result.
// Your code here along with comments explaining your approach
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int lw = 0; int rw = 0;
        int l = 0; int r = height.length-1;
        int result = 0;
        while(l <= r){
            if(lw <= rw){
                // left side
                if(height[l] < lw){
                    result += lw - height[l];
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                // right side
                if(height[r] < rw){
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