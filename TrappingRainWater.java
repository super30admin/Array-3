/**
 * Time Complexity: O(n), where n is size of height array
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * The water trapped at an index is determined by lw - height[left], as lw is the max height encountered so far from the left.
 * Think of the left wall (lw) as the highest barrier encountered so far when moving from left to right.
 * Similarly, the right wall (rw) is the highest barrier encountered when moving from right to left.
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int lw = 0;
        int rw = 0;
        int left = 0;
        int right = height.length - 1;
        int total = 0;

        while (left <= right) {
            if (lw <= rw) {
                int h = height[left];
                if (h < lw) {
                    total += lw - h;
                } else {
                    lw = h;
                }
                left++;
            } else {
                int h = height[right];
                if (h < rw) {
                    total += rw - h;
                } else {
                    rw = h;
                }
                right--;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        // Your code here
        TrappingRainWater obj = new TrappingRainWater();
        int volume = obj.trap(new int[] {4,2,0,3,2,5});
        System.out.println(volume);
        assert(volume == 9);
    }
}