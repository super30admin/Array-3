class RotateArrayByK {
    
    /*
      Time : O(2N) ~ O(N) | two times iterating over array
      Space : O(N) | Extra array used for rotation
      Leetcode : YES
    */
    /* Approach
     1. Create a new array and rotate in new array, then copy new array to nums
    */   
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums == null || k == 0 || n == 0) return;
         int[] temp = new int[n];
        k %= n;
        for(int i = 0; i < n; i++){
            temp[(i+k)%n] = nums[i];
        }
        
       // System.out.println(Arrays.toString(temp));
        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }
    }

    /*
      Time : O(2N) ~ O(N) | First time iteration for entire reverse, second time for 0 to k, k to n -1
      Space : O(1) | No extra space
      Leetcode : YES
    */
    /* Approach
     1. Rotate entire array first
     2. Rotate 0 to k -1
     3. rotate k to n -1
    */  
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums == null || k == 0 || n == 0) return;
        
        k %= n;
        
        rotate(nums, 0, n - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, n - 1);
        
    }
    
    private void rotate(int[] nums, int i, int j){
        while(i <= j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    /*
      Time : O(N x K) | we are shifting each element k times;
      Space : O(1) | No extra space
      Leetcode : YES
    */
    /*
    Approach :
      1. Store last element in temp;
      2. Now shift every element once to the right
      3. do this k times
    */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums == null || k == 0 || n == 0) return;

        k %= n;
        
        int temp;
        for(int i = 0; i < k; i++){
            int lastElement = nums[n - 1];
            for(int j = 0 ; j < n; j++){
                temp = nums[j];
                nums[j] = lastElement;
                lastElement = temp;
            }
        }     
    }
}
