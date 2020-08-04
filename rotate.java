// Time = O(n) n is elements in array;
//Space = O(1);
//LeetCode : Worked



class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2 ) return;
      
        int n = nums.length;
          if(k>n){
            k = k%n;
        }
        for(int i = 0;i < n/2; i++){
            int temp = nums[n-1-i];
            nums[n-1-i] = nums[i];
            nums[i] = temp;
            
        }

        for(int i = 0;i < k/2; i++){
            int temp = nums[k-i-1];
            nums[k-i-1] = nums[i];
            nums[i] = temp;
        }
        
        int x = 1;
        for(int i = k; x<=(n-k)/2; i++){
            int temp = nums[n-x];
            nums[n-x] = nums[i];
            nums[i] = temp;
            x++;
        }

        

        
        
    }

}