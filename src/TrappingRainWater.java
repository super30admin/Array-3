/**
 * 
 */

/**
 * @author Aditya Sinha
 * 
 * use two pointers from both ends and keep track of the tallest walls on each side.
 * At each step, process the side with the smaller wall since that determines water trapping.
 * add trapped water if current height is less than the known max wall on that side.
 *
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 * 
 */
public class TrappingRainWater {
	public int trap(int[] height) {
        int n = height.length;

        int lw = 0, l = 0;
        int rw = n - 1, r = n - 1;
        int result = 0;

        while(l <= r) {
            if(height[rw] > height[lw]) { // if we have a bigger right wall, just process about the left wall
                if(height[lw] > height[l]) {
                    result += height[lw] - height[l];
                } else {
                    lw = l;
                }
                l++;
            } else { // if we have a bigger left wall, just process about the right wall
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
}
