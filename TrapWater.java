/*The idea is very simple. Begin scan from beginning and end of array. Compare value of left and right pointer, store bigger pointer value and computer area for bigger pointer.
 * continue process till left pointer and right pointer crosses each other*/
//tc:o(n)
//sc:o(1)
public class TrapWater {
	
	public int trap(int[] height) {
		int secHight = 0;
		int left = 0;
		int right = height.length - 1;
		int area = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				secHight = Math.max(height[left], secHight);
				area += secHight - height[left];
				left++;
			} else {
				secHight = Math.max(height[right], secHight);
				area += secHight - height[right];
				right--;
			}
		}
		return area;
	}

}
