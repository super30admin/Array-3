## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

//Approach : In this problem we are kepping 4 variables left, right, leftwall, rightwall
// We are moving pointers from left and right;
//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution {
    public int trap(int[] height) {
        //base case
        if(height == null || height.length==0){
            return 0;
        }
        //Variable Declarations
        int left=0;
        int right=height.length-1;
        int lw=0;
        int rw=0;
        int total=0;
        while(left<=right){
            if(lw<=rw){
                if(height[left] < lw){
                    total=total + (lw-height[left]);
                }
                else{
                    lw=height[left];
                }
                left++;
            }
            else{
                if(height[right] < rw){
                    total=total + (rw-height[right]);
                }
                else{
                    rw=height[right];
                }
                right--;
            }
        }
        return total;
    }
}