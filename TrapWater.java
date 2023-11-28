// Time Complexity : O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class TrapWater {
    public int trap(int[] height) {
     int result = 0;
      
     int lw=0;
     int lp=0;
     int rw = 0;
     int rp = height.length-1;
     while(lp<=rp){
         if(lw <= rw){
             //process left
             if(lw < height[lp]){
                 lw = height[lp];
             }
             else{
                 result+= (lw-height[lp]);
             }
             lp++;
         }
         else{
             if(rw < height[rp]){
                 rw = height[rp];
             }
             else{
                 result += (rw - height[rp]);
             }
             rp--;
         }
         
     }
     return result;
    }
}