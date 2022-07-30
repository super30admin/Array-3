//TC -O(n)
//SC - O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        k = k % nums.length;
        reverse(nums, 0 , nums.length - k - 1);
        reverse(nums, nums.length - k , nums.length - 1);
        reverse(nums, 0 , nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
