class Solution {
    public int trap(int[] height) {

        int maxIdx = 0;
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] >= height[maxIdx]) {
                maxIdx = i;
            }
        }
        //left to write 
        int lw = 0;
        int i = 0;
        while (i < maxIdx) {
            if (height[i] < lw) {
                result += lw - height[i];
            } else {
                lw = height[i];
            }
            i++;
        }

        int rw = 0;
        i = height.length - 1;
        while (i > maxIdx) {
            if (height[i] < rw) {
                result += rw - height[i];
            } else {
                rw = height[i];
            }
            i--;
        }

        return result;

    }

    public int trap_bruteForce(int[] height) {

        int ans = 0;

        for (int i = 1; i < height.length; i++) {
            int rightMax = 0;
            int leftMax = 0;

            for (int j = i; j >= 0; j--) {
                //get leftMax
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int k = i; k < height.length; k++) {
                //get rightMax
                rightMax = Math.max(rightMax, height[k]);

            }

            ans += Math.min(rightMax, leftMax) - height[i];
        }

        return ans;
    }
}