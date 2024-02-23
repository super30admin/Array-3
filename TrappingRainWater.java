public class TrappingRainWater {
    public int trap(int[] height) {
        return trapUsingSinglePass(height);
    }
    // TC: O(N) where N is length of array
    // SC: O(1)
    private int trapUsingSinglePass(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int leftMax = 0, rightMax = 0, res = 0;
        while (i <= j) {
            if (leftMax >= rightMax) {
                if (height[j] < rightMax) {
                    res += rightMax - height[j];
                }
                rightMax = Math.max(rightMax, height[j]);
                j--;
            } else {
                if (height[i] < leftMax) {
                    res += leftMax - height[i];
                }
                leftMax = Math.max(leftMax, height[i]);
                i++;
            }
        }
        return res;
    }

    // TC: O(N) where N is length of array
    // SC: O(1)
    private int trapUsingMaxHeight(int[] height) {
        int maxHeight = height[0];
        int maxHeightIndex = 0;
        int n = height.length;
        for (int i = 1; i < n; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }
        int leftMax = 0;
        int i = 0;
        int res = 0;
        while (i < maxHeightIndex) {
            if (height[i] < leftMax) {
                res += leftMax - height[i];
            }
            leftMax = Math.max(leftMax, height[i]);
            i++;
        }
        i = n - 1;
        int rightMax = 0;
        while (i > maxHeightIndex) {
            if (height[i] < rightMax) {
                res += rightMax - height[i];
            }
            rightMax = Math.max(rightMax, height[i]);
            i--;
        }
        return res;
    }

    // TC: O(3N) where N is length of array
    // SC: O(N) where N is length of array
    private int trapUsingLeftMaxAndRightMax(int[] height) {
        int n = height.length;
        int[] leftMaxHeights = new int[n];
        int[] rightMaxHeights = new int[n];
        int leftMax = height[0];
        for (int i = 1; i < n; i++) {
            leftMaxHeights[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        int rightMax = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxHeights[i] = rightMax;
            rightMax = Math.max(rightMax, height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int leftHeight = leftMaxHeights[i];
            int rightHeight = rightMaxHeights[i];
            int minHeight = Math.min(leftHeight, rightHeight);
            if (height[i] < minHeight) {
                res += minHeight - height[i];
            }
        }
        return res;
    }
}
