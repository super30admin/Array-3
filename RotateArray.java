// Time Complexity : O(n) 
//Space Complexity : O(n)

/**
 * Rotates an array to the right by k steps using the in-place reversal approach.  
 * The array is reversed fully, then partially reversed in two segments to restore order.  
 * This method runs in O(n) time and uses O(1) extra space.  
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length; 
        k = k % n; 

        reverse(nums, 0, n-1); 
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
