// Time Complexity : o(3n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 189
//Approach : Extra space


class Solution {
    public void rotate(int[] nums, int k) {
        int res[]  = new int[nums.length];
        int j  = 0 ;
        if(k>nums.length){
            k=k%nums.length;
        }
        for(int i = nums.length - k  ; i <= nums.length-1; j++ , i++ ){
             res[j] = nums[i];
             //System.out.print(i-k);
        }
        for(int i = 0 ; i < nums.length - k; j++, i++ ){
             res[j] = nums[i];
            //System.out.print( k + i);
        }
        
        for(int i = 0 ; i < nums.length ; i++ ){
              nums[i] = res[i];
            // System.out.print(res[i]);
        }

    }
}


// Time Complexity : o(2n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 189
//Approach : No Extra space

class Solution {
    public void rotate(int[] nums, int k) {
       if(nums == null || nums.length == 0) return ;
      if(k>nums.length){
            k=k%nums.length;
        }
        reverse(nums,0,nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums,k,nums.length-1);

    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums , int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}