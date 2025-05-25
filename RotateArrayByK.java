// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Reverse the entire array.
//   - Then reverse the first k elements.
//   - Then reverse the remaining n - k elements.
//   - This results in the array being rotated to the right by k steps.

public class RotateArrayByK {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);  //reverse whole array first
        reverse(nums, 0, k-1);  //reverse first k elements
        reverse(nums, k, n-1);  //reverse remaining elements
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start]; //swap elements at start and end index in nums[]
            nums[start] = nums[end];
            nums[end] = temp;
            start++;    //incr start
            end--;  //decr end
        }
    }

    public static void main(String[] args) {
        RotateArrayByK obj = new RotateArrayByK();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        obj.rotate(nums, k);
        System.out.print("Array after rotation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Expected: 5 6 7 1 2 3 4
    }
}
