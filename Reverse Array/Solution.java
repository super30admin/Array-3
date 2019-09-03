/**
 * Time Complexity: O(n)
 * Spacxe Complexity: O(1)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k % nums.length;
        }
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);           
        
    }
    
    public void reverse(int[] nums, int start, int end) {
        
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}