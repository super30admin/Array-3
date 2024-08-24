// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();  // Initialize a stack to store indices of the height array.
        int result = 0;  // This will store the total amount of trapped water.
        int n = height.length;  // Get the length of the height array.
        stack.push(-1);  // Push -1 to the stack as a marker for the bottom.
        
        for (int i = 0; i < n; i++) {
            // While the current height is greater than or equal to the height at the top of the stack,
            // we can calculate the trapped water.
            while (stack.peek() != -1 && height[i] >= height[stack.peek()]) {
                int poppedIdx = stack.pop();  // Pop the top index from the stack.

                int width = i - stack.peek() - 1;  // Calculate the width between the current index and the new top of the stack.
                int h = 0;  // Initialize the height of trapped water to 0.

                // Ensure the stack isn't empty before calculating the height.
                if (stack.peek() != -1) {
                    // The height of trapped water is the difference between the current height and the popped height,
                    // bounded by the minimum of the heights at the current index and the new top of the stack.
                    h = Math.min(height[stack.peek()], height[i]) - height[poppedIdx];
                }

                result += h * width;  // Add the trapped water to the result.
            }

            stack.push(i);  // Push the current index onto the stack.
        }
        
        return result;  // Return the total trapped water.
    }
}
