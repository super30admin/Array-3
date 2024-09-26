// Time Complexity : O(N) iterating several times but only one at a time.
// Space Complexity : O(N) extra arrays for calculating max and min heights.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Store the left max for each in an array.
//Store the right max for each in an array.
//Find min of leftMax, rightMax and substract from the current height
//calculate sum

class Solution {
    public int trap(int[] height) {
        //base check
        if(height == null || height.length == 0) return 0;
        
        int n = height.length;
        int totalTrapped = 0; //ans
        
        //arrays to store max height for left and right
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        
        //fill the max height for left side
        maxLeft[0] = 0;
        for(int i=1; i<n; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        
        //fill the max height for right side
        maxRight[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        
        //calculate the rain water trapped
        for(int i=0; i<n; i++){
            int currentWater = Math.min(maxLeft[i], maxRight[i]) - height[i];
            
            /////////Key Point in this problem///////////
            if(currentWater <0){
                currentWater = 0;
            }
            
            totalTrapped += currentWater;
        }
        
        return totalTrapped;
    }
}