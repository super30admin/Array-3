// ## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

// Time Complexity : O(n logn)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

var reverse = (nums, l, r) => {
    while (l < r) {
        let temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++;
        r--;
    }
}
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
    let n = nums.length;
    if (k >= n) {
        k = k % n;
    }
    reverse(nums, 0, n - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, n - 1)
    return nums;
};
