//TC - O(N);
//SC - O(1);
//LC - 189

class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k=k%n;
        
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
    }
    
    private void reverse(int [] nums,int l,int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    
    private void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}