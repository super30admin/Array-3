// brute force
// tc: O(n^2) sc: O(1)

class Solution {

  public int trap(int[] height) {
    int ans = 0;
    int size = height.length;
    for (int i = 1; i < size - 1; i++) {
      int left_max = 0, right_max = 0;
      // Search the left part for max bar size
      for (int j = i; j >= 0; j--) {
        left_max = Math.max(left_max, height[j]);
      }
      // Search the right part for max bar size
      for (int j = i; j < size; j++) {
        right_max = Math.max(right_max, height[j]);
      }
      ans += Math.min(left_max, right_max) - height[i];
    }
    return ans;
  }
}

// DP -> tc:O(n) sc:O(n)

class Solution {

  public int trap(int[] height) {
    // Case of empty height array
    if (height.length == 0) return 0;
    int ans = 0;
    int size = height.length;
    // Create left and right max arrays
    int[] left_max = new int[size];
    int[] right_max = new int[size];
    // Initialize first height into left max
    left_max[0] = height[0];
    for (int i = 1; i < size; i++) {
      // update left max with current max
      left_max[i] = Math.max(height[i], left_max[i - 1]);
    }
    // Initialize last height into right max
    right_max[size - 1] = height[size - 1];
    for (int i = size - 2; i >= 0; i--) {
      // update right max with current max
      right_max[i] = Math.max(height[i], right_max[i + 1]);
    }
    // Calculate the trapped water
    for (int i = 1; i < size - 1; i++) {
      ans += Math.min(left_max[i], right_max[i]) - height[i];
    }
    // Return amount of trapped water
    return ans;
  }
}

// stack - same tc and sc

public class Solution {

  public int trap(int[] height) {
    int ans = 0, current = 0;
    Deque<Integer> st = new LinkedList<Integer>();
    while (current < height.length) {
      while (!st.isEmpty() && height[current] > height[st.peek()]) {
        int top = st.peek();
        st.pop();
        if (st.isEmpty()) break;
        int distance = current - st.peek() - 1;
        int bounded_height =
          Math.min(height[current], height[st.peek()]) - height[top];
        ans += distance * bounded_height;
      }
      st.push(current++);
    }
    return ans;
  }
}
