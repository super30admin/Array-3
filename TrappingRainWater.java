/*
 ====================BRUTEFORCE =========================

Time: O(N)
Space: O(1)
Approach:
========
1. Use 2-pointer technique to keep track of left and right pointers.
2. Keep track of maxLeft and maxRight by comparing with current left and right values respectively.
3. Uses basic idea that of left and right, whichever is small would be the max size of container that can
trap rain water.  
*/
class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0; 
        int totalWater = 0, n = height.length; 
        // For every index, get left max and right max on the fly and calculate trapped water
        for(int i = 0; i < n; i++) {
            leftMax = 0; 
            rightMax = 0; 
            for(int j = i; j >= 0; j--)
                leftMax = Math.max(leftMax, height[j]); 
            for(int j = i; j < n; j++)
                rightMax = Math.max(rightMax, height[j]); 
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }
        return totalWater;
    }
}

/*
======================= Approach-2 ============================
Time:O(N) space: O(N)
Approach:
=========
1. Use left and right arrays to store leftmax and rightmax at every index
2. Now, use these array values at every index to calculate trapped rain water
*/
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0; 
        int n = height.length; 
        int[] left = new int[n];
        int[] right = new int[n]; 
        int leftMax = 0, rightMax = 0, totalWater = 0; 
        
        //calculate left max for each index
        for(int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]); 
            left[i] = leftMax; 
        }
        
        //calculate right max for each index
        for(int i = n-1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]); 
            right[i] = rightMax; 
        }
        
        // calculate total trapped water 
        for(int i = 0; i < n; i++)
            totalWater += Math.max(0, Math.min(left[i], right[i]) - height[i]); 
        
        return totalWater;
    }
}
/*
Time: O(N)
Space: O(1)
Approach:
========
1. Use 2-pointer technique to keep track of left and right pointers.
2. Keep track of maxLeft and maxRight by comparing with current left and right values respectively.
3. Uses basic idea that of left and right, whichever is small would be the max size of container that can
trap rain water.  
*/
class Solution {
    public int trap(int[] nums) {
        int n = nums.length,res = 0; 
        int right = n-1,left = 0;
        int maxLeft = 0, maxRight = 0;
        
        // check for pointers intersecting
        while(left <= right) {
            // if left value less than right, check if current left is greater than maxLeft.
            //If so, update maxLeft, if not, update result by adding maxLeft - nums[left](that would be water)
            if(nums[left] <= nums[right]) {
                if(nums[left] >= maxLeft) maxLeft = nums[left];
                else res += maxLeft-nums[left];
                left++;
            }
             // if right value less than left, check if current right is greater than maxRight.
            //If so, update maxRight, if not, update result by adding maxRight - nums[right](that would be water)
            else {
                if(nums[right] >= maxRight) maxRight = nums[right];
                else res += maxRight-nums[right];
                right--;
            }
        }
        return res;
    }
}