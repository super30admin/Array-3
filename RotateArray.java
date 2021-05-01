class Solution {
    public void rotate(int[] nums, int k) {
        //Base condition
        if(nums == null || nums.length == 0 || k == 0){
            return;
        }
        
        k = k % nums.length;
        //reversing the entire array
        reverse(nums, 0, nums.length - 1);
        
        //reversing the first k elements
        reverse(nums, 0, k - 1);
        
        //reversing all other elements
        reverse(nums, k, nums.length - 1);
        
    }
    
    //funtion to reverse an array
    private void reverse(int nums[], int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)