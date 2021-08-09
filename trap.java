//Time complexity-O(n)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int trap(int[] height) {
        if(height.length<=2)
            return 0;
        int LW=height[0], RW=height[height.length-1];//left width to check increasing sequence from end and from right
        int L=0, R=height.length-1;
        int  total=0;
        while(L<=R){
            if(LW<RW){//calculate total only for smaller value currently 
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