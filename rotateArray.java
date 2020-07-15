//time complexity O(3n) because we reverse the array 3 times
//space complexity O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2) return;
        if(k > nums.length) k = k % nums.length;//because effective rotations is k % n
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int l, int r){
        while(l <= r){
            swap(nums, l, r);
            l++; r--;
        }
    }
}
