class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(nums.length==k || k == 0) return;
        int temp[] = new int[nums.length];
        for(int i=0, j=nums.length-k-1; i<nums.length-k; i++) {
            temp[i] = nums[j--];
        }
        for(int i = nums.length-k, j=nums.length-1; i<nums.length; i++) {
            temp[i] = nums[j--];
        }
        for(int i = 0, j = nums.length-1; i<nums.length; i++, j--) {
            nums[i] = temp[j];
        }
    }
}