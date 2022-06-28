// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] nums, int num1, int num2){
        while(num1<num2){
            int temp = nums[num1];
            nums[num1] = nums[num2];
            nums[num2] = temp;
            num1++;
            num2--;
        }
       
    }
}