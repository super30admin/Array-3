// Approach 4: Monotonically increasing stack
// TC: O(N)
// SC: O(N)
class Solution {
    public int trap(int[] height) {
        int volume = 0;
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < height.length; i ++) {
            while (!indexStack.isEmpty() && height[i] > height[indexStack.peek()]) {
                int poppedIndex = indexStack.pop();
                if (!indexStack.isEmpty()) {
                    int wallHeight = Math.min(height[i], height[indexStack.peek()]) - height[poppedIndex];
                    int width = i - indexStack.peek() - 1;
                    volume += wallHeight * width;
                }
            }
            indexStack.push(i);
        }
        return volume;
    }
}

// Approach 3: One pass using two pointers solution with constant space 
// TC: O(N)
// SC: O(1)
class Solution {
    public int trap(int[] height) {
        int result = 0;
        int leftWall = 0;
        int left = 0;
        int rightWall = height.length - 1;
        int right = height.length - 1;
        while (left <= right) {
            if (height[rightWall] > height[leftWall]) {
                // min height will be of left wall
                if (height[leftWall] > height[left]) {
                    result += height[leftWall] - height[left];
                } else {
                    leftWall = left;
                }
                left ++;
            } else {
                // min height will be of right wall
                if (height[rightWall] > height[right]) {
                    result += height[rightWall] - height[right];
                } else {
                    rightWall = right;
                }
                right --;
            }
        }
        return result;
    }
}


// Approach 2: Two pass solution with constant time
/**
 * 1. Iterate the entire array and find index of max height.
 * 2. a. Iterate from [0, maxIdx - 1] and find the water trapped between leftWall and left index.
 *    b. Iterate from [height.length - 1, maxIdx + 1] and find the water trapped between rightWall and right index.
 */
// TC: 2N ~= O(N)
// SC: O(1)
class Solution {
    public int trap(int[] height) {
        int maxIdx = -1;
        int maxHeight = -1;
        // find max index
        for (int i = 0; i < height.length; i ++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
                maxIdx = i;
            }
        }
        // find result of water trapped on left of maxIdx
        int result = 0;
        int leftWall = 0;
        int left = 0;
        while (left < maxIdx) {
            if (height[leftWall] > height[left]) {
                result += height[leftWall] - height[left];
            } else {
                leftWall = left;
            }
            left ++;
        }
        // find result of water trapped on right of maxIdx
        int rightWall = height.length - 1;
        int right = height.length - 1;
        while (right > maxIdx) {
            if (height[rightWall] > height[right]) {
                result += height[rightWall] - height[right];
            } else {
                rightWall = right;
            }
            right --;
        }
        return result;
    }
}

// Approach 1: Three pass solution
/**
 * 1. Iterate from left to right to populate leftWallMax[].
 * 2. Iterate from right to left to populate rightWallMax[].
 * 3. Iteration from left to right to calculate maximum water trapped between the left and right walls at each index.
 */
// TC: 3N ~= O(N)
// SC: O(N)
class Solution {
    public int trap(int[] height) {
        int[] leftWallMax = new int[height.length];
        int[] rightWallMax = new int[height.length];
        // first pass to populate leftWallMax
        int max = 0;
        for (int i = 0; i < height.length; i ++) {
            max = Math.max(max, height[i]);
            leftWallMax[i] = max;
        }
        // second pass to populate rightWallMax
        max = 0;
        for (int i = height.length - 1; i >= 0; i --) {
            max = Math.max(max, height[i]);
            rightWallMax[i] = max;
        }
        // third pass to calculate result
        int result = 0;
        for (int i = 0; i < height.length; i ++) {
            result += Math.min(leftWallMax[i], rightWallMax[i]) - height[i];
        }
        return result;
    }
}