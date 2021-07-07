// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Brute Force Time : O(n*k) , Space :O(1)

    public void rotateBF(int[] nums, int k) {
        for(int i = 0; i < k; i++){
            int temp = nums[nums.length - 1];
            for(int j = nums.length -1; j >= 1; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }

    }
}
