// Time Complexity : O(n) n no.of elements in the height array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

Its a two pointer solution with 2more pointers that represent the height of left buiding and height of right building
until both left and right cross each other check if we are forming a water trap with l/lw and r/rw.
if yes add the difference between them into result


class Solution {
    public int trap(int[] height) {
        int l=0,lw=0,r=height.length-1,rw=0,result=0;
        while(l<=r){
            if(lw<=rw){
                if(lw<height[l]){
                    lw=height[l];
                }
                else{
                    result+=lw-height[l];
                }
                l++;
            }
            else{
                if(rw<height[r]){
                    rw = height[r];
                }
                else{
                    result+=rw-height[r];
                }
                r--;
            }
        }
        return result;
    }
}