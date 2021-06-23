class Solution {
    //Time O(N)
    //Space O(1)
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2)
        {
            return;
        }
        int n = nums.length-1;
        if(k >= nums.length)
        {
            k = k%nums.length;
        }
        reverse(nums , 0 , n-k);
        reverse(nums , n-k+1 , n);
        reverse(nums , 0 , n);
    }
    private void reverse(int[] nums , int i , int j)
    {
        while(i <= j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}