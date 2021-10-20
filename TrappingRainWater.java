package Array3;
// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

public class TrappingRainWater {
    public int trap(int[] height) {
        int lw = 0, rw = 0;
        int left = 0, right = height.length-1;
        int total = 0;
        while(left <= right){
            if(lw <= rw){
                if(lw < height[left]){
                    lw = height[left];
                } else {
                    total += lw - height[left];
                }
                left++;
            } else {
                if(rw < height[right]){
                    rw = height[right];
                } else {
                    total += rw - height[right];
                }
                right--;
            }
        }
        return total;
    }
}
