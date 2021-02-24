// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Assign 4 pointers, left and right will denote the potential highest wall to the left and the right. Pointers l and r will be used to iterate and find the area if the height at those pointers is smaller than their respective walls.

public class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0; 
        
        int n = height.length;
        int left = 0;
        int right = n - 1;
        
        int l = 0;
        int r = n - 1;
        
        int area = 0;
        while(l <= r){
            if(height[left] <= height[right]){
                if(height[left] > height[l]){
                    area = area + (height[left] - height[l]);
                } else{
                    left = l;
                }
                l++;
            } else {
                if(height[right] > height[r]){
                    area = area + (height[right] - height[r]);
                } else{
                    right = r;
                }
                r--;
            }
        }
        return area;
    }
}
