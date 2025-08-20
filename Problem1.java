// Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we use stack(monolethic decreasing)ie. we keep adding until the height is small than 
// current stack top
// if height is greater, we caalculate by popping until stack in empty or
// popped is equal to or smaller than current height

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result=0;
        Stack<Integer> st = new Stack<>(); //monolethic decrease
        for(int i=0;i<n;i++){
            //resolve
            while(!st.isEmpty()&&height[st.peek()]<=height[i]){
                int popped = st.pop(); //current
                if(!st.isEmpty()){
                    int minWall=Math.min(height[i], height[st.peek()]);
                    result+= ((minWall-height[popped])*(i-st.peek()-1));
                }
            }
            st.push(i);
        }
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we use tow pointers from left end and right end, and use the vlaues as left and right wall
// we keep iterating from one direction until the other side height is not less than this side pointer height
// to calculate water that can be trapped.

class Solution {
    public int trap(int[] height) {
        int result=0;
        int l=0; int r=height.length-1;
        int lw=0; int rw=0;
        while(l<=r){
            if(lw<rw){
                if(lw>height[l]){
                    result+=lw-height[l];
                }
                else{
                    lw=height[l];
                }
                l++;
            }
            else{
                if(rw>height[r]){
                    result+=rw-height[r];
                }
                else{
                    rw=height[r];
                }
                r--;
            }
        }
        return result;
    }
}