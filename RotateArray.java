// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class RotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {
            int arrLength =  nums.length;
            int[] copy = new int[arrLength];

            //rotate array
            for (int i = 0; i < arrLength; i++) {
                copy[(i+k) % arrLength] = nums[i];
            }

            //copy valus back to nums array
            for (int i = 0; i < arrLength; i++) {
                nums[i] = copy[i];
            }
        }
    }
}
