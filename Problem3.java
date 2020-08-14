// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    int[] nums;
    
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        
        this.nums = nums;
        int n = nums.length;
        
        if(k>=n) k = k%n;
        
        reverse(0, n-1);
        
        reverse(0, k-1);
        
        reverse(k, n-1);
    }
    
    private void reverse(int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}