import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;

        int max = 0, maxIdx = -1;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (max < height[i]) {
                max = height[i];
                maxIdx = i;
            }
        }

        int lw = 0, l = 0;
        int rw = n - 1, r = n - 1;
        while (l < maxIdx) { // we have bigger right wall for sure
            if (height[lw] > height[l]) {
                res += height[lw] - height[l];
            } else {
                lw = l;
            }
            l++;
        }

        while (r > maxIdx) { // we have a bigger left wall for sure
            if (height[rw] > height[r]) {
                res += height[rw] - height[r];
            } else {
                rw = r;
            }
            r--;
        }

        return res;
    }
}

//TC: O(2n), SC: O(1)


//Approach - 2
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int lw = 0, l = 0;
        int rw = n - 1, r = n - 1;
        int res = 0;

        while (l <= r) {
            if (height[rw] > height[lw]) {
                if (height[lw] > height[l]) {
                    res += height[lw] - height[l];
                } else {
                    lw = l;
                }
                l++;
            } else {
                if (height[rw] > height[r]) {
                    res += height[rw] - height[r];
                } else {
                    rw = r;
                }
                r--;
            }

        }
        return res;
    }
}


//TC: O(n), SC: O(1)

//Approach - 3
class MonotonicStack {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        Stack<Integer> stackIndex = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stackIndex.isEmpty() && height[i] > height[stackIndex.peek()]) {
                int popped = stackIndex.pop();

                if (!stackIndex.isEmpty()) {
                    int width = i - stackIndex.peek() - 1;
                    int effHeight = Math.min(height[i], height[stackIndex.peek()]);
                    res += width * (effHeight - height[popped]);
                }
            }
            stackIndex.push(i);
        }
        return res;
    }
}

//Monotonically increasing stack - TC: O(2n), SC: O(n)