/**
First find the tallest bar, because water trapped on the left and right of it can be calculated independently.
Traverse from the left up to the tallest bar, keeping track of the maximum height seen so far; water at each position = leftMax - currentHeight.
Do the same from the right side toward the tallest bar using rightMax, and sum all trapped water.
T.C: O(n)
S.C: O(1)
 */
var trap = function (height) {
    //as all the values coming in are positives or min is 0.
    let max = -1;
    let maxIdx = 0;
    for (let i = 0; i < height.length; i++) {
        let curr = height[i];
        if (max < curr) {
            max = curr;
            maxIdx = i;
        }
    }
    let result = 0;
    // left to max
    let left = 0;
    let lw = 0;
    while (left < maxIdx) {
        if (lw < height[left]) {
            lw = height[left];
        } else {
            result += (lw - height[left]);
        }
        left++;
    }
    // right to max
    let right = height.length - 1;
    let rw = 0;
    while (right > maxIdx) {
        if (rw > height[right]) {
            result += (rw - height[right]);
        } else {
            rw = height[right];
        }
        right--;
    }
    return result;
};