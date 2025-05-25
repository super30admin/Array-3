// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use two pointers (left and right) to track walls from both ends.
//   - Maintain the left and right wall pointers (lw, rw) pointing to the tallest bar so far.
//   - If left wall is shorter, compute trapped water at left.
//   - If right wall is shorter, compute trapped water at right.
//   - Move pointers accordingly while accumulating trapped water.

public class TrappingRainWater {
    // public int trap(int[] height) {
    //     //2 pointer approach
    //     int n = height.length;
    //     if(n == 0)  return 0;   //return 0 if empty input array
    //     int left = 0, right = n - 1;    //setting 2 pointers
    //     int leftmax = height[0];    //max height from left
    //     int rightmax = height[n - 1];   //max height from right
    //     int ans = 0;    //ans variable

    //     while(left <= right) {  //loop till left and right cross each other
    //         //check which side has minimum height
    //         if(leftmax < rightmax) {    //if left side has smaller
    //             if(height[left] > leftmax) {    //check left bar height is greater than current leftmax
    //                 leftmax = height[left]; //change if yes
    //             } else {
    //                 ans += leftmax - height[left];  //else add difference to ans
    //                 left++; //increment left ptr
    //             }
    //         } else {    //right side has smaller
    //             if(height[right] > rightmax) {  //check right bar height is greater than current rightmax
    //                 rightmax = height[right];   //change if yes
    //             } else {
    //                 ans += rightmax - height[right];    //else add difference to ans
    //                 right--;    //increment right ptr
    //             }
    //         }
    //     }

    //     return ans; //return ans
    // }

    // //2 pass using 2 ptrs
    // public int trap(int[] height) {
    //     int n = height.length;
    //     int max = 0;
    //     int maxIdx = -1;

    //     for(int i = 0; i < n; i++) {
    //         if(height[i] > max) {
    //             max = height[i];
    //             maxIdx = i;
    //         }
    //     }

    //     int result = 0;

    //     int lw = 0, l = 0;  //max height left wall and l= curr wall
    //     while(l < maxIdx) {
    //         if(height[i])
    //     }
    // }

    //1 pass - Best solution, TC = O(n), SC = O(1)
    public int trap(int[] height) {
        int n = height.length;
        int lw = 0, l = 0;
        int rw = n-1, r = n-1;
        int result = 0;

        while(l <= r) {
            if(height[lw] < height[rw]) {   //means we have bigger right wall just worry about left part
                if(height[lw] > height[l]) {
                    result += height[lw] - height[l];
                } else {
                    lw = l;
                }
                l++;
            } else {    //we do have bigger left wall, just worry about right wall
                if(height[rw] > height[r]) {
                    result += height[rw] - height[r];
                } else {
                    rw = r;
                }
                r--;
            }
        }

        return result;
    }

    // //using stack - TC = O(2n), SC = O(n), Monotonically Increasing Stack Pattern
    // public int trap(int[] height) {
    //     int n = height.length;
    //     int result = 0;

    //     Stack<Integer> st = new Stack<>();

    //     for(int i = 0; i < n; i++) {
    //         while(!st.isEmpty() && height[i] > height[st.peek()]) {
    //             int popped = st.pop();
    //             if(!st.isEmpty()) {
    //                 int width = i - st.peek() - 1;
    //                 int effectiveHeight = Math.min(height[i], height[st.peek()]);
    //                 result += width * (effectiveHeight - height[popped]);
    //             }
    //         }
    //         st.push(i);
    //     }

    //     return result;
    // }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = obj.trap(height);
        System.out.println("Trapped rain water: " + result);
        // Expected: 6
    }
}
