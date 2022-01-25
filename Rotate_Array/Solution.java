// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * First we will reverse the array.
 * Then we will reverse first k elements and then remaining (n-k) elements
 * If K > length then we take k % len of array as it will give us exact no of rotations to be performed after we have performed rotate operation equal to len of array
 * This is required as whenever we perform rotate operations = len of array, we get original array back
*/

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || k == 0)return;
        if(k > nums.length){
            k = k % nums.length;
        }
        
        //bruteForce(nums, k);
        
        //extraSpace(nums, k);
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void extraSpace(int[] nums, int k){
        int[] temp = new int[nums.length];
        int j = 0;
        
        for(int i = nums.length - k; i < nums.length;i++){
            temp[j] = nums[i];
            j++;
        }
        
        for(int i = 0; i < nums.length - k;i++){
           temp[j] = nums[i];
            j++; 
        }
        
        for(int i = 0; i < nums.length;i++){
            nums[i] = temp[i];
        }
    }
    
    private void bruteForce(int[] nums, int k){
        for(int i = 0; i < k;i++){
            int replace = nums[nums.length - 1];
            for(int j = 0; j < nums.length;j++){
                int temp = nums[j];
                nums[j] = replace;
                replace = temp;
            }
        }
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}