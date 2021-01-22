// O(N), O(1)
class Solution {
    public int trap(int[] heights) {
        int leftMax = 0;
		int rightMax = 0;
		int[] leftHeights = new int[heights.length];
		int[] rightHeights = new int[heights.length];
    
		for(int i=0;i<heights.length;i++) {
			leftHeights[i] = leftMax;
			leftMax = Math.max(leftMax, heights[i]);
		}
		
		for(int i=heights.length-1;i>=0;i--) {
			rightHeights[i] = rightMax;
			rightMax = Math.max(rightMax, heights[i]);
		}
		
		int[] w = new int[heights.length];
		for(int i=0;i<heights.length;i++) {
			int minHeight = Math.min(leftHeights[i], rightHeights[i]);
			if(minHeight>heights[i]) {
				w[i] = minHeight - heights[i];
			}
			else {
				w[i] = 0;
			}
		}
		int res = 0;
		for(int i=0;i<w.length;i++){
			res += w[i];
		}
		return res;
    }
}
