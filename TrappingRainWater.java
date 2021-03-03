// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class TrappingRainWater {


    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if(n < 3) return 0;//base case if less than 3 elements return 0 as at minimum 3 element is required to trap water

            //using dp approach, top down
            int[] left = new int[n];//left array for memoization
            for (int i = 0; i < n; i++) {
                left[i] = i == 0 ? height[i] : Math.max(left[i-1], height[i]);//find max value for element
            }

            int[] right = new int[n];//right array for memoization
            for (int i = n-1; i >= 0; i--) {
                right[i] = i == n-1 ? height[i] : Math.max(right[i+1], height[i]);//find max value for element
            }

            //calculate result
            int result = 0;
            for (int i = 0; i < n; i++) {
                result += Math.min(right[i], left[i]) - height[i];
            }
            return result;
        }
    }


}
