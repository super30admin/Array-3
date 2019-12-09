// Time Complexity : O(N+K)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope.
class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int temp[] = new int[k];
        for(int i = 0; i < k; i++){
            temp[i] = nums[nums.length-i-1];
        }
        for(int i = nums.length - k-1; i >= 0; i--){
            nums[i+k] = nums[i];
        }
        for(int i = 0; i < k; i++){
            nums[i] = temp[temp.length-i-1];
        }
    }
}