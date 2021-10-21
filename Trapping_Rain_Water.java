// Time Complexity : O(n), We traverse once through the array(from left and right until left>=right)
// Space Complexity : O(1), No extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] h) {
        int l = 0;
        int lw = 0;
        int n = h.length;
        int r = n-1;
        int rw = 0;
        int result = 0;
//Checking there is a rigth wall larger than left wall so that rainwater can be trapped  
        while(l<=r){
            if(lw<=rw){
                if(h[l] < lw){
                    result+=lw-h[l];
                }
                else{
                    lw = h[l];
                }
                l++;
//Vice-versa
            }
            else{
               if(h[r]<rw){
                   result+= rw - h[r];
               }
               else{
                   rw = h[r];
               }
               r--;
            }
            
        }
        return result;
    }
}