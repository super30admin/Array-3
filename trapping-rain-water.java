// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// if element height is  greater than element at top of stack remove top element and calculate rain water trapped
// over it. keep adding elements to stack

class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<height.length;i++){
            if(s.isEmpty()) s.add(i);
            else if(height[s.peek()]>=height[i]) s.add(i);
            else {
                while(!s.isEmpty() && height[s.peek()]<height[i]){
                    int h = s.pop();
                    if(!s.isEmpty()) ans += (Math.min(height[i],height[s.peek()]) -height[h])*(i-s.peek()-1) ;
                }
                s.add(i);
            }
        }
        return ans;
    }
}