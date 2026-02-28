/*
LeetCode 42: Trapping Rain Water
Approach -  (Monotonic Increasing Stack):
We maintain a monotonically increasing stack of bar indices by height.
When we find a taller bar, it means we’ve found a right boundary and can now trap water over shorter bars in between.
We calculate trapped water using the distance between boundaries and the bounded height.
Time Complexity - O(n)
Space Complexity - O(n)
 */

import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        // no bars -> no water
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int res = 0;
        // Stack stores indices of bars; heights are monotonic increasing (non-decreasing)
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            // If current bar is higher than the bar at stack top,
            // we can potentially trap water by forming a right boundary at i.
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                // This popped index is the top of a container
                int top = st.pop();
                // If stack is empty, there is no left boundary to trap water
                if (!st.isEmpty())
                {
                    // Horizontal distance between left and right boundaries excluding boundaries
                    int width = i - st.peek() - 1;
                    // Water level is limited by the shorter boundary
                    int efheight = Math.min(height[i],height[st.peek()]);
                    res += width * (efheight-height[top]);
                }
            }
            // Push current index as a potential left boundary
            st.push(i);
        }
        return res;
    }
}
