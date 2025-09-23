/* 
Time Complexity: O(n)
   - Each index visited at most once using two pointers.

Space Complexity: O(1)
   - Constant extra space for pointers and boundary variables.

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// - Use two pointers (l, r) starting from ends, with lmax and rmax tracking max heights seen so far.
// - At each step, the smaller boundary (lmax vs rmax) determines the water trapped at that position.
// - If lmax < rmax:
//     * Water trapped at l = lmax - height[l], then move l++.
// - Else:
//     * Water trapped at r = rmax - height[r], then move r--.
// - Continue until l and r meet. Sum up trapped water.

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int lmax = 0, rmax = 0;
        int ans = 0;

        while(l < r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

// The smaller of lmax and rmax determines the water level at that position.
            if(lmax < rmax){
                // If the left boundary is smaller, water trapped at l depends on lmax.
                ans = ans + (lmax - height[l]);
                l++;
            }else{
            // If the right boundary is smaller or equal, water trapped at r depends on rmax
                ans = ans + (rmax - height[r]);
                r--;
            }
        }
        return ans;
    }
}
