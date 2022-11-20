// TC : O(n)
// SC : O(1)
// Method : reversal

class Solution {
    
    private int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        if(n == 0 || nums == null) return;
        
        for(int i = 0; i < n/2; i++) {
            swap(nums, i, n - i - 1);
        }
        
        k = k%n;
        
        for(int i = 0; i < k/2; i++) {
                swap(nums, i, k - i - 1);
        }
        n = n + k;
        for(int i = k; i < n/2; i++) {
            swap(nums, i, n - i - 1);
        }

    }
}
