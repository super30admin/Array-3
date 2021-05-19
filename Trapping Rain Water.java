//Time Complexity : O(N)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }
        //maintain two pointers
        int left=0,right=height.length-1;
        //keep track of maximum height at both ends
        int lMax=0,rMax=0,result=0;
        while(left<right){
            //LEFT
            //move the pointer with smaller height
            if(height[left]<=height[right]){
                //update the new lMax if the current height is greater than the previous largest height in the left side
                if(lMax <= height[left]){
                    lMax = height[left];
                }
                //otherwise we have found a height less than previous lMax so the water can be stores at the current pointer
                else{
                    //update the result
                    result += lMax - height[left];
                }
                left++;
            }
            
            //RIGHT
            //move the pointer with smaller height
            else{
                //update the new rMax if the current height is greater than the previous largest height in the right side
                if(rMax <= height[right]){
                    rMax = height[right];
                }
                //otherwise we have found a height less than previous rMax so the water can be stores at the current pointer
                else{
                    result += rMax - height[right];
                }
                right--;
            }
        }
        return result;
    }
}