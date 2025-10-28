/*
* Approach 1: first approach that comes to mind, is to use extra space and start iterating from n - k to n - 1 and then iterate from 0 to n - k - 1 and store it in an array and then copy from the new array to the current array.
TC: O(2n)-> O(n) -> iterate through the array and again iterate through the new array and save it to the given array
SC: O(n) -> additional array space

Approach 2: Inplace without extra space
- Reverse the entire array, then reverse from 0th index to n - k and then from n - k + 1 to n - 1 or rotate two halves first and then rotate the entire array
TC: O(n) -> iterate through all the elements in the nums array
SC: O(1) -> no additional space
*/
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
        
    }

    private int[] reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
}