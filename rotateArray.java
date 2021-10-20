// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class rotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length -1;
        k %= nums.length;
        reverse(nums, 0, n);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n);
    }
    
    private void reverse(int[] nums, int start, int end) {
        // start = 0;
        // end = nums.length - 1;
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }  
}
