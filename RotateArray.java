/*
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums == null || nums.length == 0){
            return;
        }
        
        int n = nums.length;
        k = k % n;
        reverseList(nums, 0, nums.length-1);
        reverseList(nums, 0, k-1);
        reverseList(nums, k, nums.length - 1);
        
    }
    
    private void reverseList(int[] nums, int i, int j){
        
        while(i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
            i++;
            j--;
        }
    }
}