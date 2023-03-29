/*
Rotate Array
1 2 3 6 5 k = 3; 5 6 3 2 1 -> 3 6 5 1 2
approach: reverse entire array, reverse k elements, reverse n-k elements
time: O(n)
space: O(1)
 */
public class Problem4 {
    public void rotate(int[] nums, int k) {

        if(nums.length==1) return;
        int l=0,r=nums.length-1;

        while(l<=r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
        k = k%nums.length;
        helper(nums, 0, k-1);
        helper(nums, k, nums.length-1);
    }

    private void helper(int[] nums, int start, int end) {
        int l = start, r = end;
        while(l<=r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
