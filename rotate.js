/**
Rotating right by `k` means the last `k` elements should move to the front while keeping their order.
Reverse the whole array to bring those last `k` elements to the front (but reversed).
Reverse the first `k` elements and the remaining `n-k` elements separately to restore their correct order.
T.C: O(n)
S.C: O(1)
 */
var rotate = function (nums, k) {
    let n = nums.length;
    if (k > n) {
        k = k % n;
    }
    // reverse function
    const reverse = (left, right) => {
        while (left < right) {
            [nums[left], nums[right]] = [nums[right], nums[left]];
            left++;
            right--;
        }
    };
    // reverse whole array
    reverse(0, nums.length - 1);
    reverse(0, k - 1);
    reverse(k, nums.length - 1);
};