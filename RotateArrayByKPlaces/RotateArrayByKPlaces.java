/* Time Complexity : O(n)) 
 *  n - len of array - nums */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0) return;
        int n = nums.length;
        if(k > n){
            k = k % n;
        }
        //reverse first and second half of the array and the then reverse the resultant array
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }

    private void reverse(int[] nums, int lp, int rp){
        while(lp < rp){
            swap(nums, lp, rp);
            lp++;
            rp--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}