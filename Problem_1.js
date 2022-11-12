//## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

// Time Complexity : O(n)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function (height) {
    if (height === null || height.length === 0)
        return 0;
    let result = 0;
    let l = 0, lw = 0, rw = 0, r = height.length - 1;
    // l and r are indexes and lw and rw is left and right walls which indicate the height
    while (l <= r) {
        // Move from left if left height is less or equal to right height
        if (lw <= rw) {
            // Trap water only if left wall height is more than height of left index
            if (lw > height[l]) {
                // Trap water
                result += lw - height[l];
            } else {
                // Else move left wall
                lw = height[l];
            }
            l++;
        } else {
            if (height[r] < rw) {
                // Trap water
                result += rw - height[r];
            } else {
                rw = height[r];
            }
            r--;
        }
    }
    return result;
};
