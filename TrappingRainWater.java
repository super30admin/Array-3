// Monotonic Stack O(n) time, O(n) space
// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         Stack<Integer> st = new Stack<>();
//         int ans = 0;

//         for (int i = 0; i < n; i++) {

//             while(!st.isEmpty() && height[i] > height[st.peek()]) {
//                 int popped = st.pop();

//                 if (!st.isEmpty()) {
//                     int effectiveHeight = Math.min(height[i], height[st.peek()]);
//                     int width = i - st.peek() - 1;

//                     ans += (effectiveHeight - height[popped]) * width;
//                 }
//             }

//             st.push(i);
//         }
//         return ans;
//     }
// }

// Two pointers O(n) time, O(1) space
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int ans = 0;
        
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
            }
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
            }
        }
        return ans;
    }
}