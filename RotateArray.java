//tc: O(n)
//sc: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k == 0){
            return;
        }
        
        int len = nums.length;
        k = k % len;
        
        //reverse entire array
        reverse(nums, 0, len-1);
        //reverse first k numbers
        reverse(nums, 0, k-1);
        //reverse remaining numbers
        reverse(nums, k, len-1);
    }
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}