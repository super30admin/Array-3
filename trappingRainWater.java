// TC: O(N) where is length of given heights array
// SC: O(N) since we are using extra array to store left and right water heights

public class trappingRainWater {

	public int trapWater(int[] height) {
		
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
		
		for(int i=0;i<height.length;i++) {
			maxLeft = Math.max(maxLeft, height[i]);  // retrieve the maximum value of height of water with base
			left[i] = maxLeft - height[i]; // store the heights of the water levels from left side where water can be stored,
			// subtracting the maxLeft from height will give us the container size where our water level can be stored, if we just keep considering the maximum height
			// we will end up having heights where we can not store water,
		}
		// traverse the array from right to store the maximum heights of water level which can be used to store water 
		for(int i=height.length-1;i>=0;i--) {
			maxRight = Math.max(maxRight, height[i]);  // retrieve the maximum height level in the array till that point
			right[i] = maxRight - height[i]; // keep subtrating the max value with given height which will help us retrieve the water 
			// container size which can be used to store the water
		}
		
		int min = 0;
		
		for(int i=0;i<height.length;i++) {
			min += Math.min(left[i], right[i]);// take the minimum of left and right so that we know the container size which will store water
			// because to store water, we need to have equal size on both side and for that, we need to consider min value
		}
		return min;		 // return the min value calculated from both left and right
	}
	
	public static void main(String[] args) {
		
		trappingRainWater trw = new trappingRainWater();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trw.trapWater(height));
	}
}
