// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Swapping

class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return;
        
        int length = nums.length;
        
        k = k % length;
        
        if(k == length) return;
        
        swap(nums, 0, length - 1);
        
        swap(nums, 0, k - 1);
        
        swap(nums, k, length - 1);
    }
    private void swap(int[] nums, int i, int j)
    {
        int temp;
        while(i < j)
        {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}