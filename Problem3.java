// O(n) time complexity 
// O(1) space complexity
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        helper(nums, 0 , n-1);
        helper(nums, 0 , k-1);
        helper(nums, k , n-1);
        
    }

    private void helper(int[] nums, int start , int end){

        while(start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end --;
        }
    }
}
