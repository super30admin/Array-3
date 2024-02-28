// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yess
// Three line explanation of solution in plain english:Two-pointer Approach

// Your code here along with comments explaining your approach: Two-pointer Approach

class Solution {
    public int trap(int[] height) {
        int leftmax=0;
        int rightmax=0;
        int n= height.length;
        int l=0;
        int r=n-1;

        int trappedWater=0;

        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>leftmax){
                    leftmax=height[l];
                }
                else{
                    trappedWater+=leftmax-height[l];
                }
               l++; 
            }
            else{
                if(height[r]>rightmax){
                    rightmax=height[r];
                }
                else{
                    trappedWater+=rightmax-height[r];
                }
                r--;
            }
        }
        return trappedWater;
    }
}