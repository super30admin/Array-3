class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return; //if there are no elements in the nums array or the length of the nums array is 0, we simply return
        int n = nums.length; //we store the length of the nums array in the integer variable n
        if(k > n) { //if the value of k is greater than n
            k = k % n; //we take the value of k as k mod n, which inturn gives the same result of the rotation
        }
        reverse(nums, 0, n - 1); //we first reverse the nums array
        reverse(nums, 0, k - 1); //then we reverse the array starting from 0 to k-1. this reverses the first k elements of the nums array
        reverse(nums, k, n - 1); //then we reverse the second part of the array starting from k.
    }
    private void reverse(int[] nums, int l, int r) { //this is the reverse method
        while(l < r) { // if l is less than r
            swap(nums, l, r); //we swap the elements
            l++; //and we move forward
            r--; //we move towards the left for further reversing the elements
        }
    }
    private void swap(int[] nums, int l, int r) { //this is the swap method
        int temp = nums[l]; //we take a temp variable and store the value we have at the l index
        nums[l] = nums[r]; //we update the l index with the value we have in the r index
        nums[r] = temp;//now we update the r index with the value we stored in the temp variable;
    }
}
//tc and sc - O(n) and O(1)