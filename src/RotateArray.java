/*
Problem - Rotate Array (Right rotate by k steps) — reversal method
Approach - Rotating right by k means the last k elements move to the front.
Reversal trick:
 1) Reverse the whole array
 2) Reverse the first k elements
 3) Reverse the remaining n-k elements
 Time Complexity - O(n)
 Space Complexity - O(1)
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k > n){
            k = k%n;
        }
        // Step 1: reverse the entire array
        reverse(nums,0,n-1);
        // Step 2: reverse first k elements (which will become the rotated front part)
        reverse(nums,0,k-1);
        // Step 3: reverse the rest
        reverse(nums,k,n-1);

    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
