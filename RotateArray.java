class Solution {
    public void rotate(int[] nums, int k) {

        int newK = k % nums.length;
        rotate(nums, 0, nums.length-1);
        rotate(nums,0,newK-1);
        rotate(nums, newK, nums.length-1);
        
    }

    void rotate(int[] nums, int l, int r){

       while(l<r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++; r--;
       }
    }
}