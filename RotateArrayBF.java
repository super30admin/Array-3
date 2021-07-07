//Brute Force
//TC : O(kn)
//SC : O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0 )
            return ;
        k = k % nums.length;
        
        while(k>0){
            
            int prev = nums[nums.length-1];
            
            for(int i=0;i<nums.length;i++){
               int temp = nums[i];
                nums[i] =  prev;
                prev = temp;
            }
            
            
            k--;
        }
    }
}