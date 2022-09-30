//reverse two halves and then reverse the second half combined

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return;
        
        int n = nums.length;
        k = k % n;     // For edge cases & k>nums.length
        
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, 0, n-1);
    }
    
    public void reverse(int[] nums, int left, int right){
        while(left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right--;
        }
    }
}

//Time Complexity :O(n)
//Space Complexity :O(1)