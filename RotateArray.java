// Brute Force
// Time Complexity: O(n x k)
// Space Complexity: O(1)
 class Solution {
     public void rotate(int[] nums, int k) {
         if(nums == null || nums.length == 0 || k == 0) {
             return;
         }
         int n = nums.length;
         while(k > 0) {
             int temp = nums[n - 1];
             for(int i = n - 2; i >= 0; i--) {
                 nums[i + 1] = nums[i];

             }
             nums[0] = temp;
             k--;
         }
     }
 }

// Using Extra Array
// Time COmplexity: O(n)
// Space COmpleity: O(n)
 class Solution {
     public void rotate(int[] nums, int k) {
         int[] temp = new int[nums.length];

         for(int i = 0; i < nums.length; i++) {
             temp[(i+k) % nums.length] = nums[i];
         }

         for(int i = 0; i < nums.length; i++) {
             nums[i] = temp[i];
         }
     }
 }

// TIme Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        k = k %nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}