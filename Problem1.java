// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * To trap the water, we need a U-shaped trend between the bars. We can take the
 * bar with max height to be the right-most wall or trap and calculate the water that
 * can be trapped in the left half. Similarly, the max height bar will act as a left-most
 * wall or trap, and we can calculate the water that can be trapped in the right half.
 */




public class Problem1 {
    public int trap(int[] height) {
        int n = height.length;
        int maxIdx = 0;
        int max = 0;

        int res = 0;

        for(int i = 0; i<n; i++) {
            if(height[i] > max) {
                max = height[i];
                maxIdx = i;
            }
        }

        int l=0; int lw = 0; //lw is the initial height, therefore 0
        while(l < maxIdx) {
            if(lw > height[l]) {
                res += lw - height[l];
            } else {
                lw = height[l];
            }

            l++;
        }

        int r = n-1; int rw = 0; //rw is the initial height, therefore 0
        while(r > maxIdx) {
            if(rw > height[r]) {
                res += rw - height[r];
            } else {
                rw = height[r];
            }

            r--;
        }

        return res;

    }
}
