
//Time complexity -  O(n)
//Space complexity - O(1)

class Solution {
    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k <= 0)
            return;

        int len = nums.length;
        k = k > len ? k % len : k;
        int firstHalfLen = len - k;

        int left = 0, right = firstHalfLen -1;
        while(left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }

        left = 0;
        right = nums.length - 1;
        while(left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }

        left = 0;
        right = k - 1;
        while(left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
        return;
    }
}
