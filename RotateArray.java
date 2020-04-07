//TimeComplexity: O(n)
//Space Complexity: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length -1;
        k%=n+1;
        reverse(nums, 0, n);
        reverse(nums, 0, k-1);
        reverse(nums, k, n);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start <= end){
            
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
