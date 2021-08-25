class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        if(k == 0){
            return;
        }
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        
    }
    
    public void reverse(int[] nums, int i, int j){
        // i = 0;
        // j = nums.length - 1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}