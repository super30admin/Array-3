/* Time Complexity : O(n)) 
 *  n - len of array - height */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//Monotonic stack
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && height[st.peek()] <= height[i]){
                int popped = st.pop();
                if(!st.isEmpty()){
                    int minHeight = Math.min(height[i], height[st.peek()]);
                    result += ((minHeight - height[popped]) * (i - st.peek() - 1));
                }
            }
            st.push(i);
        }

        return result;
    }
}