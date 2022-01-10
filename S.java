import java.util.Arrays;

class Solution {
    //o(n) time and o(1) space
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        
        int n = nums.length;
        if (k > n) k = k % n;
        reverse(nums, 0 , n-1 );
        reverse (nums, 0, k -1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l , int r){
        while(l < r){
            swap(nums, l, r );
            l++; r--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //o(n) time and o(1) space
    public int trap(int[] height) {
        
        if(height == null || height.length == 0) return 0; 
        int lw = 0; int rw = 0;
        int l = 0; int r = height.length-1;
        int result = 0;
        while(l <= r){
            if(lw <= rw){
                //left side
                if(lw > height[l]){
                    result += lw - height[l];
                } else{
                    lw = height[l];
                }
                l++;
            } else{
                if(rw > height[r]){
                    result += rw - height[r];
                } else{
                    rw = height[r];
                }
                r--;
                
            }
        }
        return result;
        
    }

    //o(nlogn)time and constant space
        public int hIndex(int[] citations) {
            if(citations.length == 0 || citations == null) return 0;
            Arrays.sort(citations);
            for(int i = 0; i < citations.length; i++){
                int diff = citations.length - i;
                if(diff <= citations[i]){
                    return diff;
                }
            }
            return 0;
        }
    
}