//time - O(n), space - O(1)
class Solution {
    public int trap(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int result = 0;
        int l = 0, lw = 0;
        int r = nums.length-1, rw = 0;

        while(l<=r){
            if(lw <= rw){
                if(lw > nums[l]){
                    result += lw - nums[l];
                }
                else{
                    lw = nums[l];
                }
                l++;
            }
            else{
                if(rw > nums[r]){
                    result += rw - nums[r];
                }
                else{
                    rw = nums[r];
                }
                r--;
            }
        }
        return result;
    }
}
