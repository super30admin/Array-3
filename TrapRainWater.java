class Solution {

    /**
     Left wall higher than next pointer -> trap. This will fail after the high point.
     Do second pass from right with right wall and next pointer.
     TC: O(n)
     SC: O(1)

     */
    public int trap(int[] height) {
        //1. Find max height
        int max = height[0];
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        //2. Left pass to trap water till max
        int p1 = 0; // left wall
        int result = 0;
        for (int i = 1; i <= maxIndex; i++) {
            if (height[p1] > height[i]) {
                //trap
                result += height[p1] - height[i]; // substract heights
            } else {
                p1 = i; // remember to update indexes not heights
            }
        }

        //3. RIght pass to trap water till max
        int p2 = height.length - 1; // left wall
        for (int i = height.length - 2; i >= maxIndex; i--) {
            if (height[p2] > height[i]) {
                //trap
                result += height[p2] - height[i];
            } else {
                p2 = i;
            }
        }

        return result;
    }
}
