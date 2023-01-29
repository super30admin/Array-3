
class Solution {
    public void rotate(int[] nums, int k) {
        int newK = k % nums.length; // k % nums.length , beacuse when k = n, then rotation has no effect, so we will only count the rotations lesser than n
        reverseRotate(nums, newK);  
    }

    // T:O(n), S:O(1)
    private void reverseRotate(int[] nums,int k){
        // we will reverse the array first
        rev(nums, 0, nums.length-1);
        // we will then reverse the first k elements
        rev(nums, 0, k-1);
        // we will then reverse the rest of the elements after k
        rev(nums, k, nums.length-1);
    }
    private void rev(int[] nums, int s , int e){
        //if(e < nums.length)
        while(s < e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;e--;
        }
    }


}