//Time -O(n)
//Space - O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length<k){
            k = k%nums.length;
        }
        int i=0;
        int j = nums.length-1;
        while( i<=j){
             swap(nums,i,j );
            i++;j--;
        }
        i=0;
        j = k-1;
          while( i<=j){
             swap(nums,i,j );
            i++;j--;
        }
        
        i= k;
        j=nums.length-1;
           while( i<=j){
               swap(nums,i,j );
               i++;j--;
        }
        
    }
    
    void swap(int[] nums, int i, int j){
        if(nums[i]!=nums[j]){
            nums[i] = nums[i]+nums[j];
            nums[j] = nums[i] -nums[j];
            nums[i] = nums[i] -nums[j];
            
        }
    }
}

// 1234567 5671234
//7654321
//5674321

