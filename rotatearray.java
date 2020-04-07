# Time complexity:O(k*n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No








class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);




    }


    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }


    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}