// Time complexity - 0(n)
// space complexity - 0(1)

class Solution {
    public void rotate(int[] nums, int k) {
      if(nums == null || nums.length == 0) return;
        int start = 0, end = nums.length - 1;
        if(k > nums.length) k = k%nums.length;
        reverse(nums, start, end);
        reverse(nums, start, k - 1);
        reverse(nums, k, end);
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
}