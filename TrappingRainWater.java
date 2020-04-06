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