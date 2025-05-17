import java.util.Stack;

public class TrapRainWater {
    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int popped = st.pop();
                if (!st.empty()) {
                    int width = i - st.peek() - 1;
                    int eHeight = Math.min(height[i], height[st.peek()]);
                    result += width * (eHeight - height[popped]);
                }
            }
            st.push(i);
        }
        return result;
    }
}
