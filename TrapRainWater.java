class Solution {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && height[i] > height[st.peek()]){
                int popped = st.pop();
                if(st.isEmpty()) break;
                int w = i - st.peek() - 1;
                int h = Math.min(height[st.peek()], height[i]) - height[popped];
                result+= h*w;
            }
            st.push(i);
        }
        return result;
    }
}
