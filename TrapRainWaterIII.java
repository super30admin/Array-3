// Time complexity = O(2*n)
// Space complexity = O(n)
// monotonically decreasing stack.
// when we get higher height than the stack, pop the stack elements till you get an element which is greater than the current incoming height.
class Solution {
    public int trap(int[] height) {
        int result=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);// dummy index pushed.
        for(int i=0;i< height.length;i++) {
            while(stack.peek()!=-1 && height[i]> height[stack.peek()]) {
                int popped = stack.pop();
                if(stack.peek()==-1) break;// stack peek is -1, we can skip it.
                result += (i- stack.peek()-1)* (Math.min(height[i], height[stack.peek()])-height[popped]);// width*height
            }
            stack.push(i);
        }
        
        return result;
    }
}