// Time Complexity : O(n) - O(n+k+(n-k)) as we reverse nums and then only 0-k elements and then k-n elements
// Space Complexity : O(1) constant space as we did not use any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem3 {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return;
        }

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, k - 1);
    }

    public void reverse(int[] nums, int l, int r){
        while(l <= r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
