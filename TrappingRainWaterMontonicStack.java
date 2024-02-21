/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(n)
* 
*/
import java.util.Stack;

public class TrappingRainWaterMontonicStack {
        public int trap(int[] height) {
            Stack<Integer> st = new Stack<>();
    
            int n = height.length;
    
            int waterTrapped = 0;
    
            for(int index = 0; index < n; index++){
                while(!st.isEmpty() && height[st.peek()] <= height[index]){
                    int poppedWallIdx = st.pop();
    
                    if(!st.isEmpty()){
                        int distance = index - st.peek() - 1;
    
                        int minWall = Math.min(height[st.peek()], height[index]);
                    
                        waterTrapped += ((minWall - height[poppedWallIdx]) * distance);
                    }
                }
    
                st.push(index);
            }
    
            return waterTrapped;
        }
    }
