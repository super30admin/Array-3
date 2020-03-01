class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1  ) return;
        
        k = k%nums.length;
        // revrerse 
        reverse(nums,0, nums.length-1);
         // reverse first k -1 
        reverse(nums,0, k-1);
        reverse(nums,k, nums.length-1);
        
      //    revertse k to end
        
        
        
    }
    
    private void reverse(int[] nums, int start, int end) {
        int in1 = (end - start) / 2;
        int in2  =  (end - start) % 2;
        int index = in1 + in2;
        for( int i = 0 ; i < index ; i ++ ) {
            swap(nums ,  start + i , end - i );
        }
        
        
    }
    
    
    private void swap (int[] nums, int i,int j){
        int tmp = nums[i] ;
         nums[i] =  nums[j] ;
          nums[j] = tmp;
 }
}
