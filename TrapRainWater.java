package week10.day1;
//TC - O(n)
//SC - O(1)
class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length-1;
        int leftwall = i;
        int rightwall = j;
        int maxWater = 0;
        while(leftwall < rightwall){
            if(height[leftwall] <= height[rightwall]){
                if(height[i] >= height[leftwall])
                    leftwall = i;
                else
                    //process
                    maxWater = maxWater+ (height[leftwall] - height[i])*1;
                i++;
            }
            else{
                if(height[j] >= height[rightwall])
                    rightwall = j;
                else
                    //process
                    maxWater = maxWater+ (height[rightwall] - height[j])*1;
                j--;
                }
        }
        return maxWater;
    }
}
public class TrapRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		Solution s1 = new Solution();
		System.out.println(s1.trap(height));
	}

}
