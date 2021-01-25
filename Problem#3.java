// #LC 189  #S30 119  - Rotate array

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int n = nums.length;
        
        if( k > n) {
            k = k % n;
        }
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l ,r);
            l++;
            r--;
        }
    }
    
    private void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
Complexity Analysis
Time complexity: 
O(n). n elements are reversed a total of three times.

Space complexity: O(1). No extra space is used.

*/