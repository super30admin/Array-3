// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, switching to the 2 pointer method for constant space took some thinking about

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(heights) {
    if (!heights || !heights.length) return 0;
    let left = 0,
        right = heights.length - 1,
        leftMax = 0,
        rightMax = 0,
        total = 0;
    
    while (left < right) {
        if (heights[left] < heights[right]) {
            if (heights[left] >= leftMax) leftMax = heights[left++];
            else total += leftMax - heights[left++];
        } else {
            if (heights[right] >= rightMax) rightMax = heights[right--];
            else total += rightMax - heights[right--];
        }
    }
    return total;
};
