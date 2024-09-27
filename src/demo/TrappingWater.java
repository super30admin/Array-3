package demo;

//Time : O(n)
//Space : O(1)
//Leetcode : yes
//instead of using extra space for left and right array,solve in constant space

public class TrappingWater {
	public int trap(int[] height) {
		if(height.length==0) return 0;
		int ans =0;
		int low=0;
		int high = height.length -1;

		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		//checking the minimum from lft and right side
		//using low and high pointers until they cross
		while(low<high){
			leftMax = Math.max(leftMax, height[low]);
			rightMax = Math.max(rightMax, height[high]);

			if(leftMax < rightMax){
				ans += leftMax - height[low];
				low++;
			}else{
				ans += rightMax - height[high];
				high--;
			}
		}
		return ans;
	}
}