// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// for trap1pass - at every index we process the smaller side and update the smaller side wall
// for trap2pass - find max element and then process left with max as right wall and right side with max as left wall
// for trap - use stack to keep track of indices of walls in increasing order and process the histograms horizontally
// When we find a taller bar - a right boundary and can now trap water over shorter bars in between.

class Solution {

    // monotonically increasing stack
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack();
        int result = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[i] >= height[st.peek()]) {
                int pop = st.pop();
                if (st.isEmpty())
                    break;
                int width = i - st.peek() - 1;
                int effH = Math.min(height[i], height[st.peek()]);
                result += width * (effH - height[pop]);
            }
            st.push(i);
        }

        return result;
    }

    public int trap1Pass(int[] height) {
        int n = height.length;
        int result = 0;

        int l = 0;
        int lw = 0;
        int r = n - 1;
        int rw = n - 1;

        while (l <= r) {
            // process smaller side first
            if (height[lw] <= height[rw]) {
                if (height[l] < height[lw]) // trap
                    result += (height[lw] - height[l]);
                else
                    lw = l;
                l++;
            } else {
                if (height[r] < height[rw]) // trap
                    result += (height[rw] - height[r]);
                else
                    rw = r;
                r--;
            }
        }

        return result;
    }

    public int trap2Pass(int[] height) {
        int n = height.length;
        int maxIndex = -1;
        int max = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (max <= height[i]) {
                max = height[i];
                maxIndex = i;
            }
        }

        // start to maxIndex
        int l = 0;
        int lw = 0;
        while (l < maxIndex) {
            if (height[l] < height[lw]) // trap
                result += (height[lw] - height[l]);
            else
                lw = l;
            l++;
        }

        // maxIndex to end
        int r = n - 1;
        int rw = n - 1;
        while (r > maxIndex) {
            if (height[r] < height[rw]) // trap
                result += (height[rw] - height[r]);
            else
                rw = r;
            r--;
        }

        return result;
    }

}