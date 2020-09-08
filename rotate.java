/* Time complexity: O(n)
space copelxity: O(1)
*/

class Solution{
    public void rotate(int[] nums, int k){
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        if(k > n){
            k = k%n;
        }

        helper(nums, 0, n-1);
        helper(nums, 0, k-1);
        helper(nums, k, n-1);
    }

    public void helper(int[] nums, int a, int b){
        while(a < b){
            swap(nums, a, b);
            a++; b--;
        }
    } 

    public void swap(int[] nums, int l, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}