/*
building can store water only if its hieght is less than leftMax and rightMax
and amount of water it can store will be minimum of leftMax and rightMax minus its own height. 
otherwise water will be spilled. 


Brute force Approach: 
For each element in the array, I would find the maximum level of water it can trap after the rain, which is equal to the minimum of maximum height of bars on both the sides minus its own height.
Time complexity: O(n^2) For each element of array, I would be iterating over the left and right parts.
Space complexity: O(1) extra space.
*/
class Solution {
    public int trap(int[] height) {
        //edge case
        if(height == null || height.length ==0)
            return 0;
       // return trapWaterUtil(height);
        return trapWaterTwoPointer(height);
    }
    /*
    Better brute force:
    Instead of iterating over the left and right parts again and again just to find the highest building upto that index, i can iterate over and can store leftmax and rightmax at each index in 2 arrays and then can use these values to calculate total water.
    1. calculate leftmax at each index starting from 0th index in the 1st pass and store in the one array
    2. calculate rightmax at each index starting from last index in the 2nd pass and store in the another array
    3. in 3rd pass get the leftmax and rightmax at each index from these array and substract building height at that index from min of ( leftmax and rightmax ) and calculate total water it can trap
    Time complexity: O(3n) = O(n) doing 3 pass..
    Space complexity: O(2n) = O(n) extra space for storing leftmax and rightmax at each index
    */
    private int trapWaterUtil(int[] height){
        int totalWater = 0;
        int len = height.length;
        
        //calculate and store leftmax at each index
        int [] leftmax = new int[len];
        int leftMax =Integer.MIN_VALUE;
        for(int i=0; i< len ; i++){
            if(leftMax < height[i])
                leftMax = height[i];
            leftmax[i] = leftMax;
        }
        //calculate right max at each index
        int [] rightmax = new int[len];
        int rightMax =Integer.MIN_VALUE;
        for(int i=len-1; i>=0; i--){
            if(rightMax < height[i])
                rightMax = height[i];
            rightmax[i] = rightMax;
        }
        
        for(int i=0; i< len ; i++){
            totalWater += Math.min(leftmax[i], rightmax[i]) - height[i];
        }
        
        return totalWater;
    }
/*Two Pointers approach
1. Instead of computing the left and right max seperately, I can do it in one iteration.
2. If there is a larger bar at right end, then the water trapped would be dependant on height of left bar 
3. As soon as I find the bar at right end is smaller, I would be iterating in opposite direction from right to left. 
4. I would  maintain leftmax and rightmax during the iteration, but now I would be doing it in one iteration using 2 pointers, switching between the two.
Time complexity:  O(n) 
Space complexity: O(1)
*/
    
    private int trapWaterTwoPointer(int[] height){
        int left =0, right = height.length-1;
        int leftMax =0, rightMax =0; 
        int totalWater =0; //to calculate total water we can trap
        
        while(left< right){
            if(height[left] <= height[right]){
                if(leftMax >height[left])
                    totalWater += leftMax- height[left];
                else
                    leftMax = height[left];
                left++;
            }
            else{
                if(rightMax >height[right])
                    totalWater += rightMax- height[right];
                else
                    rightMax = height[right];
                right--;
            }
        }
        return totalWater;
    }
}

