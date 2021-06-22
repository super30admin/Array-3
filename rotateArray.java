//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//reverse the whole array
//reverse till k - 1 position
//reverse from k position till length
class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums.length == 0 || k == 0){
            
            return;
        }
        int i = 0;
        int n = nums.length;
        if(k > n){
            
            k = k % n;
        }
     //   System.out.println(k);
       reverseArray(0, n-1, nums);
     //   for(int j = 0; j < n; j ++){
       //      System.out.println(nums[j]);
       // }
        // System.out.println(k);
        reverseArray(0, k-1, nums); 
        // System.out.println(k);
        reverseArray(k, n-1, nums); 
        // System.out.println(k);
        
    }
    
   private void reverseArray(int left, int right, int arr[]){
        
        while(left < right){
            
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left ++;
            right --;
            
        }
    }
}