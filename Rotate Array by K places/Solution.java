// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null) return;
        if(k==nums.length) return;
        if(k>nums.length) k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
    
    private void reverse(int[] nums, int l, int r){
        while(l<r){
            swap(nums, l, r);
            l++; r--;
        }
    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
