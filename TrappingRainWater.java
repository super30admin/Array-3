import java.util.Stack;

class TrappingRainWater {
    // TC: 2 * O(n)
    // SC: O(1)

    // Approach: Use one max building as a reference. Every height left of this
    // will have a right max. And every height right of this building will have a
    // leftMax.
    public int trapOneMaxHeight(int[] height) {
        int maxElevationIndex = 0;
        int maxElevation = height[0];
        int res = 0;

        for (int i = 1; i < height.length; i++) {
            if (maxElevation < height[i]) {
                maxElevation = height[i];
                maxElevationIndex = i;
            }
        }

        // leftmost to maxElevationIndex
        int leftMax = height[0];
        for (int i = 1; i < maxElevationIndex; i++) {
            if (height[i] < leftMax) {
                res += leftMax - height[i];
                System.out.println(res);
            }
            leftMax = Math.max(leftMax, height[i]);
        }

        // rightmost to maxElevationIndex
        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i > maxElevationIndex; i--) {
            if (height[i] < rightMax) {
                res += rightMax - height[i];
            }
            rightMax = Math.max(rightMax, height[i]);
        }

        return res;
    }

    // TC: O(n)
    // SC: O(1)

    // Approach: Process the side with a higher wall on opposite side. This
    // gurantees trapping of water.
    public int trapTwoPointers(int[] height) {
        int leftWall = Integer.MIN_VALUE;
        int rightWall = Integer.MIN_VALUE;

        int i = 0;
        int j = height.length - 1;
        int res = 0;

        while (i <= j) {
            if (leftWall >= rightWall) {
                // gurantee for j to have a bigger wall on left
                if (rightWall > height[j]) {
                    res += rightWall - height[j];
                }
                rightWall = Math.max(rightWall, height[j]);
                j--;
            } else {
                // gurantee for i to have a bigger wall on right
                if (leftWall > height[i]) {
                    res += leftWall - height[i];
                }
                leftWall = Math.max(leftWall, height[i]);
                i++;
            }
        }

        return res;
    }

    // TC: 2 * O(n)
    // SC: O(n)

    // Approach: Monotonic stack
    public int trapStack(int[] height) {
        // storing the indices of
        Stack<Integer> stack = new Stack();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i);
                continue;
            }

            // new element is bigger than peek
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int currentIndex = stack.pop();

                while (!stack.isEmpty() && height[currentIndex] == height[stack.peek()]) {
                    currentIndex = stack.pop();
                }

                if (!stack.isEmpty()) {
                    int leftWall = stack.peek();

                    // height * width
                    res += (Math.min(height[leftWall], height[i]) - height[currentIndex]) * (i - leftWall - 1);
                }
            }

            stack.push(i);
        }

        return res;
    }

}