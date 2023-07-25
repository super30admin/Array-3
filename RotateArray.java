// TC = O(n), SC = O(1) -- as done in place hence no extra space used.
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums == null || nums.length==0) return;
        if(k>n){
            k = k%n;
        }
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums, int left, int right){
        while(left<=right){
            swap(nums,left,right);
            left++; right--;
        }
    }

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}