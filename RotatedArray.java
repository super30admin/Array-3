/**
 * Time Complexity : O(2n) = O(n) where n is the number of elements
 * Space Complexity : O(1)
 */
public class RotatedArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }   
           int n = nums.length-1;
           if(k > n){
               k = k % (n+1);                                                          
           }
           reverse(nums, 0, n);                                                        // Reverse the whole array
           reverse(nums, 0, k-1);                                                      // Reverse the first k elements
           reverse(nums, k, n);                                                        // Reverse the last n-k elements
       }
       private void reverse(int[] nums, int i, int j){                                         
           while(i < j){
               int t = nums[i];
               nums[i] = nums[j];
               nums[j] = t;
               i++;
               j--;
           }
       }
}