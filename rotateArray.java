class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        if(k > len){
            k = k % len;
        }
        //reverse the whole array
        reverse(nums, 0, len - 1);
        
        //reverse the array from 0th index to k index 
        reverse(nums, 0, k - 1);
        
        //reverse the array from kth index to last index of the array
        reverse(nums, k, len - 1);
    }
    private void reverse(int [] nums, int left, int right){
        while(left <= right){
            swap(nums, left, right);
            left++; right--;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

Time Complexity = O(n)
Space Complexity = O(1)    
