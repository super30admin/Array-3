// ## Problem3  Rotate Array by K Places
// (https://leetcode.com/problems/rotate-array/)

// time: O(n)
// space: O(1)

const rotate = function(nums, k) {
    if(!nums || nums.length < 2) return;
    let n = nums.length - 1;
    if(k > nums.length) k = k % nums.length;
    reverse(nums, 0 ,n);
    reverse(nums, 0, k-1);
    reverse(nums, k, n);
};
function reverse(nums, l, r) {
    while(l < r) {
        let temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++;
        r--;
    }
}