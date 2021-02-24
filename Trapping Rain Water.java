// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes	
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] height) {
        //edge 
        if(height == null || height.length < 2) return 0;
        //set pointers and res
        int res = 0;
        int n = height.length;
        int leftw = 0;
        int rightw = 0;
        int l = 0; 
        int r = n-1;
        //start a while loop to go through the buidings
        while(l <= r){
            //see which side we have to operator on
            if(leftw <= rightw){
                //then process left side
                if(height[l] < leftw){
                    //height is less then left wall so we can trap
                    res += leftw - height[l];
                }
                else{
                    //move the pointer over
                    leftw = height[l];
                }
                l++;
            }
            //process right sise
            else{
                if(height[r] < rightw){
                    res += rightw - height[r];
                }
                else{
                    rightw = height[r];
                }
                r--;
            }
        }
        return res;
    }
}