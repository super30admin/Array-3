//TC: O(n)
//SC: O(1)
//approach: two pointers

public class TrapRainWater {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;
        int count = 0;

        while (i < j) {
            leftmax = Math.max(leftmax, height[i]);
            rightmax = Math.max(rightmax, height[j]);
            if (leftmax < rightmax) {
                count += (leftmax - height[i]);
                i++;
            } else {
                count += (rightmax - height[j]);
                j--;
            }
        }
        return count;
    }
}
