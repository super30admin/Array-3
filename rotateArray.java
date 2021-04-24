//Time Complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        k = k % len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
        }
    }
}