class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(nums.length==1 || k==0)
            return;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public static void reverse(int [] nums, int start, int end){
        int temp;
        for(int i=start;i<=start+(end-start)/2;i++){
            temp = nums[i];
            nums[i] = nums[end-i+start];
            nums[end-i+start] = temp;
        }
    }
}