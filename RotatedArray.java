// Time Complexity : O(2n) = O(n) where n is the number of elements
// Space Complexity : O(1) in place 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Reverse the whole array. Then reverse the first k elements. At last, reverse the 
last remaining n- k elements. For left rotation, reverse the n-k elements first and then the remaining k elements are reversed.
*/
class Solution {
    public void rotate(int[] nums, int k) {
     if(nums == null || nums.length == 0){
         return;
     }   
        int n = nums.length-1;
        if(k > n){
            k = k % (n+1);                                                          // If k > n then k is brought back to less than the array length
        }
        reverse(nums, 0, n);                                                        // Reverse the whole array
        reverse(nums, 0, k-1);                                                      // Reverse the first k elements
        reverse(nums, k, n);                                                        // Reverse the last n-k elements
    }
    private void reverse(int[] nums, int i, int j){                                         // Standard reverse algorithm
        while(i < j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}