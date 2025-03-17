/*
 * TC: O(n)
 * SC: O(1)
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int l = height.length;
        if (l <= 1) return 0;
        int left = 0, right = l - 1;
        int lMax = height[left], rMax = height[right];
        int total = 0;
        while (left < right) {
            // the smaller building will determine the rainwater trapped

            // in both cases, if the height is greater than the max, update the max
            // if it is less than the max, update total with the difference between max and height
            // move the index by one
            if(height[left] < height[right]) {
                if (lMax < height[left]) lMax = height[left];
                else total += lMax - height[left];
                left++;
            }
            else {
                if (rMax < height[right]) rMax = height[right];
                else total += rMax - height[right];
                right--;
            }
        }
        return total;
    }
}
