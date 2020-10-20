// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//we use two pointers from left and right side, maintain left width and right width of the buildings, total to keep track of units
//we end the traversal of the array when left and right pointers cross each other
//when LW<RW, we check if LW<height of building, then we update LW else we update the units as we reach the area to trap water
//we increment L after the if else block
//when LW>RW, we check if RW<height of right building, update RW with current height of building else update the total with current unit
//decrement right pointer after the if else block
//return total after the while block at the end

class Solution {
    public int trap(int[] height) {
        int L=0, LW=0,R=height.length-1, RW=0,total=0;
        
        while(L<=R){
            if(LW<RW){
                if(LW<height[L]){
                    LW=height[L];
                }
                else{
                  total+=LW-height[L];  
                }
                L++;
            }
            
            else{
                if(RW<height[R]){
                    RW=height[R];
                }
                else{
                    total+=RW-height[R];
                }
                R--;
            }
        }
        return total;
    }
}