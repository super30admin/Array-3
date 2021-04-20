class RotateArray {
    
    // Time Complexity: O(n)    (where n -> no. of elements in the array)
    // Space Complexity: O(1)
    
    public void rotate(int[] nums, int k) {
        // Edge Case Checking
        if(nums == null || nums.length == 0 || k < 0)
            return;        
        
        int n = nums.length;        
        // If k > n --> k = k mod n
        k = k % n;
        
        // Reverse the entire array
        reverse(nums, 0, n-1);
        
        // Reverse the first k elements
        reverse(nums, 0, k-1);
        
        // Reverse the remaining n-k elements
        reverse(nums, k, n-1);
    }
    
    private void swap(int[] nums, int i, int j){
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }
}