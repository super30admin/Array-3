// Time: O(N) | Space: O(1)

class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lw = 0;
        int rw = 0;
        int result = 0;
        // until left right crosses each other, keep moving the pointer from both the directions
        // upon whichever side the wall is smaller the other
        while (l <= r) {
            if (lw <= rw) {
                if (lw < height[l]) {
                    lw = height[l];
                } else {
                    result += lw - height[l];
                }
                l++;
            } else {
                if (rw < height[r]) {
                    rw = height[r];
                } else {
                    result += rw - height[r];
                }
                r--;
            }
        }
        return result;
    }
}


//Brute force finding maxIndex
class Solution {
    public int trap(int[] height) {
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                maxIndex = i;
            }
        }
        int lw = 0;
        int result = 0;
        for (int l = 1; l < maxIndex; l++) {
            if (height[lw] > height[l]) {
                result += height[lw] - height[l];
            } else {
                lw = l;
            }
        }
        int rw = height.length - 1;
        for (int r = height.length - 2; r > maxIndex; r--) {
            if (height[rw] > height[r]) {
                result += height[rw] - height[r];
            } else {
                rw = r;
            }
        }
        System.out.println(result);
        return result;
    }
}