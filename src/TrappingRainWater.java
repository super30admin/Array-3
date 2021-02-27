
/*
 * The complexity of the algorithm is O(n) where n is no of elements in array.
 * 
 */

public class TrappingRainWater {

	public int trap(int[] height) {

		// edge
		if (height == null || height.length == 0)
			return 0;

		int result = 0;
		int lw = 0;
		int rw = 0;
		int n = height.length;
		int l = 0;
		int r = n - 1;

		while (l <= r) {

			if (lw <= rw) {

				if (height[l] < lw) {

					result += 1 * (lw - height[l]);

				} else {

					lw = height[l];

				}

				l++;

			} else {

				if (height[r] < rw) {

					result += 1 * (rw - height[r]);

				} else {

					rw = height[r];
				}

				r--;

			}

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
