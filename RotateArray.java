package Array-3;
// Time Complexity : O(n)
// Space Complexity : O(1)
public class RotateArray {
    class Solution {

        public void rotate(int[] nums, int k) {
           int n = nums.length;
           if(n==0 || n == 1) return;
           if(k>=n) k = k%n;
           for(int i=0;i<n/2;i++)
           {
               int temp = nums[i];
               nums[i] = nums[n-i-1];
               nums[n-i-1] = temp;
           }
             
           for(int i=0;i<k/2;i++)
           {
               int temp = nums[i];
               nums[i] = nums[k-i-1];
               nums[k-i-1] = temp;
           }
         
           for(int i=0;i<(n-k)/2;i++)
           {
               int temp = nums[i+k];
               nums[i+k] = nums[n-i-1];
               nums[n-i-1] = temp;
           } 
             
            
        }
    }
    
}
